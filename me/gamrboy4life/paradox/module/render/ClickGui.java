package me.gamrboy4life.paradox.module.render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import de.Hero.settings.Setting;
import me.gamrboy4life.paradox.Paradox;
import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class ClickGui extends Module{

	public ClickGui() {
        super("ClickGui", Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("New");
        options.add("JellyLike");
        Paradox.instance.settingsManager.rSetting(new Setting("Design", this, "New", options));
        Paradox.instance.settingsManager.rSetting(new Setting("Sound", this, false));
        Paradox.instance.settingsManager.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
        Paradox.instance.settingsManager.rSetting(new Setting("GuiGreen", this, 26, 0, 255, true));
        Paradox.instance.settingsManager.rSetting(new Setting("GuiBlue", this, 42, 0, 255, true));
    }

    @Override
    public void onEnable() {
        super.onEnable();

        mc.displayGuiScreen(Paradox.instance.clickGUI);
        toggle();
    }
}