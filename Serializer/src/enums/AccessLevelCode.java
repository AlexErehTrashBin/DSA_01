package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer.enums;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;

public enum AccessLevelCode {
	PUBLIC('U'),
	PRIVATE('R'),
	PROTECTED('T'),
	PACKAGE_PRIVATE('X');
	private final char aChar;

	AccessLevelCode(char aChar) {
		this.aChar = aChar;
	}

	public static AccessLevelCode getByAccessLevel(AccessLevel accessLevel) {
		switch (accessLevel) {
			case PUBLIC:
				return PUBLIC;
			case PROTECTED:
				return PROTECTED;
			case PRIVATE:
				return PRIVATE;
			case PACKAGE_PRIVATE:
				return PACKAGE_PRIVATE;
		}
		return AccessLevelCode.PACKAGE_PRIVATE;
	}

	public char getChar() {
		return aChar;
	}
}
