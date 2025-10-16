
package net.thostmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ThoriumPlateItem extends Item {
	public ThoriumPlateItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
