package net.vatality.customhitboxes.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configuration {

  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
  private static final JsonParser PARSER = new JsonParser();

  private final File file;

  private JsonObject fileContents = new JsonObject();

  public Configuration(File file) {
    this.file = file;

    String path = file.getAbsolutePath();
    String fileName = file.getName();
    String folders = path.replace(fileName, "");

    File folderFile = new File(folders);
    folderFile.mkdirs();

    if (!file.exists()) {
      try {
        file.createNewFile();

        try (FileWriter fileWriter = new FileWriter(file, false)) {
          fileWriter.write("{}");
          fileWriter.flush();
        }
      } catch (IOException ex) {
        ex.printStackTrace();
      }
      return;
    }

    try (FileReader fileReader = new FileReader(
        file); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
      StringBuilder tempJson = new StringBuilder();

      String line;
      while ((line = bufferedReader.readLine()) != null) {
        tempJson.append(line).append("\n");
      }

      fileContents = PARSER.parse(tempJson.toString()).getAsJsonObject();
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  public void setIfAbsent(String path, Object value) {
    if (!has(path)) {
      set(path, value);
    }
  }

  public void set(String path, Object value) {
    JsonObject jsonObject = this.fileContents;

    String[] paths = path.split("\\.");
    String name = path.split("\\.")[paths.length - 1];

    for (int i = 0; i < paths.length; i++) {
      if (i == paths.length - 1) {
        break;
      }

      if (!jsonObject.has(paths[i])) {
        jsonObject.add(paths[i], new JsonObject());
      }

      jsonObject = jsonObject.getAsJsonObject(paths[i]);
    }

    jsonObject.add(name, PARSER.parse(GSON.toJson(value)));
    this.save();
  }

  public Object get(String path, Class<?> type) {
    JsonObject jsonObject = fileContents;

    String[] paths = path.split("\\.");

    for (String string : paths) {
      if (!jsonObject.has(string)) {
        throw new IllegalArgumentException("Path does not exist");
      }

      if (jsonObject.get(string).isJsonPrimitive()) {
        return convert(jsonObject.getAsJsonPrimitive(string));
      }

      jsonObject = jsonObject.getAsJsonObject(string);
    }

    return GSON.fromJson(jsonObject, type);
  }

  public boolean has(String path) {
    JsonObject fileContents = this.fileContents;

    String[] paths = path.split("\\.");
    String name = path.split("\\.")[paths.length - 1];

    for (int i = 0; i < paths.length; i++) {
      if (i == paths.length - 1) {
        break;
      }

      if (!fileContents.has(paths[i])) {
        return false;
      }

      if (fileContents.get(paths[i]).isJsonPrimitive()) {
        return true;
      }

      fileContents = fileContents.getAsJsonObject(paths[i]);
    }

    return fileContents.has(name);
  }

  private void save() {
    try (FileWriter fileWriter = new FileWriter(file, false)) {
      fileWriter.write(GSON.toJson(this.fileContents));
      fileWriter.flush();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private Object convert(JsonPrimitive primitive) {
    if (primitive.isString()) {
      return primitive.getAsString();
    } else if (primitive.isNumber()) {
      return primitive.getAsBigInteger().longValue();
    } else if (primitive.isBoolean()) {
      return primitive.getAsBoolean();
    } else {
      throw new IllegalArgumentException("Unsupported primitive: " + primitive);
    }
  }
}