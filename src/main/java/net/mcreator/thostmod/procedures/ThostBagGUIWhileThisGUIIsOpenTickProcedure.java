package net.mcreator.thostmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.thostmod.init.ThostModModItems;

import java.util.function.Supplier;
import java.util.Map;

public class ThostBagGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == ThostModModItems.THOST.get()) {
			(sourceentity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).shrink(1);
			if ((sourceentity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).getItem() == ThostModModItems.THOST.get()) {
				if (sourceentity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (sourceentity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).copy();
					_setstack.setCount((int) (new Object() {
						public int getAmount(int sltid) {
							if (sourceentity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(2) + 1));
					((Slot) _slots.get(0)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			} else {
				if (sourceentity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(ThostModModItems.THOSTED_THOST.get()).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(2)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
	}
}
