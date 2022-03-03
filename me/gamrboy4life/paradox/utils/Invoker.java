package me.gamrboy4life.paradox.utils;

import java.lang.reflect.Field;
import java.util.List;

import com.mojang.authlib.GameProfile;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StringUtils;
import net.minecraft.util.Vec3;


public class Invoker {
	
	
	
	
	private static String entityLivingBaseLoc = "net.minecraft.entity.EntityLivingBase";
	
	public static void sendChatMessage(String msg){
		Minecraft.getMinecraft().thePlayer.sendChatMessage(msg);
	}
	
	public static void addChatMessage(String str){
		Object chat = new ChatComponentText(str);
		if(str != null){
    		Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((IChatComponent)chat);	
		}	
	}
	
	public static float getRotationYaw(){
		return Minecraft.getMinecraft().thePlayer.rotationYaw;
	}
	
	public static float getRotationPitch(){
		return Minecraft.getMinecraft().thePlayer.rotationPitch;
	}
	
	public static void setRotationYaw(float yaw){
		Minecraft.getMinecraft().thePlayer.rotationYaw = yaw;
	}
	
	public static void setRotationPitch(float pitch){
		Minecraft.getMinecraft().thePlayer.rotationPitch = pitch;
	}
	
	public static void setSprinting(boolean sprinting){
		Minecraft.getMinecraft().thePlayer.setSprinting(sprinting);
	}
	
	public static boolean isOnLadder(){
		return Minecraft.getMinecraft().thePlayer.isOnLadder();
	}
	
	public static float moveForward(){
		return Minecraft.getMinecraft().thePlayer.moveForward;
	}
	
	public static boolean isCollidedHorizontally(){
		return Minecraft.getMinecraft().thePlayer.isCollidedHorizontally;
	}

	public static void setMotionX(double x){
		Minecraft.getMinecraft().thePlayer.motionX = x;
	}
	
	public static void setMotionY(double y){
		Minecraft.getMinecraft().thePlayer.motionY = y;
	}
	
	public static void setMotionZ(double z){
		Minecraft.getMinecraft().thePlayer.motionZ = z;
	}
	
	public static double getMotionX(){
		return Minecraft.getMinecraft().thePlayer.motionX;
	}
	
	public static double getMotionY(){
		return Minecraft.getMinecraft().thePlayer.motionY;
	}
	
	public static double getMotionZ(){
		return Minecraft.getMinecraft().thePlayer.motionZ;
	}
	
