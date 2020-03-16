package com.teamsentac.customhitbox;

import org.lwjgl.input.Keyboard;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class ToggleHitbox {
	
	@SubscribeEvent
	public void toggleHitbox(InputEvent.KeyInputEvent event) {
		if(CustomHitBox.toggleKey != -1) {
			if(Keyboard.isKeyDown(CustomHitBox.toggleKey)) {
				if(CustomHitBox.enabled) {
					CustomHitBox.enabled = false;
					CustomHitBox.addon.getConfig().addProperty("enabled", false);
				}else {
					CustomHitBox.enabled = true;
					CustomHitBox.addon.getConfig().addProperty("enabled", true);
				}
			}
		}
	}

}
