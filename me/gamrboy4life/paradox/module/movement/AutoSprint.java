package me.gamrboy4life.paradox.module.movement;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class AutoSprint extends Module{

	public AutoSprint() {
		super("AutoSprint", Keyboard.KEY_L, Category.MOVEMENT);
		
	}
	
	public void onEnable() {
		if(this.isToggled()) {
			mc.thePlayer.setSprinting(true);
			super.onEnable();
		}
	}
	
	public void onDisable() {
		mc.thePlayer.setSprinting(false);
		super.onDisable();
	}

}
