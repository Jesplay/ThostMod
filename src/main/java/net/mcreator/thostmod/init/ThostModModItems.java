
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
import net.mcreator.thostmod.item.ThostBagItem;
import net.mcreator.thostmod.item.ThoriumPlateItem;
import net.mcreator.thostmod.item.ThoriumNuggetItem;
import net.mcreator.thostmod.item.ThoriumIngotItem;
import net.mcreator.thostmod.item.ThoriumDustItem;
import net.mcreator.thostmod.item.RawThoriumItem;
import net.mcreator.thostmod.item.ForkItem;
import net.mcreator.thostmod.item.DoenerFleischItem;
import net.mcreator.thostmod.ThostModMod;

public class ThostModModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ThostModMod.MODID);
	public static final RegistryObject<Item> THOSTER = block(ThostModModBlocks.THOSTER);
	public static final RegistryObject<Item> FORK = REGISTRY.register("fork", () -> new ForkItem());
	public static final RegistryObject<Item> THOST = REGISTRY.register("thost", () -> new ToastItem());
	public static final RegistryObject<Item> THOSTED_THOST = REGISTRY.register("thosted_thost", () -> new ToastedToastItem());
	public static final RegistryObject<Item> THORIUM_INGOT = REGISTRY.register("thorium_ingot", () -> new ThoriumIngotItem());
	public static final RegistryObject<Item> THORIUM_ORE = block(ThostModModBlocks.THORIUM_ORE);
	public static final RegistryObject<Item> THORIUM_BLOCK = block(ThostModModBlocks.THORIUM_BLOCK);
	public static final RegistryObject<Item> THORIUM_ORE_DEEPSLATE = block(ThostModModBlocks.THORIUM_ORE_DEEPSLATE);
	public static final RegistryObject<Item> RAW_THORIUM = REGISTRY.register("raw_thorium", () -> new RawThoriumItem());
	public static final RegistryObject<Item> THORIUM_NUGGET = REGISTRY.register("thorium_nugget", () -> new ThoriumNuggetItem());
	public static final RegistryObject<Item> THOST_BAG = REGISTRY.register("thost_bag", () -> new ThostBagItem());
	public static final RegistryObject<Item> THORIUM_PLATE = REGISTRY.register("thorium_plate", () -> new ThoriumPlateItem());
	public static final RegistryObject<Item> DOENER_FLEISCH = REGISTRY.register("doener_fleisch", () -> new DoenerFleischItem());
	public static final RegistryObject<Item> DOENER_BLOCK = block(ThostModModBlocks.DOENER_BLOCK);
	public static final RegistryObject<Item> SPIESS = block(ThostModModBlocks.SPIESS);
	public static final RegistryObject<Item> THORIUM_DUST = REGISTRY.register("thorium_dust", () -> new ThoriumDustItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
