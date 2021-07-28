package com.Charlotte.Minecraft.CharlotteUtils.Utils;

public class Shift {
	public static String[] Down(String[] data, int amount) {
		String[] newData = new String[data.length - amount];
		for (int i = 0; i < newData.length; i++) {
			newData[i] = data[i + amount];
		}
		return newData;
	}
}
