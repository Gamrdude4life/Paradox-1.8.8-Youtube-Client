package me.gamrboy4life.paradox.module.movement;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class Jetpack extends Module{

	public Jetpack() {
		super("Jetpack", 0, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.gameSettings.keyBindJump.pressed) {
				mc.thePlayer.jump();
			}
		}
	}

}
