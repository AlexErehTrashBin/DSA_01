package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer.enums;

public enum FinalCode {
	FINAL('F'),
	NON_FINAL('X');
	private final char aChar;

	FinalCode(char aChar) {
		this.aChar = aChar;
	}

	public static FinalCode getByBoolean(boolean isFinal) {
		if (isFinal) {
			return FinalCode.FINAL;
		}
		return FinalCode.NON_FINAL;
	}

	public char getChar() {
		return aChar;
	}
}
