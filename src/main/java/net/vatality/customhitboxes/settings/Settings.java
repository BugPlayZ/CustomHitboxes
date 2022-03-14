package net.vatality.customhitboxes.settings;

import java.awt.Color;
import net.vatality.customhitboxes.hitbox.HitBox;
import net.vatality.customhitboxes.hitbox.HitBox.Type;

public class Settings {

  private final HitBox.Type hitBoxType;
  private final Settings.Type settingsType;
  public Object value;

  public Settings(HitBox.Type hitBoxType,
      Type settingsType, Object value) {
    this.hitBoxType = hitBoxType;
    this.settingsType = settingsType;
    this.value = value;
  }

  public HitBox.Type getHitBoxType() {
    return hitBoxType;
  }

  public Type getSettingsType() {
    return settingsType;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public enum Type {
    ENABLED(true),
    CUSTOM(false),
    COLOR(Color.WHITE),
    RED(255),
    GREEN(255),
    BLUE(255),
    ALPHA(255);

    private final Object defaultValue;

    Type(Object defaultValue) {
      this.defaultValue = defaultValue;
    }

    public Object getDefaultValue() {
      return defaultValue;
    }
  }

}
