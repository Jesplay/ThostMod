/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.thostmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.thostmod.ThostModMod;

public class ThostModModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ThostModMod.MODID);
	public static final RegistryObject<SoundEvent> BING = REGISTRY.register("bing", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("thost_mod", "bing")));
}
