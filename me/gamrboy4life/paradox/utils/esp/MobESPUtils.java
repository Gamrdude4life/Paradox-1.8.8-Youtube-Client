package me.gamrboy4life.paradox.utils.esp;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;

public class MobESPUtils {
	public static void entityESPBox(Entity entity, int mode) {
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		if(mode == 0) //Enemy
			GL11.glColor4d(
					1 - Minecraft.getMinecraft().thePlayer.getDistanceSqToEntity(entity) / 40,
					 Minecraft.getMinecraft().thePlayer.getDistanceSqToEntity(entity) / 40,
					0, 0.5F);
					
		
		else if(mode == 1)//friend
			GL11.glColor4d(0, 0, 1, 0.5F);
		else if(mode == 2)//Other
			GL11.glColor4d(1, 1, 0, 0.5F);
		else if(mode == 3)// Target
			GL11.glColor4d(1, 0, 0, 0.5F);
		else if(mode == 4)//Team
			GL11.glColor4d(0, 1, 0, 0.5F);
		Minecraft.getMinecraft().getRenderManager();
		RenderGlobal.func_181561_a(
				new AxisAlignedBB(
						entity.boundingBox.minX
							-0.05
							- entity.posX
							+ (entity.posX - Minecraft.getMinecraft().getRenderManager().renderPosX),
						entity.boundingBox.minY
							-0.05
							- entity.posY
							+ (entity.posY - Minecraft.getMinecraft().getRenderManager().renderPosY),
						entity.boundingBox.minZ
							-0.05
							- entity.posZ
							+ (entity.posZ - Minecraft.getMinecraft().getRenderManager().renderPosZ),
						entity.boundingBox.maxX
							+0.05
							- entity.posX
							+ (entity.posX - Minecraft.getMinecraft().getRenderManager().renderPosX),
						entity.boundingBox.maxY
							+0.1
							- entity.posY
							+ (entity.posY - Minecraft.getMinecraft().getRenderManager().renderPosY),
						entity.boundingBox.maxZ
							+0.05
							- entity.posZ
							+ (entity.posZ - Minecraft.getMinecraft().getRenderManager().renderPosZ)));
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
					
					
		
		
		
	}

}
