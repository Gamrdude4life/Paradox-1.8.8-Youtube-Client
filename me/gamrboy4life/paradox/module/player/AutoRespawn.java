package me.gamrboy4life.paradox.module.player;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
public class AutoRespawn extends Module{

	public AutoRespawn() {
		super("AutoRespawn", 0, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.isDead) {
				mc.thePlayer.respawnPlayer();
			}
		}
	}

}
