package com.Charlotte.Minecraft.CharlotteUtils;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.Charlotte.Minecraft.CharlotteUtils.CommandHandling.CommandMain;
import com.Charlotte.Minecraft.CharlotteUtils.Items.ItemMain;
import com.Charlotte.Minecraft.CharlotteUtils.Utils.Colors;

public class Plugin extends JavaPlugin {
	private static Plugin instance;
	private static CommandMain commands;
	private static ItemMain items;

	@Override
	public void onEnable() {
		instance = this;
		commands = new CommandMain();
		items = new ItemMain();

		PluginDescriptionFile pdf = this.getDescription();
		System.out.println(Colors.CONSOLE_WHITE + Colors.CONSOLE_YELLOW_BACKGROUND + "-------------------------");
		Colors.reset();
		System.out.println(Colors.CONSOLE_CYAN + "Loading " + this.getName());
		System.out.println(Colors.CONSOLE_CYAN + "Made By " + String.join(",", pdf.getAuthors()));
		System.out.println(Colors.CONSOLE_CYAN + "Version " + pdf.getVersion());
		Colors.reset();
		System.out.println(Colors.CONSOLE_WHITE + Colors.CONSOLE_YELLOW_BACKGROUND + "-------------------------");
		Colors.reset();
	}

	public static CommandMain getCommandMain() {
		return commands;
	}

	public static Plugin getInstance() {
		return instance;
	}

	public static ItemMain getItemMain() {
		return items;
	}
}
