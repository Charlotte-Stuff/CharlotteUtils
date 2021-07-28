package com.Charlotte.Minecraft.CharlotteUtils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Match {

	public static List<String> String(String input, Collection<String> options) {
		ArrayList<String> results = new ArrayList<String>();
		int best = 0;
		for (String s : options) {
			int i = 0;

			while (input.length() > i && s.length() > i && input.charAt(i) == s.charAt(i)) {
				i++;
			}
			if (i > best) {
				results.clear();
				results.add(s);
				best = i;
			} else if (i == best) {
				results.add(s);
			}
		}
		return results;
	}
}
