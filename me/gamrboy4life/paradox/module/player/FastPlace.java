package me.gamrboy4life.paradox.module.player;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;


public class FastPlace extends Module{

	public FastPlace() {
		super("FastPlace", Keyboard.KEY_B, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			mc.rightClickDelayTimer = 0;
		}
	}

}
