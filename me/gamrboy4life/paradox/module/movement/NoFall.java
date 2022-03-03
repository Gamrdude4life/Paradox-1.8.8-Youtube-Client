package me.gamrboy4life.paradox.module.movement;

import org.lwjgl.input.Keyboard;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends Module{

	public NoFall() {
		super("Nofall", Keyboard.KEY_N, Category.MOVEMENT);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.fallDistance > 2f) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
			super.onUpdate();
		}
	}
}
