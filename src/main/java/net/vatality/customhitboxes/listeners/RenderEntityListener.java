package net.vatality.customhitboxes.listeners;

import java.awt.Color;
import net.labymod.api.events.RenderEntityEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.vatality.customhitboxes.hitbox.HitBox.Type;
import net.vatality.customhitboxes.renderer.HitBoxRenderer;
import net.vatality.customhitboxes.utils.ColorUtils;

public class RenderEntityListener implements RenderEntityEvent {

  @Override
  public void onRender(Entity entity, double x, double y, double z, float v3) {
    if (!(entity instanceof EntityPlayer)) {
      return;
    }

    Color color = ColorUtils.getColor(convertType(entity));
    HitBoxRenderer.renderBoundingBox(entity, x, y, z, color);
  }

  private Type convertType(Entity entity) {
    if (entity instanceof EntityPlayer) {
      return Type.PLAYER;
    }

    if (entity instanceof EntityItem) {
      return Type.ITEM;
    }

    if (entity instanceof EntityAgeable && !(entity instanceof EntityAnimal)) {
      return Type.FRIENDLY;
    }

    if (entity instanceof EntityAgeable) {
      return Type.ANIMAL;
    }

    return Type.GENERAL;
  }
}
