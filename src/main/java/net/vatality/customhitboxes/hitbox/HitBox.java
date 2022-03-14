package net.vatality.customhitboxes.hitbox;

import java.awt.Color;

public class HitBox {

  private final String name;
  private final Color color;

  public HitBox(String name, int red, int green, int blue, int alpha) {
    this.name = name;
    this.color = new Color(red, green, blue, alpha);
  }

  public HitBox(String name, Color color) {
    this.name = name;
    this.color = color;
  }

  public enum Type {
    ITEM("item", 0, "Dropped Items"),
    PLAYER("player", 1, "Players"),
    FRIENDLY("friendly", 2, "Friendly entities (Villagers, etc.)"),
    MOB("mob", 3, "Mobs (Zombies, etc.)"),
    ANIMAL("animal", 4, "Animals (Cows, etc.)"),
    GENERAL("general", 5, "All other entities");

    private final String name;
    private final int id;
    private final String text;

    Type(String name, int id, String text) {
      this.name = name;
      this.id = id;
      this.text = text;
    }

    public String getName() {
      return this.name;
    }

    public int getId() {
      return this.id;
    }

    public String getText() {
      return this.text;
    }

    public static Type getFromId(int id) {
      for (Type type : values()) {
        if (type.id == id) {
          return type;
        }
      }

      return GENERAL;
    }

    public static Type getFromName(String name) {
      for (Type type : values()) {
        if (type.getName().equalsIgnoreCase(name)) {
          return type;
        }
      }

      return GENERAL;
    }

    public static Type getFromText(String text) {
      for (Type type : values()) {
        if (type.getText().equalsIgnoreCase(text)) {
          return type;
        }
      }

      return GENERAL;
    }
  }

}
