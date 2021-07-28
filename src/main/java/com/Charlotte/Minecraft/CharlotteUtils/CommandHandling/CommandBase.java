package com.Charlotte.Minecraft.CharlotteUtils.CommandHandling;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.Charlotte.Minecraft.CharlotteUtils.Plugin;

import java.util.Arrays;

public class CommandBase {
	private String name;
	private List<String[]> autoCompleteOptions;
	private boolean isSubcommand = false;

	public CommandBase(String name, String[]... autoCompleteOptions) {
		this.name = name;
		this.autoCompleteOptions = Arrays.asList(autoCompleteOptions);
	}

	public CommandBase(String name, CommandGroup group, String[]... autoCompleteOptions) {
		this.name = name;
		this.autoCompleteOptions = Arrays.asList(autoCompleteOptions);
		group.addMember(this);
	}

	public boolean execute(CommandSender sender, String[] args) {
		return false;
	}

	protected void register() {
		Plugin.getCommandMain().register(this);
	}

	public boolean getIsSubcommand() {
		return isSubcommand;
	}

	public void setIsSubcommand(boolean isSubcommand) {
		this.isSubcommand = isSubcommand;
	}

	public String getName() {
		return name;
	}

	public List<String> getAutoCompleteOptions(int argNumber) {
		return Arrays.asList(autoCompleteOptions.get(argNumber));
	}

	public static class Subcommand extends CommandBase {
		public Subcommand(String name, CommandGroup group, String[]... autoCompleteOptions) {
			super(name, group, autoCompleteOptions);
		}
	}

	public static class StandaloneCommand extends CommandBase {
		public StandaloneCommand(String name, String[]... autoCompleteOptions) {
			super(name, autoCompleteOptions);
			this.register();
		}
	}

}
