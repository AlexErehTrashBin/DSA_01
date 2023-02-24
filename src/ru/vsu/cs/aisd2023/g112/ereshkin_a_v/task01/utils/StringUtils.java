package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils;

public class StringUtils {
	public static String getTabulatedNTimes(String text, int n) {
		StringBuilder resultSB = new StringBuilder();
		for (int i = 0; i < n; i++) {
			resultSB.append('\t');
		}
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			if (currentChar == '\n') {
				resultSB.append(currentChar);
				for (int j = 0; j < n; j++) {
					resultSB.append('\t');
				}
			} else {
				resultSB.append(currentChar);
			}
		}
		return resultSB.toString();
	}
}
