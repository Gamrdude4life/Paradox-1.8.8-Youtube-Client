package me.gamrboy4life.paradox.module.player;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;

public class Flip extends Module{

	public Flip() {
		super("Flip", 0, Category.PLAYER);
	}
	
	@Override
	public void toggle() {
		mc.thePlayer.rotationYaw += 180;
	}

}
