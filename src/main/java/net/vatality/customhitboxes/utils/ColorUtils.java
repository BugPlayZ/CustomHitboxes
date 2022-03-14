package net.vatality.customhitboxes.utils;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import net.vatality.customhitboxes.hitbox.HitBox;
import net.vatality.customhitboxes.hitbox.HitBox.Type;

public class ColorUtils {

  public static Map<Type, Color> HIT_BOX_COLORS = new HashMap<>();

  public static void updateColor(Type type, Color color) {
    HIT_BOX_COLORS.put(type, color);
  }

  public static Color getColor(Type type) {
    return HIT_BOX_COLORS.getOrDefault(type, new Color(255, 255, 255, 255));
  }

}