	public static void setLandMovementFactor(float newFactor){
		try{
			Class elb = Class.forName(entityLivingBaseLoc);
			Field landMovement = elb.getDeclaredField("landMovementFactor");
			landMovement.setAccessible(true);
			landMovement.set(Minecraft.getMinecraft().thePlayer, newFactor);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void setJumpMovementFactor(float newFactor){
		try{
			Class elb = Class.forName(entityLivingBaseLoc);
			Field landMovement = elb.getDeclaredField("jumpMovementFactor");
			landMovement.setAccessible(true);
			landMovement.set(Minecraft.getMinecraft().thePlayer, newFactor);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static float getGammaSetting(){
		return Minecraft.getMinecraft().gameSettings.gammaSetting;
	}
	
	public static void setGammaSetting(float newSetting){
		Minecraft.getMinecraft().gameSettings.gammaSetting = newSetting;
	}
	
	public static int getJumpCode(){
		return Minecraft.getMinecraft().gameSettings.keyBindJump.getKeyCode();
	}
	
	public static int getForwardCode(){
		return Minecraft.getMinecraft().gameSettings.keyBindForward.getKeyCode();
	}
	
	public static void setJumpKeyPressed(boolean pressed){
		Minecraft.getMinecraft().gameSettings.keyBindJump.pressed = pressed;
	}
	
	public static void setForwardKeyPressed(boolean pressed){
		Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = pressed;
	}
	
	public static void setUseItemKeyPressed(boolean pressed){
		Minecraft.getMinecraft().gameSettings.keyBindUseItem.pressed = pressed;
	}
	
	public int getSneakCode(){
		return Minecraft.getMinecraft().gameSettings.keyBindSneak.getKeyCode();
	}
	
	public synchronized void displayScreen(GuiScreen screen){
		Minecraft.getMinecraft().displayGuiScreen(screen);
	}
	
	public List getEntityList(){
		return Minecraft.getMinecraft().theWorld.loadedEntityList;
	}
	
	public static float getDistanceToEntity(Entity from, Entity to){
		return from.getDistanceToEntity(to);
	}
	
	public boolean isEntityDead(Entity e){
		return e.isDead;
	}
	
	public boolean canEntityBeSeen(Entity e){
		return Minecraft.getMinecraft().thePlayer.canEntityBeSeen(e);
	}
	
	public static void attackEntity(Entity e){
		Minecraft.getMinecraft().playerController.attackEntity(Minecraft.getMinecraft().thePlayer, e);
	}
	
	public static void swingItem(){
		Minecraft.getMinecraft().thePlayer.swingItem();
	}
	
	public static float getEyeHeight(){
		return Minecraft.getMinecraft().thePlayer.getEyeHeight();
	}
	
	public static float getEyeHeight(Entity e){
		return e.getEyeHeight();
	}
	
	public double getPosX(){
		return Minecraft.getMinecraft().thePlayer.posX;
	}
	
	public double getPosY(){
		return Minecraft.getMinecraft().thePlayer.posY;
	}
	
	public double getPosZ(){
		return Minecraft.getMinecraft().thePlayer.posZ;
	}
	
	public double getPosX(Entity e){
		return e.posX;
	}
	
	public double getPosY(Entity e){
		return e.posY;
	}
	
	public double getPosZ(Entity e){
		return e.posZ;
	}
	
	public static void setInvSlot(int slot){
		Minecraft.getMinecraft().thePlayer.inventory.currentItem = slot;
	}
	
	public int getCurInvSlot(){
		return Minecraft.getMinecraft().thePlayer.inventory.currentItem;
	}
	
	public static ItemStack getCurrentItem(){
		return Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();
	}
	
	public ItemStack getItemAtSlot(int slot){
		return Minecraft.getMinecraft().thePlayer.inventoryContainer.getSlot(slot).getStack();
	}
	
	public static ItemStack getItemAtSlotHotbar(int slot){
		return Minecraft.getMinecraft().thePlayer.inventory.getStackInSlot(slot);
	}
	
	public int getIdFromItem(Item item){
		return Item.getIdFromItem(item);
	}
	
	public static void clickWindow(int slot, int mode, int button, EntityPlayer player){
		Minecraft.getMinecraft().playerController.windowClick(player.inventoryContainer.windowId, slot, button, mode, player);
	}
	
	public static void clickWindow(int id, int slot, int mode, int button, EntityPlayer player){
		Minecraft.getMinecraft().playerController.windowClick(id, slot, button, mode, player);
	}
	
	public static void sendUseItem(ItemStack itemStack, EntityPlayer player){
		Minecraft.getMinecraft().playerController.sendUseItem(player, Minecraft.getMinecraft().theWorld, itemStack);
	}
	
	public Item getItemById(int id){
		return Item.getItemById(id);
	}
	
	public static void dropItemStack(int slot){
		for(int i=0; i<Minecraft.getMinecraft().thePlayer.inventory.getStackInSlot(slot).stackSize; i++){
			Minecraft.getMinecraft().thePlayer.dropOneItem(false);
		}
	}
	
	public int getPacketVelocityEntityId(S12PacketEntityVelocity p){
		return p.getEntityID();
	}
	
	public Entity getEntityById(int id){
		return Minecraft.getMinecraft().theWorld.getEntityByID(id);
	}
	
	public int getXMovePacketVel(S12PacketEntityVelocity p){
		return p.getMotionX();
	}
	
	public int getYMovePacketVel(S12PacketEntityVelocity p){
		return p.getMotionY();
	}
	
	public int getZMovePacketVel(S12PacketEntityVelocity p){
		return p.getMotionZ();
	}
	
	public static void rightClick(){
		Minecraft.getMinecraft().rightClickMouse();
	}
	
	public static void leftClick(){
		Minecraft.getMinecraft().clickMouse();
	}
	
	public static void setKeyBindAttackPressed(boolean flag){
		Minecraft.getMinecraft().gameSettings.keyBindAttack.pressed = flag;
	}
	
	public static MovingObjectPosition getObjectMouseOver(){
		return Minecraft.getMinecraft().objectMouseOver;
	}
	
	
	
	public static float getStrVsBlock(ItemStack item, Block block){
		return item.getStrVsBlock(block);
	}
	
	public static void useItemRightClick(ItemStack item){
		item.useItemRightClick(Minecraft.getMinecraft().theWorld, Minecraft.getMinecraft().thePlayer);
	}
	
	public ItemStack[] getArmourInventory(){
		return Minecraft.getMinecraft().thePlayer.inventory.armorInventory;
	}
	
	public static void enableStandardItemLighting(){
		RenderHelper.enableStandardItemLighting();
	}
	
	public static void disableStandardItemLighting(){
		RenderHelper.disableStandardItemLighting();
	}
	
	
	
	public String stripControlCodes(String s){
		return StringUtils.stripControlCodes(s);
	}
	
	
	
	public String getSessionUsername(){
		return Minecraft.getMinecraft().getSession().getUsername();
	}
	
	public double getBoundboxMinY(Entity e){
		return e.boundingBox.minY;
	}
	
	public double getBoundboxMaxY(Entity e){
		return e.boundingBox.maxY;
	}
	
	public double getBoundboxMinX(Entity e){
		return e.boundingBox.minX;
	}
	
	public double getBoundboxMaxX(Entity e){
		return e.boundingBox.maxX;
	}
	
	public double getBoundboxMinZ(Entity e){
		return e.boundingBox.minZ;
	}
	
	public double getBoundboxMaxZ(Entity e){
		return e.boundingBox.maxZ;
	}
	
	public int getDisplayHeight(){
		return Minecraft.getMinecraft().getMinecraft().displayHeight;
	}
	
	public int getDisplayWidth(){
		return Minecraft.getMinecraft().getMinecraft().displayWidth;
	}
	
	public GuiScreen getCurrentScreen(){
		return Minecraft.getMinecraft().getMinecraft().currentScreen;
	}
	
	
	
	public int getScaledWidth(ScaledResolution sr){
		return sr.getScaledWidth();
	}
	
	public int getScaledHeight(ScaledResolution sr){
		return sr.getScaledHeight();
	}
	
	
	
	public ServerData getCurrentServerData(){
		return Minecraft.getMinecraft().getMinecraft().currentServerData;
	}
	
	public boolean isInCreativeMode(){
		return Minecraft.getMinecraft().playerController.isInCreativeMode();
	}
	
	public static void setStackDisplayName(ItemStack is, String s){
		is.setStackDisplayName(s);
	}
	
	public String getItemDisplayName(ItemStack is){
		return is.getDisplayName();
	}
	
	public static void sendPacket(Packet p){
		Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(p);
	}
	
	public Enchantment[] getEnchantList(){
		return Enchantment.enchantmentsList;
	}
	
	public static void addEnchantment(ItemStack is, Enchantment e, int level){
		is.addEnchantment(e, 127);
	}
	
	public double getLastTickPosX(Entity e){
		return e.lastTickPosX;
	}
	
	public double getLastTickPosY(Entity e){
		return e.lastTickPosY;
	}
	
	public double getLastTickPosZ(Entity e){
		return e.lastTickPosZ;
	}
	
	public static float getEntityHeight(Entity e){
		return e.height;
	}
	
	
	
	public static void loadRenderers(){
		if(Minecraft.getMinecraft().getMinecraft().renderGlobal != null){
			Minecraft.getMinecraft().getMinecraft().renderGlobal.loadRenderers();
		}
	}
	
	public static void setSmoothLighting(int mode){
		Minecraft.getMinecraft().gameSettings.ambientOcclusion = mode;
	}
	
	public int getSmoothLighting(){
		return Minecraft.getMinecraft().gameSettings == null ? 2 : Minecraft.getMinecraft().gameSettings.ambientOcclusion;
	}

	public int getIdFromBlock(Block block) {
		return Block.getIdFromBlock(block);
	}
	
	public List getTileEntityList(){
		return Minecraft.getMinecraft().theWorld.loadedTileEntityList;
	}
	
	
	
	public boolean isBurning(){
		return Minecraft.getMinecraft().thePlayer.isBurning();
	}
	
	public static void setRightDelayTimer(int delay){
		Minecraft.getMinecraft().getMinecraft().rightClickDelayTimer = delay;
	}
	
	public int getItemInUseDuration(){
		return Minecraft.getMinecraft().thePlayer.getItemInUseDuration();
	}

	public boolean isOnGround() {
		return Minecraft.getMinecraft().thePlayer.onGround;
	}

	public boolean isInWater() {
		return Minecraft.getMinecraft().thePlayer.isInWater();
	}

	public static void setFallDistance(float f) {
		Minecraft.getMinecraft().thePlayer.fallDistance = f;
	}

	public static void setOnGround(boolean b) {
		Minecraft.getMinecraft().thePlayer.onGround = b;
	}
	
	public int getFoodLevel(){
		return Minecraft.getMinecraft().thePlayer.getFoodStats().getFoodLevel();
	}
	
	public static float getHealth(){
		return Minecraft.getMinecraft().thePlayer.getHealth();
	}
	
	public static void removeEntityFromWorld(int id){
		Minecraft.getMinecraft().theWorld.removeEntityFromWorld(id);
	}
	
	public static void addEntityToWorld(Entity e, int id){
		Minecraft.getMinecraft().theWorld.addEntityToWorld(id, e);
	}
	
	public static void setTimerSpeed(float speed){
		Minecraft.getMinecraft().getMinecraft().timer.timerSpeed = speed;
	}
	
	public static void jump(){
		Minecraft.getMinecraft().thePlayer.jump();
	}
	
	public GameProfile getGameProfile(EntityPlayer ep){
		return ep.gameProfile;
	}
	
	public static void setGameProfile(GameProfile profile, EntityPlayer ep){
		ep.gameProfile = profile; 
	}
	
	public static void setPositionAndRotation(Entity e, double x, double y, double z, float yaw, float pitch){
		e.setPositionAndRotation(x, y, z, yaw, pitch);
	}
	
	public static void copyInventory(EntityPlayer from, EntityPlayer to){
		from.inventory.copyInventory(to.inventory);
	}
	
	public static void setNoClip(boolean state){
		Minecraft.getMinecraft().thePlayer.noClip = state;
	}

	public static void setSneakKeyPressed(boolean pressed) {
		Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = pressed;
	}

	public boolean isSneaking(){
		return Minecraft.getMinecraft().thePlayer.isSneaking();
	}

	public static void setStepHeight(float value){
		Minecraft.getMinecraft().thePlayer.stepHeight = value;
	}
	
	public int getWidth(){
		return getDisplayWidth()/2;
	}
	
	public int getHeight(){
		return getDisplayHeight()/2;
	}
	
	public int getId(GuiButton btn){
		return btn.id;
	}
	
	public static void addButton(GuiScreen screen, GuiButton btn){
		screen.buttonList.add(btn);
	}
	
	public static void clearButtons(GuiScreen screen){
		screen.buttonList.clear();
	}
	
	

	public MovingObjectPosition rayTraceBlocks(Vec3 vecFromPool, Vec3 vecFromPool2) {
		return Minecraft.getMinecraft().theWorld.rayTraceBlocks(vecFromPool, vecFromPool2);
	}
	
	
	
	public static float getFallDistance(Entity e){
		return e.fallDistance;
	}
	
	public boolean isInvisible(Entity e){
		return e.isInvisible();
	}
	
	public static Block getBlock() {
		return getBlock();
	}
	
}
	
	


