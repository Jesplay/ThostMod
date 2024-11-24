
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thostmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.thostmod.ThostModMod;

public class ThostModModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThostModMod.MODID);
	public static final RegistryObject<CreativeModeTab> THOST_MOD = REGISTRY.register("thost_mod",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.thost_mod.thost_mod")).icon(() -> new ItemStack(ThostModModItems.FORK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ThostModModBlocks.THOSTER.get().asItem());
				tabData.accept(ThostModModItems.FORK.get());
				tabData.accept(ThostModModItems.THOST.get());
				tabData.accept(ThostModModItems.THOSTED_THOST.get());
			}).withSearchBar().build());
}
