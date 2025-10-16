/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.thostmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.thostmod.client.gui.ThostBagGUIScreen;
import net.thostmod.init.ThostModModMenus;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ThostModModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(ThostModModMenus.THOST_BAG_GUI.get(), ThostBagGUIScreen::new);
		});
	}
}
