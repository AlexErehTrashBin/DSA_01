package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.StringUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class ClassDescription {
	private String name;
	private Set<Field> fields;
	private Set<Method> methods;
	private Set<String> parentInterfacesNames;
	private Set<String> parentClassesNames;
	private AccessLevel accessLevel = AccessLevel.PUBLIC;

	public ClassDescription(String name) {
		setName(name);
		initSets();
	}

	private void initSets() {
		fields = new HashSet<>();
		methods = new HashSet<>();
		parentInterfacesNames = new HashSet<>();
		parentClassesNames = new HashSet<>();
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) throws IllegalArgumentException {
		if (accessLevel == AccessLevel.PROTECTED || accessLevel == AccessLevel.PRIVATE) {
			throw new IllegalArgumentException("Попытка установить некорректный модификатор доступа класса: " + accessLevel);
		}
		this.accessLevel = accessLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Field> getFields() {
		return fields;
	}

	public Set<String> getFieldNames() {
		Set<String> result = new HashSet<>();
		fields.forEach(it -> result.add(it.getName()));
		return result;
	}

	public Set<Method> getMethods() {
		return methods;
	}

	public Set<String> getMethodNames() {
		Set<String> result = new HashSet<>();
		methods.forEach(it -> result.add(it.getName()));
		return result;
	}

	public Set<String> getParentInterfacesNames() {
		return parentInterfacesNames;
	}

	public Set<String> getParentClassesNames() {
		return parentClassesNames;
	}

	public void addMethods(Method... methods) {
		Set<String> duplicatesNames = new HashSet<>();
		for (Method method : methods) {
			if (this.methods.contains(method)) {
				duplicatesNames.add(method.getName());
			} else {
				this.methods.add(method);
			}
		}
		if (duplicatesNames.isEmpty()) return;
		StringBuilder messageSB = new StringBuilder();
		messageSB.append("В попытке добавить методы ");
		String joinedDuplicatesNames = String.join(", ", duplicatesNames);
		messageSB.append(joinedDuplicatesNames).append(" ");
		messageSB.append("они уже были найдены в классе");
		throw new IllegalStateException(messageSB.toString());
	}

	public void addFields(Field... fields) {
		Set<String> duplicatesNames = new HashSet<>();
		for (Field field : fields) {
			if (this.fields.contains(field)) {
				duplicatesNames.add(field.getName());
			} else {
				this.fields.add(field);
			}
		}
		if (duplicatesNames.isEmpty()) return;
		StringBuilder messageSB = new StringBuilder();
		messageSB.append("В попытке добавить поля ");
		String joinedDuplicatesNames = String.join(",", duplicatesNames);
		messageSB.append(joinedDuplicatesNames).append(" ");
		messageSB.append("они уже были найдены в классе");
		throw new IllegalStateException(messageSB.toString());
	}

	public void clearMethods() {
		methods.clear();
	}

	public void clearFields() {
		fields.clear();
	}

	private String getMethodPreprocessed(String text) {
		return StringUtils.getTabulatedNTimes(text, 1);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		/// Построение первой строки
		sb.append("class ").append(name).append(" {").append("\n");

		/// Построение тела класса
		// Вставка полей
		for (Field field : fields) {
			String constantString = field.toString();
			sb.append(Objects.equals(constantString, "") ? "" : "\t" + constantString + "\n");
		}
		// Вставка дополнительного разрыва строки, разделяющего объявления полей и методов
		if (!fields.isEmpty() && !methods.isEmpty()) sb.append("\n");
		// Вставка методов
		for (Method method : methods) {
			String methodString = getMethodPreprocessed(method.toString());
			sb.append(Objects.equals(methodString, "") ? "" : methodString + "\n");
		}
		/// Построение последней строки
		sb.append("}");
		return sb.toString();
	}
}
