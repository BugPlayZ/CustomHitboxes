package net.vatality.customhitboxes;

import java.util.List;
import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;

public class CustomHitBoxesAddon extends LabyModAddon {

  @Override
  public void onEnable() {
    CustomHitBoxes.ADDON.load(this);
  }

  @Override
  public void loadConfig() {

  }

  @Override
  protected void fillSettings(List<SettingsElement> list) {
    CustomHitBoxes.ADDON.getSettingsController().fillSettings(list);
  }
}
