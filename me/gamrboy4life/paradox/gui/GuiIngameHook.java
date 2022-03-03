package me.gamrboy4life.paradox.gui;

import me.gamrboy4life.paradox.Paradox;
import me.gamrboy4life.paradox.module.Module;
import me.gamrboy4life.paradox.utils.ColorUtils;
import me.gamrboy4life.paradox.utils.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;

public class GuiIngameHook extends GuiIngame{
	protected Minecraft mc = Minecraft.getMinecraft();

	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
	}
	
	
	public void renderGameOverlay(float p_175180_1_){
	     super.renderGameOverlay(p_175180_1_);
	     
	     
	     if(!mc.gameSettings.showDebugInfo) {
	    	 drawRect(2, 2, 95, 14, 0x80000000);
		     Wrapper.fr.drawString("Paradox", 4, 4, 0x4F0381);
		     Wrapper.fr.drawString("FPS: " + mc.getDebugFPS(), 50, 4, -1);
		     renderArrayList();
	     }
	     
	     
	}
	
	private void renderArrayList() {
		int yCount = 0;
		int index = 0;
		long x = 0;
		for(Module m : Paradox.instance.moduleManager.getModules()) {
			m.onRender();
			
			ScaledResolution sr = new ScaledResolution(mc);
			double offset = yCount*(Wrapper.fr.FONT_HEIGHT + 6);
			
			if(m.isToggled()) {
				Gui.drawRect(sr.getScaledWidth() - Wrapper.fr.getStringWidth(m.getName()) - 15, offset, sr.getScaledWidth(), 6 + Wrapper.fr.FONT_HEIGHT + offset, 0x80000000);
	            Wrapper.fr.drawString("- " + m.getName(), sr.getScaledWidth() - Wrapper.fr.getStringWidth(m.getName()) - 13 , 4 + offset , ColorUtils.rainbowEffect(index + x*200000000L, 1.0f).getRGB());
					yCount ++;
					index++;
					x++;

			}
		}
	}
}



