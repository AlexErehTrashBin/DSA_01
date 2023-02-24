package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

import java.util.ArrayList;
import java.util.List;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.StringUtils;

public class Method {
	private List<Parameter> parameters;
	private String name;
	private String returnType;
	private AccessLevel accessLevel = AccessLevel.PACKAGE_PRIVATE;
	private String body = "";
	private boolean isStatic = false;
	private boolean isFinal = false;

	public Method(String name, String returnType, AccessLevel accessLevel, boolean isStatic, boolean isFinal) {
		setName(name);
		setReturnType(returnType);
		setAccessLevel(accessLevel);
		setStatic(isStatic);
		setFinal(isFinal);
		initParameters();
	}

	public Method(String name, String returnType) {
		setName(name);
		setReturnType(returnType);
		initParameters();
	}
	private void initParameters(){
		parameters = new ArrayList<>();
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String getPreprocessedBody(String inputBody){
		return StringUtils.getTabulatedNTimes(inputBody, 1);
	}

	public void setBody(String body) {
		this.body = getPreprocessedBody(body);
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
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

	public int getNumberOfParameters() {
		return parameters.size();
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean aStatic) {
		isStatic = aStatic;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean aFinal) {
		isFinal = aFinal;
	}

	@Override
	public String toString() {
		if (name == null || returnType == null || accessLevel == null) return "";
		final StringBuilder sb = new StringBuilder();
		// Обработка первой строки
		sb.append(accessLevel);
		sb.append(accessLevel != AccessLevel.PACKAGE_PRIVATE ? " " : "");
		sb.append(isStatic ? "static " : "");
		sb.append(isFinal ? "final " : "");
		sb.append(returnType).append(" ");
		sb.append(name).append("(");
		for (int i = 0; i < parameters.size() - 1; i++) {
			sb.append(parameters.get(i)).append(", ");
		}
		if (!parameters.isEmpty()) sb.append(parameters.get(parameters.size() - 1));
		sb.append(") {\n");
		// Обработка тела метода
		sb.append(body);
		if (!body.equals("")) sb.append("\n");
		// Обработка закрывающей фигурной скобки
		sb.append("}");
		return sb.toString();
	}
}
