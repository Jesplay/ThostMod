/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.thostmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

import net.thostmod.init.ThostModModVillagerProfessions;
import net.thostmod.init.ThostModModItems;
import net.thostmod.init.ThostModModBlocks;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ThostModModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == ThostModModVillagerProfessions.DOENERMENSCH.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD),
					new ItemStack(ThostModModItems.DOENER_FLEISCH.get(), 2), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6),
					new ItemStack(ThostModModBlocks.DOENER_BLOCK.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD),
					new ItemStack(ThostModModItems.FORK.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8),
					new ItemStack(ThostModModBlocks.SPIESS.get()), 10, 5, 0.05f));
		}
	}
}
