package me.gamrboy4life.paradox.module.movement;

import me.gamrboy4life.paradox.module.Category;
import me.gamrboy4life.paradox.module.Module;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Scaffold extends Module{

	public Scaffold() {
		super("Scaffold", 0, Category.MOVEMENT);
	}
	
	@Override
	public void onUpdate() {
		if(this.isToggled()) {
			Entity p = player();
			BlockPos bp = new BlockPos(p.posX, p.getEntityBoundingBox().minY, p.posZ);
			if(valid(bp.add(0, -2, 0)))
				
				place(bp.add(0, -1, 0), EnumFacing.UP);
			
			else if (valid(bp.add(-1, -1, 0)))
				
				place(bp.add(0, -1, 0), EnumFacing.EAST);
			
			else if (valid(bp.add(1, -1, 0)))
				
				place(bp.add(0, -1, -1), EnumFacing.WEST);
			
			else if (valid(bp.add(0, -1, -1)))
				
				place(bp.add(0, -1, 0), EnumFacing.SOUTH);
			
			else if (valid(bp.add(0, -1, 1)))
				
				place(bp.add(0, -1, 0), EnumFacing.NORTH);
			
			else if(valid(bp.add(1, -1, 1))) {
				
				if(valid(bp.add(0, -1, 1)))
					
					place(bp.add(0, -1, 1), EnumFacing.NORTH);
				place(bp.add(1, -1, 1), EnumFacing.EAST);
			}else if (valid(bp.add(-1, -1, 1))) {
				if(valid(bp.add(-1, -1, 0)))
					place(bp.add(0, -1, 1), EnumFacing.WEST);
				place(bp.add(-1, -1, 1),EnumFacing.SOUTH);
			}else if (valid(bp.add(-1, -1, -1))) {
				if(valid(bp.add(0, -1, -1)))
					place(bp.add(0, -1, 1), EnumFacing.SOUTH);
				place(bp.add(-1, -1, 1), EnumFacing.WEST);
			}else if (valid(bp.add(1, -1 , -1))) {
				if(valid(bp.add(1, -1, 0)))
					place(bp.add(1, -1, 0), EnumFacing.EAST);
				place(bp.add(1, -1, -1), EnumFacing.NORTH);
			}
		}
	}
	
	void place(BlockPos p, EnumFacing f) {
		if(f == EnumFacing.UP)
			p = p.add(0, -1 ,0);
		else if(f == EnumFacing.NORTH)
			p = p.add(0, 0, 1);
		else if(f == EnumFacing.EAST)
			p = p.add(-1, 0, 0);
		else if(f == EnumFacing.SOUTH)
			p = p.add(0, 0, -1);
		else if(f == EnumFacing.WEST)
			p = p.add(1, 0, 0);
		
		EntityPlayerSP _p = player();
		
		if(_p.getHeldItem() != null && _p.getHeldItem().getItem() instanceof ItemBlock) {
			_p.swingItem();
		playerController().onPlayerRightClick(_p, world(), _p.getHeldItem(), p, f, new Vec3(0.5, 0.5, 0.5));
		double x = p.getX() + 0.25 - _p.posX;
		double z = p.getZ() + 0.25 - _p.posZ;
		double y = p.getY() + 0.25 - _p.posY;
		double distance = MathHelper.sqrt(x * x + z * z);
		float yaw = (float) (Math.atan2(z, x) * 180 / Math.PI - 90);
		float pitch = (float) - (Math.atan2(y, distance) * 180 /Math.PI);
		sendPacket(new C03PacketPlayer.C06PacketPlayerPosLook(_p.posX, _p.posY, _p.posZ, yaw, pitch, _p.onGround));
		}
	}
	
	boolean valid(BlockPos p) {
		Block b = world().getBlock(p);
		return !(b instanceof BlockLiquid) && b.getMaterial() != Material.air;
	}

}
