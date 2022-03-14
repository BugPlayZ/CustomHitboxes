package net.vatality.customhitboxes.renderer;

import java.awt.Color;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;

public class HitBoxRenderer {

  public static void renderBoundingBox(Entity entity, double x, double y, double z, Color color) {
    renderBoundingBox(entity, x, y, z, color.getRed(), color.getGreen(), color.getBlue(),
        color.getAlpha());
  }

  public static void renderBoundingBox(Entity entity, double x, double y, double z, int red,
      int green,
      int blue, int alpha) {
    GlStateManager.pushMatrix();
    GlStateManager.disableTexture2D();
    GlStateManager.disableLighting();
    GlStateManager.disableCull();
    GlStateManager.enableBlend();
    GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);

    AxisAlignedBB boundingBox = entity.getCollisionBoundingBox();
    double width = boundingBox.maxX - boundingBox.minX;
    double height = boundingBox.maxY - boundingBox.minY;
    RenderGlobal.drawOutlinedBoundingBox(
        new AxisAlignedBB(x, y, z, x + width, y + height, z + width)
            .offset(-width / 2.0D, 0.0D, -width / 2.0D), red, green, blue, alpha);

    GlStateManager.enableCull();
    GlStateManager.enableLighting();
    GlStateManager.enableTexture2D();
    GlStateManager.disableBlend();
    GlStateManager.popMatrix();
  }
}
