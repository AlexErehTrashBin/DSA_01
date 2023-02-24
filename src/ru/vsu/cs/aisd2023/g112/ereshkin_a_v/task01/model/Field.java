package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

public class Field {
	private AccessLevel accessLevel;
	private String name;
	private String type;
	private String initialValue;
	private boolean isFinal = false;
	private boolean isStatic = false;

	public Field(String type, String name, String initialValue) {
		setName(name);
		setType(type);
		setInitialValue(initialValue);
		setAccessLevel(AccessLevel.PACKAGE_PRIVATE);
	}

	public Field(String type, String name) {
		setName(name);
		setType(type);
		setInitialValue(initialValue);
		setAccessLevel(AccessLevel.PACKAGE_PRIVATE);
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean aFinal) {
		isFinal = aFinal;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean aStatic) {
		isStatic = aStatic;
	}

	@Override
	public String toString() {
		if (name == null || type == null) return "";
		final StringBuilder sb = new StringBuilder();

		// Обработка модификатора доступа
		sb.append(accessLevel.toString());
		if (accessLevel != AccessLevel.PACKAGE_PRIVATE) sb.append(' ');
		// Обработка статичности поля
		if (isStatic) sb.append("static ");
		// Обработка финализированности поля
		if (isFinal) sb.append("final ");
		// Обработка имени поля
		sb.append(type).append(' ').append(name);
		// Обработка начального значения
		if (initialValue == null) {
			sb.append(';');
			return sb.toString();
		}
		sb.append(" = ").append(initialValue).append(';');

		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Field field = (Field) o;

		return name.equals(field.name);
	}
}