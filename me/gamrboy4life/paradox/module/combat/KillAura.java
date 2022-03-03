package me.gamrboy4life.paradox.module.combat;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import de.Hero.settings.Setting;
import me.gamrboy4life.paradox.Paradox;
import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class KillAura extends Module{

    public KillAura() {
        super("KillAura", Keyboard.KEY_R, Category.COMBAT);
    }
    
    
    @Override
    public void onUpdate() {
       
        if(!this.isToggled())
            return;
       
        for(Iterator<Entity> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext();) {
            Object theObject = entities.next();
            if(theObject instanceof EntityLivingBase) {
                EntityLivingBase entity = (EntityLivingBase) theObject;
               
                if(entity instanceof EntityPlayerSP) continue;
               
                if(mc.thePlayer.getDistanceToEntity(entity) <= 6.2173613F) {
                    if(entity.isEntityAlive()) {
                        mc.playerController.attackEntity(mc.thePlayer, entity);
                        mc.thePlayer.swingItem();
                        continue;
                    }
                }
            }
        }
        
        
       
        super.onUpdate();
    }
 

}