package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

public enum AccessLevel {
	PUBLIC("public"),
	PRIVATE("private"),
	PACKAGE_PRIVATE(""),
	PROTECTED("protected");
	final String modifierName;

	AccessLevel(String modifierName) {
		this.modifierName = modifierName;
	}

	@Override
	public String toString() {
		return this.modifierName;
	}
}
