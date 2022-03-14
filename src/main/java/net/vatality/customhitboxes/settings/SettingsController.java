package net.vatality.customhitboxes.settings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.labymod.gui.elements.DropDownMenu;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.settings.elements.DropDownElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.settings.elements.SliderElement;
import net.labymod.utils.Material;
import net.vatality.customhitboxes.CustomHitBoxes;
import net.vatality.customhitboxes.configuration.Configuration;
import net.vatality.customhitboxes.hitbox.HitBox;
import net.vatality.customhitboxes.settings.Settings.Type;

public class SettingsController {

  private final Map<HitBox.Type, List<Settings>> settingsMap = new HashMap<>();
  private final Map<Settings.Type, SliderElement> sliderElements = new HashMap<>();
  private final Map<Settings.Type, BooleanElement> booleanElements = new HashMap<>();

  private HitBox.Type currentType;

  public void loadSettings() {
    Configuration configuration = CustomHitBoxes.ADDON.getConfig();

    currentType = HitBox.Type.getFromId(0);

    for (HitBox.Type hitBoxType : HitBox.Type.values()) {
      List<Settings> list = new ArrayList<>();

      for (Settings.Type settingsType : Settings.Type.values()) {
        list.add(new Settings(hitBoxType, settingsType, configuration
            .get("settings." + hitBoxType.getName() + "." + settingsType.name().toLowerCase(),
                Object.class)));
      }

      settingsMap.put(hitBoxType, list);
    }

    Settings.Type[] types = new Settings.Type[]{Type.RED, Type.GREEN, Type.BLUE, Type.ALPHA};

    for (Type type : types) {
      SliderElement sliderElement = new SliderElement(type.name(), new IconData(Material.WOOL));
      sliderElement.setMaxValue(255);
      sliderElement.setMinValue(0);
      sliderElement.setCurrentValue(255);

      sliderElements.put(type, sliderElement);
    }

    types = new Settings.Type[]{Type.ENABLED, Type.CUSTOM};

    for (Type type : types) {
      BooleanElement booleanElement = new BooleanElement(type.name(), new IconData(Material.LEVER));
      booleanElement
          .addCallback(newValue -> getSettingsByType(this.currentType, type).setValue(newValue));
      booleanElements.put(type, booleanElement);
    }
  }

  public void fillSettings(List<SettingsElement> list) {
    // DropDown-Menu
    DropDownMenu<String> dropDownMenu = new DropDownMenu<>("Type", 0, 0, 0, 0);

    List<String> dropdownValues = new ArrayList<>();
    for (HitBox.Type type : HitBox.Type.values()) {
      dropdownValues.add(type.getId(), type.getText());
    }

    dropDownMenu.fill(dropdownValues.toArray(new String[0]));
    DropDownElement<String> dropDownElement = new DropDownElement<>("Type", dropDownMenu);
    list.add(dropDownElement);

    dropDownMenu.setSelected(dropdownValues.get(0));
    dropDownElement.setChangeListener(value -> {
      currentType = HitBox.Type.getFromText(value);
      updateSliderElements(currentType);
    });

    // Enabled
    list.addAll(booleanElements.values());
  }

  private void updateSliderElement(HitBox.Type hitBoxType, Settings.Type settingsType) {
    SliderElement sliderElement = sliderElements.get(settingsType);

    if (sliderElement == null) {
      return;
    }

    Settings settings = getSettingsByType(hitBoxType, settingsType);
    sliderElement.setMaxValue(255);
    sliderElement.setMinValue(0);
    sliderElement.setCurrentValue((Integer) settings.getValue());
  }

  private void updateSliderElements(HitBox.Type hitBoxType) {
    Settings.Type[] types = new Settings.Type[]{Type.RED, Type.GREEN, Type.BLUE, Type.ALPHA};

    for (Type type : types) {
      updateSliderElement(hitBoxType, type);
    }
  }

  private void updateBooleanElement(HitBox.Type hitBoxType, Settings.Type settingsType) {
    BooleanElement booleanElement = booleanElements.get(settingsType);

    if (booleanElement == null) {
      return;
    }

    Settings settings = getSettingsByType(hitBoxType, settingsType);
    booleanElement.setSettingEnabled((Boolean) settings.getValue());
  }

  private void updateBooleanElements(HitBox.Type hitBoxType) {
    Settings.Type[] types = new Settings.Type[]{Type.ENABLED, Type.CUSTOM};

    for (Type type : types) {
      updateBooleanElement(hitBoxType, type);
    }
  }

  private Settings getSettingsByType(HitBox.Type hitBoxType, Settings.Type settingsType) {
    for (Settings settings : settingsMap.get(hitBoxType)) {
      if (settings.getSettingsType() == settingsType) {
        return settings;
      }
    }

    return null;
  }
}
