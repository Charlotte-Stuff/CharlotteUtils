package com.Charlotte.Minecraft.CharlotteUtils.Utils;

public class Colors {
	public static final String CONSOLE_BLACK_BACKGROUND = "\u001B[40m";
	public static final String CONSOLE_RED_BACKGROUND = "\u001B[41m";
	public static final String CONSOLE_GREEN_BACKGROUND = "\u001B[42m";
	public static final String CONSOLE_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String CONSOLE_BLUE_BACKGROUND = "\u001B[44m";
	public static final String CONSOLE_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String CONSOLE_CYAN_BACKGROUND = "\u001B[46m";
	public static final String CONSOLE_WHITE_BACKGROUND = "\u001B[47m";

	public static final String CONSOLE_RESET = "\u001B[0m";
	public static final String CONSOLE_BLACK = "\u001B[30m";
	public static final String CONSOLE_RED = "\u001B[31m";
	public static final String CONSOLE_GREEN = "\u001B[32m";
	public static final String CONSOLE_YELLOW = "\u001B[33m";
	public static final String CONSOLE_BLUE = "\u001B[34m";
	public static final String CONSOLE_PURPLE = "\u001B[35m";
	public static final String CONSOLE_CYAN = "\u001B[36m";
	public static final String CONSOLE_WHITE = "\u001B[37m";

	public static void reset() {
		System.out.print(CONSOLE_RESET);
	}

}
