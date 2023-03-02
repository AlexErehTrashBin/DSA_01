package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

public enum AccessLevel {
	PUBLIC("public", "Public"),
	PRIVATE("private", "Private"),
	PACKAGE_PRIVATE("", "Package-private"),
	PROTECTED("protected", "Protected");
	final String modifierCode;
	final String modifierName;

	AccessLevel(String modifierCode, String modifierName) {
		this.modifierCode = modifierCode;
		this.modifierName = modifierName;
	}

	public String getModifierCode() {
		return modifierCode;
	}

	@Override
	public String toString() {
		return this.modifierName;
	}
}
