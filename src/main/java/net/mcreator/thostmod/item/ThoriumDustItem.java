
package net.mcreator.thostmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ThoriumDustItem extends Item {
	public ThoriumDustItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
