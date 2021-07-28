package com.Charlotte.Minecraft.CharlotteUtils.CommandHandling;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import com.Charlotte.Minecraft.CharlotteUtils.Utils.Match;

public class AutoComplete implements TabCompleter {

	CommandMain main;

	public AutoComplete(CommandMain main) {
		this.main = main;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		boolean isGroup = main.isGroup(alias);

		if (args.length == 1 && isGroup) {
			CommandGroup group = main.getGroup(alias);
			return getCommandGroup(group, args[0]);
		} else {
			CommandBase cmd = main.getCommand(isGroup ? args[0] : alias);
			if (cmd == null) {
				return null;
			}
			return getCommand(cmd, args[args.length - 1], args.length - 2);
		}
	}

	public List<String> getCommandGroup(CommandGroup group, String input) {
		return Match.String(input, group.getAutoCompleteCommands());
	}

	public List<String> getCommand(CommandBase command, String input, int index) {
		return Match.String(input, command.getAutoCompleteOptions(index));
	}

}
