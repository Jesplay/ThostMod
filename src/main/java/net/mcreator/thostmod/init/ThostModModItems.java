
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thostmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.thostmod.item.ToastedToastItem;
import net.mcreator.thostmod.item.ToastItem;
import net.mcreator.thostmod.item.ForkItem;
import net.mcreator.thostmod.ThostModMod;

public class ThostModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ThostModMod.MODID);
	public static final RegistryObject<Item> THOSTER = block(ThostModModBlocks.THOSTER);
	public static final RegistryObject<Item> FORK = REGISTRY.register("fork", () -> new ForkItem());
	public static final RegistryObject<Item> THOST = REGISTRY.register("thost", () -> new ToastItem());
	public static final RegistryObject<Item> THOSTED_THOST = REGISTRY.register("thosted_thost", () -> new ToastedToastItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
