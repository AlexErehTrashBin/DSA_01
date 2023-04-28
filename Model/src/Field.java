package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

public class Field extends ClassElement {
	private String initialValue;

	public Field(String type, String name, String initialValue) {
		super(type, name);
		setInitialValue(initialValue);
		setAccessLevel(AccessLevel.PACKAGE_PRIVATE);
	}

	public Field(String type, String name) {
		super(type, name);
		setAccessLevel(AccessLevel.PACKAGE_PRIVATE);
	}

	public String getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}

	@Override
	public String toString() {
		if (getName() == null || getType() == null) return "";
		final StringBuilder sb = new StringBuilder();
		AccessLevel accessLevel = super.getAccessLevel();
		// Обработка модификатора доступа
		sb.append(accessLevel.getModifierCode());
		if (accessLevel != AccessLevel.PACKAGE_PRIVATE) sb.append(' ');
		// Обработка статичности поля
		if (isStatic()) sb.append("static ");
		// Обработка финализированности поля
		if (isFinal()) sb.append("final ");
		// Обработка имени поля
		sb.append(getType()).append(' ').append(getName());
		// Обработка начального значения
		if (initialValue == null) {
			sb.append(';');
			return sb.toString();
		}
		sb.append(" = ").append(initialValue).append(';');

		return sb.toString();
	}
}