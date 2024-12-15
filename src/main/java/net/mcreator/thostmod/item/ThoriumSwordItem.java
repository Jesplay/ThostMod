
package net.mcreator.thostmod.item;

public class ThoriumSwordItem extends SwordItem {
	public ThoriumSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 10000;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 20;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(ThostModModItems.THORIUM_INGOT.get()));
			}
		}, 3, -3f, new Item.Properties().fireResistant());
	}
}
