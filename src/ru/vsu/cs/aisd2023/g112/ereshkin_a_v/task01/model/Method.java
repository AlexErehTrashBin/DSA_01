package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

import java.util.ArrayList;
import java.util.List;

public class Method {
	private String name;
	private String returnType;
	// TODO Добавить необходимость инициализации метода при private, protected (если потребуется)
	private AccessLevel accessLevel;
	private final List<Parameter> parameters;
	// TODO Добавить необходимость инициализации метода при static
	private boolean isStatic;

	public Method(String name, String returnType, AccessLevel accessLevel, boolean isStatic) {
		this.name = name;
		this.returnType = returnType;
		this.accessLevel = accessLevel;
		this.isStatic = isStatic;
		this.parameters = new ArrayList<>();
	}

	public Method() {
		this.parameters = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getReturnType() {
		return returnType;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	public void addParameter(Parameter parameter) {
		if (!parameters.contains(parameter)) {
			parameters.add(parameter);
		}
	}
	public int getNumberOfParameters(){
		return parameters.size();
	}
	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean aStatic) {
		isStatic = aStatic;
	}
	// TODO Добавить упрощение объявления (все методы в интерфейсе по умолчанию public и т.п.)
	@Override
	public String toString() {
		if (name == null || returnType == null || accessLevel == null) return "";
		final StringBuilder sb = new StringBuilder();
		sb.append(accessLevel);
		sb.append(accessLevel.getAccessLevelType() != AccessLevel.AccessLevelType.PACKAGE_PRIVATE ? " " : "");
		sb.append(isStatic ? "static " : "");
		sb.append(returnType).append(" ");
		sb.append(name).append(" (");
		for (int i = 0; i < parameters.size() - 1; i++) {
			sb.append(parameters.get(i)).append(", ");
		}
		if (!parameters.isEmpty()) sb.append(parameters.get(parameters.size() - 1));
		sb.append(");");
		return sb.toString();
	}
}
