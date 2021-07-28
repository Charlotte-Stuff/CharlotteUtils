package com.Charlotte.Minecraft.CharlotteUtils.CommandHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandGroup {
	private String name;
	private CommandMain main;

	public CommandGroup(String name, CommandMain main) {
		this.name = name;
		this.main = main;
	}

	HashMap<String, CommandBase> commands = new HashMap<String, CommandBase>();

	public CommandGroup addMember(CommandBase command) {
		command.setIsSubcommand(true);
		commands.put(command.getName(), command);
		return this;
	}

	public List<String> getAutoCompleteCommands() {
		return new ArrayList<String>(commands.keySet());
	}

	public void register() {
		main.register(this);
	}

	public String getName() {
		return name;
	}

	public HashMap<String, CommandBase> getCommands() {
		return commands;
	}

	public boolean hasCommand(String label) {
		return commands.containsKey(label);
	}

	public CommandBase getCommand(String label) {
		return commands.get(label);
	}

}
