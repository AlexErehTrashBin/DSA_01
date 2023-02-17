package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

import java.util.Objects;

public class AccessLevel {
	public enum AccessLevelType {
		PUBLIC,
		PROTECTED,
		PACKAGE_PRIVATE,
		PRIVATE
	}
	private final AccessLevelType accessLevelType;

	public AccessLevel(String modifierName) throws IllegalArgumentException {
		if (Objects.equals(modifierName, "public")){
			this.accessLevelType = AccessLevelType.PUBLIC;
		} else if (Objects.equals(modifierName, "private")){
			this.accessLevelType = AccessLevelType.PRIVATE;
		} else if (Objects.equals(modifierName, "")){
			this.accessLevelType = AccessLevelType.PACKAGE_PRIVATE;
		} else if (Objects.equals(modifierName, "protected")){
			this.accessLevelType = AccessLevelType.PROTECTED;
		} else {
			throw new IllegalArgumentException("Неизвестный модификатор доступа!");
		}
	}
	public AccessLevelType getAccessLevelType() {
		return accessLevelType;
	}

	@Override
	public String toString() {
		if (accessLevelType == AccessLevelType.PACKAGE_PRIVATE) return "";
		if (accessLevelType == AccessLevelType.PRIVATE) return "private";
		if (accessLevelType == AccessLevelType.PROTECTED) return "protected";
		if (accessLevelType == AccessLevelType.PUBLIC) return "public";

		return super.toString();
	}
}
