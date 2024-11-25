
package net.mcreator.thostmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RawThoriumItem extends Item {
	public RawThoriumItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
