package com.Charlotte.Minecraft.CharlotteUtils.Blocks;

import java.util.HashMap;

import org.bukkit.Location;

public class Block {
	org.bukkit.block.Block block;
	Location loc;

	HashMap<String, Object> data = new HashMap<String, Object>();

	public Block(org.bukkit.block.Block block) {
		this.block = block;
		this.loc = block.getLocation();
		String data = getData("id");
	}

	public void addData(String key, BlockDataType dataType, Object value) {
		if (dataType.getClass() != value.getClass()) {
			System.out.println("!!! DataType Does Not Match Value !!!");
			return;
		}
		data.put(key, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T getData(String key) {
		Object o = data.get(key);
		return (T) o.getClass().cast(o);
	}
}
