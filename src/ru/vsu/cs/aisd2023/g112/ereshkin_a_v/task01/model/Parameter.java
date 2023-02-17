package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

import java.util.Objects;

public class Parameter {
	private String type;
	private String name;

	public Parameter(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public boolean haveSameName(Parameter other){
		return Objects.equals(this.name, other.name);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return type + " " + name;
	}
	/**
	 * Сгенерировано идеей; самое главное - сравнение идёт только по названию.
	 * В объявлении метода не может быть нескольких параметров с одним названием.
	 * */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Parameter parameter = (Parameter) o;

		return name.equals(parameter.name);
	}
}
