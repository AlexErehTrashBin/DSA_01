package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;


import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Method extends ClassElement {
	private List<Parameter> parameters;
	private String body = "";

	public Method(String name, String type, AccessLevel accessLevel, boolean isStatic, boolean isFinal) {
		super(type, name);
		setAccessLevel(accessLevel);
		setStatic(isStatic);
		setFinal(isFinal);
		initParameters();
	}

	public Method(String name, String type) {
		super(type, name);
		initParameters();
	}

	private void initParameters() {
		parameters = new ArrayList<>();
	}

	private String getPreprocessedBody(String inputBody) {
		return StringUtils.getTabulatedNTimes(inputBody, 1);
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void addParameter(Parameter parameter) {
		if (!parameters.contains(parameter)) {
			parameters.add(parameter);
		}
	}

	public int getNumberOfParameters() {
		return parameters.size();
	}

	@Override
	public String toString() {
		if (getName() == null || getType() == null || getAccessLevel() == null) return "";
		final StringBuilder sb = new StringBuilder();
		// Обработка первой строки
		sb.append(getAccessLevel().getModifierCode());
		sb.append(getAccessLevel() != AccessLevel.PACKAGE_PRIVATE ? " " : "");
		sb.append(isStatic() ? "static " : "");
		sb.append(isFinal() ? "final " : "");
		sb.append(getType()).append(" ");
		sb.append(getName()).append("(");
		for (int i = 0; i < parameters.size() - 1; i++) {
			sb.append(parameters.get(i)).append(", ");
		}
		if (!parameters.isEmpty()) sb.append(parameters.get(parameters.size() - 1));
		sb.append(") {\n");
		// Обработка тела метода
		String preprocessedBody = getPreprocessedBody(body);
		sb.append(preprocessedBody);
		if (!preprocessedBody.equals("")) sb.append("\n");
		// Обработка закрывающей фигурной скобки
		sb.append("}");
		return sb.toString();
	}
}