package com.Charlotte.Minecraft.CharlotteUtils.CommandHandling;

import java.util.HashMap;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;

import com.Charlotte.Minecraft.CharlotteUtils.Plugin;
import com.Charlotte.Minecraft.CharlotteUtils.Utils.Shift;

public class CommandMain implements CommandExecutor {

	HashMap<String, CommandBase> commands = new HashMap<String, CommandBase>();
	HashMap<String, CommandGroup> commandGroup = new HashMap<String, CommandGroup>();
	AutoComplete ac = new AutoComplete(this);

	public CommandMain() {
	}

	public void register(CommandBase command) {
		commands.put(command.getName(), command);
		System.out.println("CMD :" + command.getName());
		PluginCommand cmd = Plugin.getInstance().getCommand(command.getName());
		cmd.setExecutor(this);
		cmd.setTabCompleter(ac);
	}

	public void register(CommandGroup group) {
		commandGroup.put(group.getName(), group);
		PluginCommand cmd = Plugin.getInstance().getCommand(group.getName());
		cmd.setExecutor(this);
		cmd.setTabCompleter(ac);

	}

	public boolean isGroup(String name) {
		return commandGroup.containsKey(name);
	}

	public boolean isCommand(String name) {
		return commands.containsKey(name);
	}

	public CommandGroup getGroup(String name) {
		return commandGroup.get(name);
	}

	public CommandBase getCommand(String name) {
		if (commands.containsKey(name)) {
			return commands.get(name);
		} else {
			for (CommandGroup group : commandGroup.values()) {
				return group.getCommand(name);
			}
		}
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (isCommand(label)) {
			return commands.get(label).execute(sender, args);
		} else if (isGroup(label)) {
			return commandGroup.get(label).getCommand(args[0]).execute(sender, Shift.Down(args, 1));
		} else {
			return false;
		}
	}
}
