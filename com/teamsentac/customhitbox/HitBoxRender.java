package com.teamsentac.customhitbox;

import java.util.ArrayList;

import net.labymod.api.events.RenderEntityEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HitBoxRender implements RenderEntityEvent {

	
	private ArrayList<Entity> PlayerList = new ArrayList<Entity>();

    private void renderBoundingBox(Entity entity, double x, double y, double z, int red, int green, int blue, int alpha)
    {
    
      GlStateManager.pushMatrix();
      GlStateManager.disableTexture2D();
      GlStateManager.disableLighting();
      GlStateManager.disableCull();
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      
      
      AxisAlignedBB boundingBox = entity.getEntityBoundingBox();
      double width = boundingBox.maxX - boundingBox.minX + 0.15;
      double height = boundingBox.maxY - boundingBox.minY;
      RenderGlobal.drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + width, y + height, z + width).offset(-width / 2.0D, 0.0D, -width / 2.0D), red, green, blue, alpha);
      
      
      GlStateManager.enableCull();
      GlStateManager.enableLighting();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GlStateManager.popMatrix();
      
    }

	@Override
	public void onRender(Entity entity, double x, double y, double z, float arg4) {
		if(entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if(!player.isPotionActive(Potion.invisibility.getId()) && !player.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer)) {
				int red = CustomHitBox.pRED.getValue();
				int green = CustomHitBox.pGREEN.getValue();
				int blue = CustomHitBox.pBLUE.getValue();
				int alpha = CustomHitBox.pALPHA.getValue();
				if(CustomHitBox.enabled)
					if(!CustomHitBox.custom)
						renderBoundingBox(entity, x, y, z, red, green, blue, alpha);
					else {
						red = CustomHitBox.pcRED.getValue();
						green = CustomHitBox.pcGREEN.getValue();
						blue = CustomHitBox.pcBLUE.getValue();
						alpha = CustomHitBox.pcALPHA.getValue();
						renderBoundingBox(entity, x, y, z, red, green, blue, alpha);
					}
			}
		}else if(entity instanceof EntityItem) {
			int red = CustomHitBox.ieRED.getValue();
			int green = CustomHitBox.ieGREEN.getValue();
			int blue = CustomHitBox.ieBLUE.getValue();
			int alpha = CustomHitBox.ieALPHA.getValue();
			if(CustomHitBox.enabled) {
				if(!CustomHitBox.custom)
					renderBoundingBox(entity, x, y, z, red, green, blue, alpha);
				else {
					red = CustomHitBox.iecRED.getValue();
					green = CustomHitBox.iecGREEN.getValue();
					blue = CustomHitBox.iecBLUE.getValue();
					alpha = CustomHitBox.iecALPHA.getValue();
					renderBoundingBox(entity, x, y, z, red, green, blue, alpha);
				}
			}
		}else if(entity.isInvisible()) {
			int red = CustomHitBox.invisRED.getValue();
			int green = CustomHitBox.invisGREEN.getValue();
			int blue = CustomHitBox.invisBLUE.getValue();
			int alpha = CustomHitBox.invisALPHA.getValue();
			if(CustomHitBox.enabled)
				if(!CustomHitBox.custom)
					renderBoundingBox(entity, x, y, z, red, green, blue, alpha);
				else {
					red = CustomHitBox.inviscRED.getValue();
					green = CustomHitBox.inviscGREEN.getValue();
					blue = CustomHitBox.inviscBLUE.getValue();
					alpha = CustomHitBox.inviscALPHA.getValue();
					renderBoundingBox(entity, x, y, z, red, green, blue, alpha);
				
				}
		}else {
			int red = CustomHitBox.oeRED.getValue();
			int green = CustomHitBox.oeGREEN.getValue();
			int blue = CustomHitBox.oeBLUE.getValue();
			int alpha = CustomHitBox.oeALPHA.getValue();
			if(CustomHitBox.enabled) {
				if(!CustomHitBox.custom)
					renderBoundingBox(entity, x, y, z, red, green, blue, alpha);
				else {
					red = CustomHitBox.oecRED.getValue();
					green = CustomHitBox.oecGREEN.getValue();
					blue = CustomHitBox.oecBLUE.getValue();
					alpha = CustomHitBox.oecALPHA.getValue();
					renderBoundingBox(entity, x, y, z, red, green, blue, alpha);
				}
			}
		}
	}

}
