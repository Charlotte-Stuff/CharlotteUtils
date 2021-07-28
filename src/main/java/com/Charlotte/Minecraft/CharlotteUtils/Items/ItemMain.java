package com.Charlotte.Minecraft.CharlotteUtils.Items;

import java.util.HashMap;

import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import com.Charlotte.Minecraft.CharlotteUtils.Plugin;

public class ItemMain implements Listener {
	public ItemMain() {
		Plugin.getInstance().getServer().getPluginManager().registerEvents(this, Plugin.getInstance());
	}

	/*
	 * Maps All Registered Items To IDs
	 */

	private static HashMap<String, Item> items = new HashMap<String, Item>();

	@EventHandler
	public void onItemDamaged(PlayerItemDamageEvent event) {
		ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
		boolean isCustomItem = isCustomItem(item);
		if (isCustomItem) {
			String ID = getCustomItemID(item);
			items.get(ID).onItemDamaged(event);
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		ItemStack item = event.getPlayer().getInventory().getItemInMainHand();
		boolean isCustomItem = isCustomItem(item);
		if (isCustomItem) {
			String ID = getCustomItemID(item);
			items.get(ID).onBlockBreak(event);
		}
	}

	protected void registerItem(Item item) {
		items.put(item.getID(), item);
	}

	public static boolean isCustomItem(ItemStack item) {
		/*
		 * Check If Item Has Attribute "ID"
		 */
		if (!item.hasItemMeta())
			return false;

		return item.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Plugin.getInstance(), "ID"),
				PersistentDataType.STRING);
	}

	public static String getCustomItemID(ItemStack item) {
		/*
		 * Gets The "ID" Attribute Of An Item
		 */
		return item.getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Plugin.getInstance(), "ID"),
				PersistentDataType.STRING);
	}

	public static Item getCustomItemByID(String ID) {
		return items.get(ID);
	}

}
