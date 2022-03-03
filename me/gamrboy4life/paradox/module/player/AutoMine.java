package me.gamrboy4life.paradox.module.player;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.utils.Invoker;
import net.minecraft.util.MovingObjectPosition;
public class AutoMine extends Module{

	public AutoMine() {
		super("AutoMine", 0, Category.PLAYER);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			MovingObjectPosition hover = Invoker.getObjectMouseOver();
			
			if(hover.typeOfHit != null) {
				if(hover.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
					Invoker.setKeyBindAttackPressed(true);
				}
			}else {
				Invoker.setKeyBindAttackPressed(false);
			}
		}
	}

}