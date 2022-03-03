package me.gamrboy4life.paradox.module.render;

import de.Hero.settings.Setting;
import me.gamrboy4life.paradox.Paradox;
import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.utils.esp.ChestESPUtils;
import me.gamrboy4life.paradox.utils.esp.MobESPUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityChest;

public class ESP extends Module{

	public ESP() {
		super("ESP", 0 , Category.RENDER);
	}
	
	public void setup() {
		Paradox.instance.settingsManager.rSetting(new Setting("Player", this, false));
		Paradox.instance.settingsManager.rSetting(new Setting("Chest", this, false));
		Paradox.instance.settingsManager.rSetting(new Setting("HostileMobs", this, false));
		Paradox.instance.settingsManager.rSetting(new Setting("FriendlyMobs", this, false));
	}
	
	public void onRender() {
		if(this.isToggled() && Paradox.instance.settingsManager.getSettingByName("Player").getValBoolean()) {
			for(Object e : mc.theWorld.loadedEntityList) {
				if(e instanceof EntityPlayer) {
					MobESPUtils.entityESPBox((Entity)e, 0);
				}
			}
		}
		
		if(this.isToggled() && Paradox.instance.settingsManager.getSettingByName("Chest").getValBoolean()) {
			for(Object o: mc.theWorld.loadedTileEntityList) {
				if(o instanceof TileEntityChest) {
					ChestESPUtils.blockESPBox(((TileEntityChest)o).getPos());
				}
			}
		}
		
		if(this.isToggled() && Paradox.instance.settingsManager.getSettingByName("HostileMobs").getValBoolean()) {
			for(Object h : mc.theWorld.loadedEntityList) {
				if(h instanceof EntityMob) {
					MobESPUtils.entityESPBox((Entity)h, 0);
				}
			}
		}
		
		 if(this.isToggled() && Paradox.instance.settingsManager.getSettingByName("FriendlyMobs").getValBoolean()) {
			 for(Object f : mc.theWorld.loadedEntityList) {
				 if(f instanceof EntityAnimal) {
					 MobESPUtils.entityESPBox((Entity)f, 0);
				 }
			 }
		 }
	}
	

}
