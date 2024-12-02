
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thostmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.thostmod.block.ThosterBlock;
import net.mcreator.thostmod.block.ThoriumOreDeepslateBlock;
import net.mcreator.thostmod.block.ThoriumOreBlock;
import net.mcreator.thostmod.block.ThoriumBlockBlock;
import net.mcreator.thostmod.block.SpiessBlock;
import net.mcreator.thostmod.block.RawThoriumBlockBlock;
import net.mcreator.thostmod.block.DoenerBlockBlock;
import net.mcreator.thostmod.ThostModMod;

public class ThostModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ThostModMod.MODID);
	public static final RegistryObject<Block> THOSTER = REGISTRY.register("thoster", () -> new ThosterBlock());
	public static final RegistryObject<Block> THORIUM_ORE = REGISTRY.register("thorium_ore", () -> new ThoriumOreBlock());
	public static final RegistryObject<Block> THORIUM_BLOCK = REGISTRY.register("thorium_block", () -> new ThoriumBlockBlock());
	public static final RegistryObject<Block> THORIUM_ORE_DEEPSLATE = REGISTRY.register("thorium_ore_deepslate", () -> new ThoriumOreDeepslateBlock());
	public static final RegistryObject<Block> DOENER_BLOCK = REGISTRY.register("doener_block", () -> new DoenerBlockBlock());
	public static final RegistryObject<Block> SPIESS = REGISTRY.register("spiess", () -> new SpiessBlock());
	public static final RegistryObject<Block> RAW_THORIUM_BLOCK = REGISTRY.register("raw_thorium_block", () -> new RawThoriumBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
