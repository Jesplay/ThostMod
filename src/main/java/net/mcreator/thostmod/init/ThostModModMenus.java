
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.thostmod.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.thostmod.world.inventory.ThostBagGUIMenu;
import net.mcreator.thostmod.ThostModMod;

public class ThostModModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ThostModMod.MODID);
	public static final RegistryObject<MenuType<ThostBagGUIMenu>> THOST_BAG_GUI = REGISTRY.register("thost_bag_gui", () -> IForgeMenuType.create(ThostBagGUIMenu::new));
}
