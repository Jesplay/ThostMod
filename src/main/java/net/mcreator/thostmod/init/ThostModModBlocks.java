
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thostmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.thostmod.block.ThosterBlock;
import net.mcreator.thostmod.ThostModMod;

public class ThostModModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ThostModMod.MODID);
	public static final RegistryObject<Block> THOSTER = REGISTRY.register("thoster", () -> new ThosterBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
