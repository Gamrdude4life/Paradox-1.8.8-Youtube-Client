package me.gamrboy4life.paradox.module.player;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.utils.Invoker;

public class FastLadder extends Module{
	
	private int ticks = 0;

	public FastLadder() {
		super("FastLadder", 0, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			ticks++;
			if(Invoker.isOnLadder() && Keyboard.isKeyDown(Invoker.getForwardCode())) {
				Invoker.setMotionY(0.25);
			}else if(Invoker.isOnLadder() && !Keyboard.isKeyDown(Invoker.getForwardCode())) {
				Invoker.setMotionY(-0.25);
			}
		}
	}

}


