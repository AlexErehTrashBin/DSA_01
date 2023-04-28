package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer.enums;

public enum StaticCode {
	STATIC('S'),
	NON_STATIC('X');
	private final char aChar;

	StaticCode(char aChar) {
		this.aChar = aChar;
	}

	public static StaticCode getByBoolean(boolean isStatic) {
		if (isStatic) {
			return StaticCode.STATIC;
		}
		return StaticCode.NON_STATIC;
	}

	public char getChar() {
		return aChar;
	}
}
