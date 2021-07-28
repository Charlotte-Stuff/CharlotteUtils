package com.Charlotte.Minecraft.CharlotteUtils.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.Charlotte.Minecraft.CharlotteUtils.Plugin;

public class Item {

	/*
	 * ID IS USED FOR ACTIONS WITH THE ITEM AND SHOULD BE UNIQUE TO THE ITEM
	 */

	private ItemStack item;
	private ItemMeta meta;
	private String ID;

	public Item(String ID, Material mat) {
		this.ID = ID;
		item = new ItemStack(mat);
		meta = item.getItemMeta();
		meta.getPersistentDataContainer().set(new NamespacedKey(Plugin.getInstance(), "ID"), PersistentDataType.STRING,
				ID);
		item.setItemMeta(meta);

		Plugin.getItemMain().registerItem(this);
	}

	public String getID() {
		return ID;
	}

	public ItemStack getItem() {
		return item;
	}


	public Item setDisplayName(String name) {
		meta.setDisplayName(name);
		item.setItemMeta(meta);
		return this;
	}

	public Item setLore(String... lore) {
		meta.setLore(Arrays.asList(lore));
		item.setItemMeta(meta);
		return this;
	}

	public Item setLore(Collection<String> lore) {
		meta.setLore(new ArrayList<String>(lore));
		item.setItemMeta(meta);
		return this;
	}

	/*
	 * Sets The Value For The Texture
	 */
	public Item setCustomModelData(int data) {
		meta.setCustomModelData(data);
		item.setItemMeta(meta);
		return this;
	}

	public Item addEnchantment(Enchantment ench, int level) {
		meta.addEnchant(ench, level, true);
		item.setItemMeta(meta);
		return this;
	}

	public Item addItemFlags(ItemFlag... flags) {
		meta.addItemFlags(flags);
		item.setItemMeta(meta);
		return this;
	}

	/*
	 * Adds Data To Persistant Data Container
	 */
	public <Z, T> Item addPDC(NamespacedKey key, PersistentDataType<T, Z> dataType, Z value) {
		meta.getPersistentDataContainer().set(key, dataType, value);
		item.setItemMeta(meta);
		return this;
	}

	/*
	 * Called When This Item Is Interacted With
	 */
	protected void onPlayerInteract(PlayerInteractEvent event) {
	}

	/*
	 * Called When A Block Is Broken With This Item In Hand
	 */

	protected void onBlockBreak(BlockBreakEvent event) {
	}

	/*
	 * Called When A Recipe With This Item As An Ingredient (Or As Result) Is
	 * Completed
	 */
	protected void onCraftItem(CraftItemEvent event) {
	}

	/*
	 * Called When This Item Is Smelted In A Furnace
	 */
	protected void onFurnaceSmelt(FurnaceSmeltEvent event) {
	}

	/*
	 * Called When The Item Is Damaged
	 */
	protected void onItemDamaged(PlayerItemDamageEvent event) {

	}
}
