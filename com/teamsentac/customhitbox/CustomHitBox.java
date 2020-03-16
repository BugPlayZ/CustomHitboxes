package com.teamsentac.customhitbox;

import java.util.HashMap;
import java.util.List;

import com.teamsentac.customhitbox.colors.Color;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableMap;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import net.labymod.api.LabyModAddon;
import net.labymod.api.events.RenderEntityEvent;
import net.labymod.gui.elements.ColorPicker;
import net.labymod.gui.elements.DropDownMenu;
import net.labymod.ingamegui.enums.EnumModuleAlignment;
import net.labymod.main.LabyMod;
import net.labymod.main.lang.LanguageManager;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ColorPickerCheckBoxBulkElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.ControlElement.IconData;
import net.labymod.settings.elements.DropDownElement;
import net.labymod.settings.elements.KeyElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.settings.elements.SliderElement;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import net.labymod.utils.ModColor;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class CustomHitBox extends LabyModAddon{
	
	public static Color RED;
	private static SliderElement redSlider;
	public static Color GREEN;
	private static SliderElement greenSlider;
	public static Color BLUE;
	private static SliderElement blueSlider;
	public static Color ALPHA;
	private static SliderElement alphaSlider;
	
	public static Color cRED;
	private static SliderElement cRedSlider;
	public static Color cGREEN;
	private static SliderElement cGreenSlider;
	public static Color cBLUE;
	private static SliderElement cBlueSlider;
	public static Color cALPHA;
	private static SliderElement cAlphaSlider;
	
	public static Color pRED;
	private static SliderElement pRedSlider;
	public static Color pGREEN;
	private static SliderElement pGreenSlider;
	public static Color pBLUE;
	private static SliderElement pBlueSlider;
	public static Color pALPHA;
	private static SliderElement pAlphaSlider;
	
	public static Color pcRED;
	private static SliderElement pcRedSlider;
	public static Color pcGREEN;
	private static SliderElement pcGreenSlider;
	public static Color pcBLUE;
	private static SliderElement pcBlueSlider;
	public static Color pcALPHA;
	private static SliderElement pcAlphaSlider;
	
	public static Color ieRED;
	private static SliderElement ieRedSlider;
	public static Color ieGREEN;
	private static SliderElement ieGreenSlider;
	public static Color ieBLUE;
	private static SliderElement ieBlueSlider;
	public static Color ieALPHA;
	private static SliderElement ieAlphaSlider;
	
	public static Color iecRED;
	private static SliderElement iecRedSlider;
	public static Color iecGREEN;
	private static SliderElement iecGreenSlider;
	public static Color iecBLUE;
	private static SliderElement iecBlueSlider;
	public static Color iecALPHA;
	private static SliderElement iecAlphaSlider;
	
	public static Color oeRED;
	private static SliderElement oeRedSlider;
	public static Color oeGREEN;
	private static SliderElement oeGreenSlider;
	public static Color oeBLUE;
	private static SliderElement oeBlueSlider;
	public static Color oeALPHA;
	private static SliderElement oeAlphaSlider;
	
	public static Color oecRED;
	private static SliderElement oecRedSlider;
	public static Color oecGREEN;
	private static SliderElement oecGreenSlider;
	public static Color oecBLUE;
	private static SliderElement oecBlueSlider;
	public static Color oecALPHA;
	private static SliderElement oecAlphaSlider;
	
	public static Color invisRED;
	private static SliderElement invisRedSlider;
	public static Color invisGREEN;
	private static SliderElement invisGreenSlider;
	public static Color invisBLUE;
	private static SliderElement invisBlueSlider;
	public static Color invisALPHA;
	private static SliderElement invisAlphaSlider;
	
	public static Color inviscRED;
	private static SliderElement inviscRedSlider;
	public static Color inviscGREEN;
	private static SliderElement inviscGreenSlider;
	public static Color inviscBLUE;
	private static SliderElement inviscBlueSlider;
	public static Color inviscALPHA;
	private static SliderElement inviscAlphaSlider;
	
	/*public static boolean invisCustom;
	public static boolean othersCustom;
	public static boolean playersCustom;
	public static boolean itemsCustom;*/
	public static boolean custom;
	/*public static boolean players;
	public static boolean itemEntities;
	public static boolean otherEntities;
	public static boolean invisEntities;*/
	public static boolean enabled;
	
	public static String dropDown = "";
	
	public static int toggleKey;
	
	public static CustomHitBox addon;
	
	@Override
	protected void fillSettings(List<SettingsElement> settings) {;
	
	String[] array = { "Items", "Players", "Invisibles (Armor-Stands, etc.)", "Other Entities (Villagers, etc.)"};
	
	DropDownMenu<String> alignmentDropDownMenu = new DropDownMenu<String>( "Entity", 0, 0, 0, 0 ).fill(array);
	DropDownElement<String> alignmentDropDown = new DropDownElement<String>( "Entity", alignmentDropDownMenu );
	
	alignmentDropDownMenu.setSelected( "Items" );
	dropDown = "items";

	alignmentDropDown.setChangeListener( new Consumer<String>() {
		@Override
		public void accept( String string ) {
			if(string.equals("Items")) {
				dropDown = "items";
			    RED.setValue(ieRED.getValue());
			    GREEN.setValue(ieGREEN.getValue());
			    BLUE.setValue(ieBLUE.getValue());
			    ALPHA.setValue(ieALPHA.getValue());
			    cRED.setValue(iecRED.getValue());
			    cGREEN.setValue(iecGREEN.getValue());
			    cBLUE.setValue(iecBLUE.getValue());
			    cALPHA.setValue(iecALPHA.getValue());
			    
			    cRedSlider.setCurrentValue(cRED.getValue());
			    cGreenSlider.setCurrentValue(cGREEN.getValue());
			    cBlueSlider.setCurrentValue(cBLUE.getValue());
			    cAlphaSlider.setCurrentValue(cALPHA.getValue());
			}
			if(string.equals("Players")) {
				dropDown = "players";
			    RED.setValue(pRED.getValue());
			    GREEN.setValue(pGREEN.getValue());
			    BLUE.setValue(pBLUE.getValue());
			    ALPHA.setValue(pALPHA.getValue());
			    cRED.setValue(pcRED.getValue());
			    cGREEN.setValue(pcGREEN.getValue());
			    cBLUE.setValue(pcBLUE.getValue());
			    cALPHA.setValue(pcALPHA.getValue());
			    
			    cRedSlider.setCurrentValue(cRED.getValue());
			    cGreenSlider.setCurrentValue(cGREEN.getValue());
			    cBlueSlider.setCurrentValue(cBLUE.getValue());
			    cAlphaSlider.setCurrentValue(cALPHA.getValue());
			}
			if(string.equals("Invisibles (Armor-Stands, etc.)")) {
				dropDown = "invis";
			    RED.setValue(invisRED.getValue());
			    GREEN.setValue(invisGREEN.getValue());
			    BLUE.setValue(invisBLUE.getValue());
			    ALPHA.setValue(invisALPHA.getValue());
			    cRED.setValue(inviscRED.getValue());
			    cGREEN.setValue(inviscGREEN.getValue());
			    cBLUE.setValue(inviscBLUE.getValue());
			    cALPHA.setValue(inviscALPHA.getValue());
			    
			    cRedSlider.setCurrentValue(cRED.getValue());
			    cGreenSlider.setCurrentValue(cGREEN.getValue());
			    cBlueSlider.setCurrentValue(cBLUE.getValue());
			    cAlphaSlider.setCurrentValue(cALPHA.getValue());
			}
			if(string.equals("Other Entities (Villagers, etc.)")) {
				
				dropDown = "others";
			    RED.setValue(oeRED.getValue());
			    GREEN.setValue(oeGREEN.getValue());
			    BLUE.setValue(oeBLUE.getValue());
			    ALPHA.setValue(oeALPHA.getValue());
			    cRED.setValue(oecRED.getValue());
			    cGREEN.setValue(oecGREEN.getValue());
			    cBLUE.setValue(oecBLUE.getValue());
			    cALPHA.setValue(oecALPHA.getValue());
			    
			    cRedSlider.setCurrentValue(cRED.getValue());
			    cGreenSlider.setCurrentValue(cGREEN.getValue());
			    cBlueSlider.setCurrentValue(cBLUE.getValue());
			    cAlphaSlider.setCurrentValue(cALPHA.getValue());
			}
		}
	} );

	

	settings.add( alignmentDropDown );
	
	BooleanElement booleanElement = new BooleanElement( "Enabled", new ControlElement.IconData( Material.LEVER ), new Consumer<Boolean>() {
		@Override
		public void accept( Boolean accepted ) {
			if(dropDown.equals("items")) {
				enabled = accepted;
				//itemEntities = accepted;
				getConfig().addProperty("enabled", accepted);
		        saveConfig();
			}
			if(dropDown.equals("players")) {
				enabled = accepted;
				//CustomHitBox.players = accepted;
				getConfig().addProperty("enabled", accepted);
		        saveConfig();
			}
			if(dropDown.equals("invis")) {
				enabled = accepted;
				//invisEntities = accepted;
				getConfig().addProperty("enabled", accepted);
		        saveConfig();
			}
			if(dropDown.equals("others")) {
				enabled = accepted;
				//otherEntities = accepted;
				getConfig().addProperty("enabled", accepted);
		        saveConfig();
			}
		}
	}, enabled );
	
	settings.add(booleanElement);
	
	BooleanElement customBool = new BooleanElement( "Custom", new ControlElement.IconData( Material.LEVER ), new Consumer<Boolean>() {
		@Override
		public void accept( Boolean accepted ) {
			if(dropDown.equals("items")) {
				custom = accepted;
				//itemsCustom = accepted;
				getConfig().addProperty("custom", accepted);
		        saveConfig();
			}
			if(dropDown.equals("players")) {
				custom = accepted;
				//playersCustom = accepted;
				getConfig().addProperty("custom", accepted);
		        saveConfig();
			}
			if(dropDown.equals("invis")) {
				custom = accepted;
				//invisCustom = accepted;
				getConfig().addProperty("custom", accepted);
		        saveConfig();
			}
			if(dropDown.equals("others")) {
				custom = accepted;
				//othersCustom = accepted;
				getConfig().addProperty("custom", accepted);
		        saveConfig();
			}
		}
	}, custom );
	
	settings.add( customBool );
	
	/*settings.add( new BooleanElement( "Players only", new ControlElement.IconData( Material.LEVER ), new Consumer<Boolean>() {
		@Override
		public void accept( Boolean accepted ) {
			players = accepted;
			getConfig().addProperty("playersOnly", accepted);
	        saveConfig();
		}
	}, custom ) );*/
	
	/*settings.add(new KeyElement("Toggle Hitboxes", new IconData(Material.COMMAND), toggleKey, new Consumer<Integer>() {
		@Override
		public void accept(Integer accepted) {
			toggleKey = accepted;
			getConfig().addProperty("toggleKey", accepted);
			saveConfig();
		}
	}));*/
	
		ColorPickerCheckBoxBulkElement bulkElement = new ColorPickerCheckBoxBulkElement( "Colors" );
		bulkElement.setCheckBoxRightBound( true );

		ColorPicker colorPicker = new ColorPicker( "Hit-Box Color", new java.awt.Color(getConfig().get("red").getAsInt(), getConfig().get("green").getAsInt(), getConfig().get("blue").getAsInt()), new ColorPicker.DefaultColorCallback() {
		    @Override
		    public java.awt.Color getDefaultColor() {
		        return new java.awt.Color( RED.getValue(), GREEN.getValue(), BLUE.getValue() );
		    }
		}, 0, 0, 0, 0 );
		colorPicker.setHasDefault( false );

		colorPicker.setUpdateListener(new Consumer<java.awt.Color>() {
		    @Override
		    public void accept( java.awt.Color accepted ) {
		    	if(dropDown.equals("items")) {
		    		RED.setValue(accepted.getRed());
			        GREEN.setValue(accepted.getGreen());
			        BLUE.setValue(accepted.getBlue());
			        ALPHA.setValue(accepted.getAlpha());
			        ieRED.setValue(accepted.getRed());
			        ieGREEN.setValue(accepted.getGreen());
			        ieBLUE.setValue(accepted.getBlue());
			        ieALPHA.setValue(accepted.getAlpha());
			        
			        getConfig().addProperty("itemsRed", accepted.getRed());
			        getConfig().addProperty("itemsGreen", accepted.getGreen());
			        getConfig().addProperty("itemsBlue", accepted.getBlue());
			        getConfig().addProperty("itemsAlpha", accepted.getAlpha());
			        saveConfig();
				}
				if(dropDown.equals("players")) {
					RED.setValue(accepted.getRed());
			        GREEN.setValue(accepted.getGreen());
			        BLUE.setValue(accepted.getBlue());
			        ALPHA.setValue(accepted.getAlpha());
			        pRED.setValue(accepted.getRed());
			        pGREEN.setValue(accepted.getGreen());
			        pBLUE.setValue(accepted.getBlue());
			        pALPHA.setValue(accepted.getAlpha());
			        
			        getConfig().addProperty("playersRed", accepted.getRed());
			        getConfig().addProperty("playersGreen", accepted.getGreen());
			        getConfig().addProperty("playersBlue", accepted.getBlue());
			        getConfig().addProperty("playersAlpha", accepted.getAlpha());
			        saveConfig();
				}
				if(dropDown.equals("invis")) {
					RED.setValue(accepted.getRed());
			        GREEN.setValue(accepted.getGreen());
			        BLUE.setValue(accepted.getBlue());
			        ALPHA.setValue(accepted.getAlpha());
			        invisRED.setValue(accepted.getRed());
			        invisGREEN.setValue(accepted.getGreen());
			        invisBLUE.setValue(accepted.getBlue());
			        invisALPHA.setValue(accepted.getAlpha());
			        
			        getConfig().addProperty("invisRed", accepted.getRed());
			        getConfig().addProperty("invisGreen", accepted.getGreen());
			        getConfig().addProperty("invisBlue", accepted.getBlue());
			        getConfig().addProperty("invisAlpha", accepted.getAlpha());
			        saveConfig();
				}
				if(dropDown.equals("others")) {
					RED.setValue(accepted.getRed());
			        GREEN.setValue(accepted.getGreen());
			        BLUE.setValue(accepted.getBlue());
			        ALPHA.setValue(accepted.getAlpha());
			        oeRED.setValue(accepted.getRed());
			        oeGREEN.setValue(accepted.getGreen());
			        oeBLUE.setValue(accepted.getBlue());
			        oeALPHA.setValue(accepted.getAlpha());
			        
			        getConfig().addProperty("othersRed", accepted.getRed());
			        getConfig().addProperty("othersGreen", accepted.getGreen());
			        getConfig().addProperty("othersBlue", accepted.getBlue());
			        getConfig().addProperty("othersAlpha", accepted.getAlpha());
			        saveConfig();
				}
		        
		    }
		} );

		bulkElement.addColorPicker( colorPicker );
		
		settings.add( bulkElement );
		
		cRedSlider = new SliderElement("Custom Red", this, new IconData(Material.BANNER), "cRed", cRED.getValue());
		cRedSlider.setRange(0, 255);
		cRedSlider.addCallback(new Consumer<Integer>() {
			@Override
			public void accept(Integer accepted) {
				if(dropDown.equals("items")) {
					cRED.setValue(accepted);
			        iecRED.setValue(accepted);
			        
			        getConfig().addProperty("itemsCRed", accepted);
			        saveConfig();
				}
				if(dropDown.equals("players")) {
					cRED.setValue(accepted);
			        pcRED.setValue(accepted);
			        
			        getConfig().addProperty("playersCRed", accepted);
			        saveConfig();
				}
				if(dropDown.equals("invis")) {
					cRED.setValue(accepted);
			        inviscRED.setValue(accepted);
			        
			        getConfig().addProperty("invisCRed", accepted);
			        saveConfig();
				}
				if(dropDown.equals("others")) {
					cRED.setValue(accepted);
			        oecRED.setValue(accepted);
			        
			        getConfig().addProperty("othersCRed", accepted);
			        saveConfig();
				}
			}
		});
		settings.add(cRedSlider);
		
		cGreenSlider = new SliderElement("Custom Green", this, new IconData(Material.BANNER), "cGreen", cGREEN.getValue());
		cGreenSlider.setRange(0, 255);
		cGreenSlider.addCallback(new Consumer<Integer>() {
			@Override
			public void accept(Integer accepted) {
				if(dropDown.equals("items")) {
					cGREEN.setValue(accepted);
			        iecGREEN.setValue(accepted);
			        
			        getConfig().addProperty("itemsCGreen", accepted);
			        saveConfig();
				}
				if(dropDown.equals("players")) {
					cGREEN.setValue(accepted);
			        pcGREEN.setValue(accepted);
			        
			        getConfig().addProperty("playersCGreen", accepted);
			        saveConfig();
				}
				if(dropDown.equals("invis")) {
					cGREEN.setValue(accepted);
			        inviscGREEN.setValue(accepted);
			        
			        getConfig().addProperty("invisCGreen", accepted);
			        saveConfig();
				}
				if(dropDown.equals("others")) {
					cGREEN.setValue(accepted);
			        oecGREEN.setValue(accepted);
			        
			        getConfig().addProperty("othersCGreen", accepted);
			        saveConfig();
				}
			}
		});
		settings.add(cGreenSlider);
		
		cBlueSlider = new SliderElement("Custom Blue", this, new IconData(Material.BANNER), "cBlue", cBLUE.getValue());
		cBlueSlider.setRange(0, 255);
		cBlueSlider.addCallback(new Consumer<Integer>() {
			@Override
			public void accept(Integer accepted) {
				if(dropDown.equals("items")) {
					cBLUE.setValue(accepted);
			        iecBLUE.setValue(accepted);
			        
			        getConfig().addProperty("itemsCBlue", accepted);
			        saveConfig();
				}
				if(dropDown.equals("players")) {
					cBLUE.setValue(accepted);
			        pcBLUE.setValue(accepted);
			        
			        getConfig().addProperty("playersCBlue", accepted);
			        saveConfig();
				}
				if(dropDown.equals("invis")) {
					cBLUE.setValue(accepted);
			        inviscBLUE.setValue(accepted);
			        
			        getConfig().addProperty("invisCBlue", accepted);
			        saveConfig();
				}
				if(dropDown.equals("others")) {
					cBLUE.setValue(accepted);
			        oecBLUE.setValue(accepted);
			        
			        getConfig().addProperty("othersCBlue", accepted);
			        saveConfig();
				}
			}
		});
		settings.add(cBlueSlider);
		
		cAlphaSlider = new SliderElement("Custom Alpha", this, new IconData(Material.BANNER), "cAlpha", cALPHA.getValue());
		cAlphaSlider.setRange(0, 255);
		cAlphaSlider.addCallback(new Consumer<Integer>() {
			@Override
			public void accept(Integer accepted) {
				if(dropDown.equals("items")) {
					cALPHA.setValue(accepted);
			        iecALPHA.setValue(accepted);
			        
			        getConfig().addProperty("itemsCAlpha", accepted);
			        saveConfig();
				}
				if(dropDown.equals("players")) {
					cALPHA.setValue(accepted);
			        pcALPHA.setValue(accepted);
			        
			        getConfig().addProperty("playersCAlpha", accepted);
			        saveConfig();
				}
				if(dropDown.equals("invis")) {
					cALPHA.setValue(accepted);
			        inviscALPHA.setValue(accepted);
			        
			        getConfig().addProperty("invisCAlpha", accepted);
			        saveConfig();
				}
				if(dropDown.equals("others")) {
					cALPHA.setValue(accepted);
			        oecALPHA.setValue(accepted);
			        
			        getConfig().addProperty("othersCAlpha", accepted);
			        saveConfig();
				}
			}
		});
		settings.add(cAlphaSlider);
	}

	@Override
	public void loadConfig() {
		if(!getConfig().has("red")) {
			getConfig().addProperty("red", 255);
			saveConfig();
		}
		if(!getConfig().has("green")) {
			getConfig().addProperty("green", 0);
			saveConfig();
		}
		if(!getConfig().has("blue")) {
			getConfig().addProperty("blue", 0);
			saveConfig();
		}
		if(!getConfig().has("alpha")) {
			getConfig().addProperty("alpha", 255);
			saveConfig();
		}
		if(!getConfig().has("cRed")) {
			getConfig().addProperty("cRed", 255);
			saveConfig();
		}
		if(!getConfig().has("cGreen")) {
			getConfig().addProperty("cGreen", 255);
			saveConfig();
		}
		if(!getConfig().has("cBlue")) {
			getConfig().addProperty("cBlue", 255);
			saveConfig();
		}
		if(!getConfig().has("cAlpha")) {
			getConfig().addProperty("cAlpha", 255);
			saveConfig();
		}
		
		
		if(!getConfig().has("itemsRed")) {
			getConfig().addProperty("itemsRed", 255);
			saveConfig();
		}
		if(!getConfig().has("itemsGreen")) {
			getConfig().addProperty("itemsGreen", 0);
			saveConfig();
		}
		if(!getConfig().has("itemsBlue")) {
			getConfig().addProperty("itemsBlue", 0);
			saveConfig();
		}
		if(!getConfig().has("itemsAlpha")) {
			getConfig().addProperty("itemsAlpha", 255);
			saveConfig();
		}
		if(!getConfig().has("itemsCRed")) {
			getConfig().addProperty("itemsCRed", 255);
			saveConfig();
		}
		if(!getConfig().has("itemsCGreen")) {
			getConfig().addProperty("itemsCGreen", 255);
			saveConfig();
		}
		if(!getConfig().has("itemsCBlue")) {
			getConfig().addProperty("itemsCBlue", 255);
			saveConfig();
		}
		if(!getConfig().has("itemsCAlpha")) {
			getConfig().addProperty("itemsCAlpha", 255);
			saveConfig();
		}
		
		
		if(!getConfig().has("playersRed")) {
			getConfig().addProperty("playersRed", 255);
			saveConfig();
		}
		if(!getConfig().has("playersGreen")) {
			getConfig().addProperty("playersGreen", 0);
			saveConfig();
		}
		if(!getConfig().has("playersBlue")) {
			getConfig().addProperty("playersBlue", 0);
			saveConfig();
		}
		if(!getConfig().has("playersAlpha")) {
			getConfig().addProperty("playersAlpha", 255);
			saveConfig();
		}
		if(!getConfig().has("playersCRed")) {
			getConfig().addProperty("playersCRed", 255);
			saveConfig();
		}
		if(!getConfig().has("playersCGreen")) {
			getConfig().addProperty("playersCGreen", 255);
			saveConfig();
		}
		if(!getConfig().has("playersCBlue")) {
			getConfig().addProperty("playersCBlue", 255);
			saveConfig();
		}
		if(!getConfig().has("playersCAlpha")) {
			getConfig().addProperty("playersCAlpha", 255);
			saveConfig();
		}
		
		
		if(!getConfig().has("invisRed")) {
			getConfig().addProperty("invisRed", 255);
			saveConfig();
		}
		if(!getConfig().has("invisGreen")) {
			getConfig().addProperty("invisGreen", 0);
			saveConfig();
		}
		if(!getConfig().has("invisBlue")) {
			getConfig().addProperty("invisBlue", 0);
			saveConfig();
		}
		if(!getConfig().has("invisAlpha")) {
			getConfig().addProperty("invisAlpha", 255);
			saveConfig();
		}
		if(!getConfig().has("invisCRed")) {
			getConfig().addProperty("invisCRed", 255);
			saveConfig();
		}
		if(!getConfig().has("invisCGreen")) {
			getConfig().addProperty("invisCGreen", 255);
			saveConfig();
		}
		if(!getConfig().has("invisCBlue")) {
			getConfig().addProperty("invisCBlue", 255);
			saveConfig();
		}	
		if(!getConfig().has("invisCAlpha")) {
			getConfig().addProperty("invisCAlpha", 255);
			saveConfig();
		}
		
		
		if(!getConfig().has("othersRed")) {
			getConfig().addProperty("othersRed", 255);
			saveConfig();
		}
		if(!getConfig().has("othersGreen")) {
			getConfig().addProperty("othersGreen", 0);
			saveConfig();
		}
		if(!getConfig().has("othersBlue")) {
			getConfig().addProperty("othersBlue", 0);
			saveConfig();
		}
		if(!getConfig().has("othersAlpha")) {
			getConfig().addProperty("othersAlpha", 255);
			saveConfig();
		}
		if(!getConfig().has("othersCRed")) {
			getConfig().addProperty("othersCRed", 255);
			saveConfig();
		}
		if(!getConfig().has("othersCGreen")) {
			getConfig().addProperty("othersCGreen", 255);
			saveConfig();
		}
		if(!getConfig().has("othersCBlue")) {
			getConfig().addProperty("othersCBlue", 255);
			saveConfig();
		}
		if(!getConfig().has("othersCAlpha")) {
			getConfig().addProperty("othersCAlpha", 255);
			saveConfig();
		}
		
		
		if(!getConfig().has("playersCustom")) {
			getConfig().addProperty("playersCustom", false);
			saveConfig();
		}
		if(!getConfig().has("itemsCustom")) {
			getConfig().addProperty("itemsCustom", false);
			saveConfig();
		}
		if(!getConfig().has("othersCustom")) {
			getConfig().addProperty("othersCustom", false);
			saveConfig();
		}
		if(!getConfig().has("invisCustom")) {
			getConfig().addProperty("invisCustom", false);
			saveConfig();
		}
		if(!getConfig().has("playersEnabled")) {
			getConfig().addProperty("playersEnabled", false);
			saveConfig();
		}
		if(!getConfig().has("itemsEnabled")) {
			getConfig().addProperty("itemsEnabled", false);
			saveConfig();
		}
		if(!getConfig().has("othersEnabled")) {
			getConfig().addProperty("othersEnabled", false);
			saveConfig();
		}
		if(!getConfig().has("invisEnabled")) {
			getConfig().addProperty("invisEnabled", false);
			saveConfig();
		}
		if(!getConfig().has("enabled")) {
			getConfig().addProperty("enabled", false);
			saveConfig();
		}
		if(!getConfig().has("custom")) {
			getConfig().addProperty("custom", false);
			saveConfig();
		}
		
		
		
		RED.setValue(getConfig().has("red") ? getConfig().get("red").getAsInt() : 255);
		GREEN.setValue(getConfig().has("green") ? getConfig().get("green").getAsInt() : 255);
		BLUE.setValue(getConfig().has("blue") ? getConfig().get("blue").getAsInt() : 255);
		ALPHA.setValue(getConfig().has("alpha") ? getConfig().get("alpha").getAsInt() : 255);
		
		cRED.setValue(getConfig().has("cRed") ? getConfig().get("cRed").getAsInt() : 255);
		cGREEN.setValue(getConfig().has("cGreen") ? getConfig().get("cGreen").getAsInt() : 255);
		cBLUE.setValue(getConfig().has("cBlue") ? getConfig().get("cBlue").getAsInt() : 255);
		cALPHA.setValue(getConfig().has("cAlpha") ? getConfig().get("cAlpha").getAsInt() : 255);
		
		pRED.setValue(getConfig().has("playersRed") ? getConfig().get("playersRed").getAsInt() : 255);
		pGREEN.setValue(getConfig().has("playersGreen") ? getConfig().get("playersGreen").getAsInt() : 255);
		pBLUE.setValue(getConfig().has("playersBlue") ? getConfig().get("playersBlue").getAsInt() : 255);
		pALPHA.setValue(getConfig().has("playersAlpha") ? getConfig().get("playersAlpha").getAsInt() : 255);
			
		pcRED.setValue(getConfig().has("playersCRed") ? getConfig().get("playersCRed").getAsInt() : 255);
		pcGREEN.setValue(getConfig().has("playersCGreen") ? getConfig().get("playersCGreen").getAsInt() : 255);
		pcBLUE.setValue(getConfig().has("playersCBlue") ? getConfig().get("playersCBlue").getAsInt() : 255);
		pcALPHA.setValue(getConfig().has("playersCAlpha") ? getConfig().get("playersCAlpha").getAsInt() : 255);
			
		ieRED.setValue(getConfig().has("itemsRed") ? getConfig().get("itemsRed").getAsInt() : 255);
		ieGREEN.setValue(getConfig().has("itemsGreen") ? getConfig().get("itemsGreen").getAsInt() : 255);
		ieBLUE.setValue(getConfig().has("itemsBlue") ? getConfig().get("itemsBlue").getAsInt() : 255);
		ieALPHA.setValue(getConfig().has("itemsAlpha") ? getConfig().get("itemsAlpha").getAsInt() : 255);
			
		iecRED.setValue(getConfig().has("itemsCRed") ? getConfig().get("itemsCRed").getAsInt() : 255);
		iecGREEN.setValue(getConfig().has("itemsCGreen") ? getConfig().get("itemsCGreen").getAsInt() : 255);
		iecBLUE.setValue(getConfig().has("itemsCBlue") ? getConfig().get("itemsCBlue").getAsInt() : 255);
		iecALPHA.setValue(getConfig().has("itemsCAlpha") ? getConfig().get("itemsCAlpha").getAsInt() : 255);
			
		oeRED.setValue(getConfig().has("othersRed") ? getConfig().get("othersRed").getAsInt() : 255);
		oeGREEN.setValue(getConfig().has("othersGreen") ? getConfig().get("othersGreen").getAsInt() : 255);
		oeBLUE.setValue(getConfig().has("othersBlue") ? getConfig().get("othersBlue").getAsInt() : 255);
		oeALPHA.setValue(getConfig().has("othersAlpha") ? getConfig().get("othersAlpha").getAsInt() : 255);
			
		oecRED.setValue(getConfig().has("othersCRed") ? getConfig().get("othersCRed").getAsInt() : 255);
		oecGREEN.setValue(getConfig().has("othersCGreen") ? getConfig().get("othersCGreen").getAsInt() : 255);
		oecBLUE.setValue(getConfig().has("othersCBlue") ? getConfig().get("othersCBlue").getAsInt() : 255);
		oecALPHA.setValue(getConfig().has("othersCAlpha") ? getConfig().get("othersCAlpha").getAsInt() : 255);
			
		invisRED.setValue(getConfig().has("invisRed") ? getConfig().get("invisRed").getAsInt() : 255);
		invisGREEN.setValue(getConfig().has("invisGreen") ? getConfig().get("invisGreen").getAsInt() : 255);
		invisBLUE.setValue(getConfig().has("invisBlue") ? getConfig().get("invisBlue").getAsInt() : 255);
		invisALPHA.setValue(getConfig().has("invisAlpha") ? getConfig().get("invisAlpha").getAsInt() : 255);
		
		inviscRED.setValue(getConfig().has("invisCRed") ? getConfig().get("invisCRed").getAsInt() : 255);
		inviscGREEN.setValue(getConfig().has("invisCGreen") ? getConfig().get("invisCGreen").getAsInt() : 255);
		inviscBLUE.setValue(getConfig().has("invisCBlue") ? getConfig().get("invisCBlue").getAsInt() : 255);
		inviscALPHA.setValue(getConfig().has("invisCAlpha") ? getConfig().get("invisCAlpha").getAsInt() : 255);
		
		custom = getConfig().has("custom") ? getConfig().get("custom").getAsBoolean() : false;
		enabled = getConfig().has("enabled") ? getConfig().get("enabled").getAsBoolean() : true;
		/*itemsCustom = getConfig().has("itemsCustom") ? getConfig().get("itemsCustom").getAsBoolean() : false;
		playersCustom = getConfig().has("playersCustom") ? getConfig().get("playersCustom").getAsBoolean() : false;
		invisCustom = getConfig().has("invisCustom") ? getConfig().get("invisCustom").getAsBoolean() : false;
		othersCustom = getConfig().has("othersCustom") ? getConfig().get("othersCustom").getAsBoolean() : false;
		
		players = getConfig().has("playersEnabled") ? getConfig().get("playersEnabled").getAsBoolean() : false;
		itemEntities = getConfig().has("itemsEnabled") ? getConfig().get("itemsEnabled").getAsBoolean() : false;
		otherEntities = getConfig().has("othersEnabled") ? getConfig().get("othersEnabled").getAsBoolean() : false;
		invisEntities = getConfig().has("invisEnabled") ? getConfig().get("invisEnabled").getAsBoolean() : false;*/

	}

	@Override
	public void onEnable() {
		addon = this;
		
		RED = new Color("RED");
		GREEN = new Color("GREEN");
		BLUE = new Color("BLUE");
		ALPHA = new Color("ALPHA");
		cRED = new Color("cRED");
		cGREEN = new Color("cGREEN");
		cBLUE = new Color("cBLUE");
		cALPHA = new Color("cALPHA");
		
		pRED = new Color("pRED");
		pGREEN = new Color("pGREEN");
		pBLUE = new Color("pBLUE");
		pALPHA = new Color("pALPHA");
		pcRED = new Color("pcRED");
		pcGREEN = new Color("pcGREEN");
		pcBLUE = new Color("pcBLUE");
		pcALPHA = new Color("pcALPHA");
		
		ieRED = new Color("ieRED");
		ieGREEN = new Color("ieGREEN");
		ieBLUE = new Color("ieBLUE");
		ieALPHA = new Color("ieALPHA");
		iecRED = new Color("iecRED");
		iecGREEN = new Color("iecGREEN");
		iecBLUE = new Color("iecBLUE");
		iecALPHA = new Color("iecALPHA");
		
		oeRED = new Color("oeRED");
		oeGREEN = new Color("oeGREEN");
		oeBLUE = new Color("oeBLUE");
		oeALPHA = new Color("oeALPHA");
		oecRED = new Color("oecRED");
		oecGREEN = new Color("oecGREEN");
		oecBLUE = new Color("oecBLUE");
		oecALPHA = new Color("oecALPHA");
		
		invisRED = new Color("invisRED");
		invisGREEN = new Color("invisGREEN");
		invisBLUE = new Color("invisBLUE");
		invisALPHA = new Color("invisALPHA");
		inviscRED = new Color("inviscRED");
		inviscGREEN = new Color("inviscGREEN");
		inviscBLUE = new Color("inviscBLUE");
		inviscALPHA = new Color("inviscALPHA");
		
		/*getApi().registerForgeListener(new HitBoxRender());
		getApi().registerForgeListener(new ToggleHitbox());*/
		getApi().getEventManager().register(new HitBoxRender());
	}

}
