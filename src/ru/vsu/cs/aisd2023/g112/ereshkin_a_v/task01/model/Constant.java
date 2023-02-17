package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

public class Constant {
	private String name;
	private String type;
	private String value;

	public Constant() {
	}

	public Constant(String name, String type, String value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	public boolean isFinal() {
		return true;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		if (name == null || type == null || value == null) return "";
		final StringBuilder sb = new StringBuilder();
		sb.append(type).append(" ");
		sb.append(name).append(" = ");
		sb.append(value);
		sb.append(";");
		return sb.toString();
	}
}
