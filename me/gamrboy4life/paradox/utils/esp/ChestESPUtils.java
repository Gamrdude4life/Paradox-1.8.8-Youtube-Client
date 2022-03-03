package me.gamrboy4life.paradox.utils.esp;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;

public class ChestESPUtils {
	
	public static void blockESPBox(BlockPos blockPos) {
		
		double x =
				blockPos.getX()
					- Minecraft.getMinecraft().getRenderManager().renderPosX;
		double y =
				blockPos.getY()
					- Minecraft.getMinecraft().getRenderManager().renderPosY;
		double z =
				blockPos.getZ()
					- Minecraft.getMinecraft().getRenderManager().renderPosZ;
		
		GL11.glBlendFunc(770, 771);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glLineWidth(2.0F);
		GL11.glColor4d(0, 0, 1, 0.15F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(false);
		
		//Box
		GL11.glColor4d(0, 0, 1, 0.5F);
		RenderGlobal.func_181561_a(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthMask(true);
		GL11.glDisable(GL11.GL_BLEND);
		
		
		
	}

}
