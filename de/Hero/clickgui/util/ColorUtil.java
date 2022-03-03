package de.Hero.clickgui.util;

import java.awt.Color;

//Deine Imports
import me.gamrboy4life.paradox.Paradox;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int)Paradox.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int)Paradox.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int)Paradox.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
