package net.vatality.customhitboxes.utils;

import java.awt.Color;
import net.vatality.customhitboxes.CustomHitBoxes;
import net.vatality.customhitboxes.configuration.Configuration;

public class ColorBuilder {
  private int red;
  private int green;
  private int blue;
  private int alpha;

  public ColorBuilder from(String configPath) {
    Configuration config = CustomHitBoxes.ADDON.getConfig();

    this.red = (int) config.get(configPath + ".red", Integer.class);
    this.green = (int) config.get(configPath + ".green", Integer.class);
    this.blue = (int) config.get(configPath + ".blue", Integer.class);
    this.alpha = (int) config.get(configPath + ".alpha", Integer.class);
    return this;
  }

  public ColorBuilder setRed(int red) {
    this.red = red;
    return this;
  }

  public ColorBuilder setGreen(int green) {
    this.green = green;
    return this;
  }

  public ColorBuilder setBlue(int blue) {
    this.blue = blue;
    return this;
  }

  public ColorBuilder setAlpha(int alpha) {
    this.alpha = alpha;
    return this;
  }

  public Color build() {
    return new Color(this.red, this.green, this.blue, this.alpha);
  }
}
