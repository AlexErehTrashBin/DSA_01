package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

public enum AccessLevel {
	PUBLIC("public", "Public", "A"),
	PRIVATE("private", "Private", "P"),
	PACKAGE_PRIVATE("", "Package-private", "X"),
	PROTECTED("protected", "Protected", "S");
	final String modifierCode;
	final String modifierName;
	final String serial;

	AccessLevel(String modifierCode, String modifierName, String serial) {
		this.modifierCode = modifierCode;
		this.modifierName = modifierName;
		this.serial = serial;
	}

	public static AccessLevel getBySerial(String serial){
		if (serial.equals("A")) return PUBLIC;
		if (serial.equals("P")) return PRIVATE;
		if (serial.equals("S")) return PROTECTED;
		return PACKAGE_PRIVATE;
	}

	public String getModifierCode() {
		return modifierCode;
	}

	public String getSerial(){
		return serial;
	}

	@Override
	public String toString() {
		return this.modifierName;
	}
}
