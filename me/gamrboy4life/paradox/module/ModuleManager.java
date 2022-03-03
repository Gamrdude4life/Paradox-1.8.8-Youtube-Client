package me.gamrboy4life.paradox.module;

import java.util.ArrayList;

import me.gamrboy4life.paradox.Paradox;
import me.gamrboy4life.paradox.module.combat.*;
import me.gamrboy4life.paradox.module.movement.*;
import me.gamrboy4life.paradox.module.player.*;
import me.gamrboy4life.paradox.module.render.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public class ModuleManager {
	
	private static ArrayList<Module> mods;
	
	public ModuleManager() {
		mods = new ArrayList<Module>();
		//COMBAT
		newMod(new FastBow());
		newMod(new KillAura());
		
		
		//MOVEMENT
		newMod(new AutoSprint());
		newMod(new AutoWalk());
		newMod(new Dolphin());
		newMod(new Flight());
		newMod(new Glide());
		newMod(new Jetpack());
		newMod(new NoFall());
		newMod(new Parkour());
		newMod(new Scaffold());
		newMod(new Sneak());
		newMod(new Speed());	
		newMod(new Spider());
		newMod(new Step());
		
		
		//PLAYER
		newMod(new AntiAFK());
		newMod(new AntiCobweb());
		newMod(new AutoMine());
		newMod(new AutoRespawn());
		newMod(new BunnyHop());
		newMod(new FastLadder());
		newMod(new FastPlace());
		newMod(new Flip());

		
		
		
		//RENDER
		newMod(new ESP());
		newMod(new Xray());
		
		
		newMod(new ClickGui());
		
		
		//MISC
	}
	
	public static void newMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules(){
		return mods;
	}
	
	public static void onUpdate() {
		for(Module m : mods) {
			m.onUpdate();
		}
	}
	
	public static void onRender() {
		for(Module m : mods) {
			m.onRender();
		}
	}
	
	public static void onKey(int k) {
		for(Module m : mods) {
			if(m.getKey() == k) {
				m.toggle();
			}
		}
	}
	
	public static void addChatMessage(String message) {
		message = "\2479" + Paradox.name + "\2477: " + message;
		
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
	}

}
