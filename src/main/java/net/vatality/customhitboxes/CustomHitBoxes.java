package net.vatality.customhitboxes;

import java.io.File;
import net.vatality.customhitboxes.configuration.Configuration;
import net.vatality.customhitboxes.hitbox.HitBox;
import net.vatality.customhitboxes.settings.Settings;
import net.vatality.customhitboxes.settings.SettingsController;

public enum CustomHitBoxes {
  ADDON;

  private Configuration config;
  private CustomHitBoxesAddon addon;
  private SettingsController settingsController;

  public void load(CustomHitBoxesAddon addon) {
    this.addon = addon;

    this.init();
    this.loadConfig();

    this.settingsController.loadSettings();
  }

  private void init() {
    this.config = new Configuration(new File("config/CustomHitBoxes.json"));
    this.settingsController = new SettingsController();
  }

  private void loadConfig() {
    for (HitBox.Type hitBoxType : HitBox.Type.values()) {
      for (Settings.Type settingsType : Settings.Type.values()) {
        this.config.setIfAbsent(
            "settings." + hitBoxType.getName() + "." + settingsType.name().toLowerCase(),
            settingsType.getDefaultValue());
      }
    }
  }

  public Configuration getConfig() {
    return config;
  }

  public CustomHitBoxesAddon getAddon() {
    return addon;
  }

  public SettingsController getSettingsController() {
    return settingsController;
  }
}
