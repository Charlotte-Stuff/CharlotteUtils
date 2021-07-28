package com.Charlotte.Minecraft.CharlotteUtils.Blocks;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockRedstoneEvent;

public class BlockMain implements Listener {
	HashMap<Location, Block> blocks = new HashMap<Location, Block>();

	@EventHandler
	public void onBlockBurn(BlockBurnEvent event) {

	}

	@EventHandler
	public void onBlockDamage(BlockDamageEvent event) {

	}

	@EventHandler
	public void onBlockPistonExtend(BlockPistonExtendEvent event) {

	}

	@EventHandler
	public void onBlockPistonRetract(BlockPistonRetractEvent event) {

	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {

	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {

	}

	@EventHandler
	public void onBlockRedstone(BlockRedstoneEvent event) {

	}

}
