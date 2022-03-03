package me.gamrboy4life.paradox.module.movement;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class AutoWalk extends Module{

	public AutoWalk() {
		super("AutoWalk", 0, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.gameSettings.keyBindForward.pressed = true;
		}
	}
	@Override
	public void onDisable() {
		mc.gameSettings.keyBindForward.pressed = false;
		super.onDisable();
	}

}
