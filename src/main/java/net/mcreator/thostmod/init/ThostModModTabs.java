
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thostmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.thostmod.ThostModMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ThostModModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThostModMod.MODID);
	public static final RegistryObject<CreativeModeTab> THOST_MOD = REGISTRY.register("thost_mod",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.thost_mod.thost_mod")).icon(() -> new ItemStack(ThostModModItems.FORK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ThostModModBlocks.THOSTER.get().asItem());
				tabData.accept(ThostModModItems.FORK.get());
				tabData.accept(ThostModModItems.THOST.get());
				tabData.accept(ThostModModItems.THOSTED_THOST.get());
				tabData.accept(ThostModModItems.THORIUM_INGOT.get());
				tabData.accept(ThostModModBlocks.THORIUM_ORE.get().asItem());
				tabData.accept(ThostModModBlocks.THORIUM_BLOCK.get().asItem());
				tabData.accept(ThostModModBlocks.THORIUM_ORE_DEEPSLATE.get().asItem());
				tabData.accept(ThostModModItems.RAW_THORIUM.get());
				tabData.accept(ThostModModItems.THORIUM_NUGGET.get());
				tabData.accept(ThostModModItems.THOST_BAG.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {

			tabData.accept(ThostModModBlocks.THORIUM_BLOCK.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {

			tabData.accept(ThostModModItems.THORIUM_INGOT.get());
			tabData.accept(ThostModModItems.RAW_THORIUM.get());
			tabData.accept(ThostModModItems.THORIUM_NUGGET.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {

			tabData.accept(ThostModModItems.THOST.get());
			tabData.accept(ThostModModItems.THOSTED_THOST.get());

		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {

			tabData.accept(ThostModModBlocks.THORIUM_ORE.get().asItem());
			tabData.accept(ThostModModBlocks.THORIUM_ORE_DEEPSLATE.get().asItem());

		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {

			tabData.accept(ThostModModItems.THOST_BAG.get());

		}
	}
}
