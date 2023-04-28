package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.utils.StringUtils;

import java.util.*;


public class ClassDescription {
	private String name;
	private List<Field> fields;
	private List<Method> methods;
	private List<String> parentInterfacesNames;
	private List<String> parentClassesNames;
	private List<ClassDescription> childClasses;
	private AccessLevel accessLevel = AccessLevel.PACKAGE_PRIVATE;
	private boolean isStatic = false;

	public ClassDescription(String name) {
		setName(name);
		initLists();
	}

	private void initLists() {
		fields = new ArrayList<>();
		methods = new ArrayList<>();
		parentInterfacesNames = new ArrayList<>();
		parentClassesNames = new ArrayList<>();
		childClasses = new ArrayList<>();
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

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean aStatic) {
		isStatic = aStatic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getFieldNames() {
		Set<String> result = new HashSet<>();
		fields.forEach(it -> result.add(it.getName()));
		return result;
	}

	public Set<String> getMethodNames() {
		Set<String> result = new HashSet<>();
		methods.forEach(it -> result.add(it.getName()));
		return result;
	}

	public Set<String> getParentInterfacesNames() {
		return new HashSet<>(parentInterfacesNames);
	}

	public Set<String> getParentClassesNames() {
		return new HashSet<>(parentClassesNames);
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

	public void clearParentInterfaces() {
		parentInterfacesNames.clear();
	}

	public void clearParentClasses() {
		parentClassesNames.clear();
	}

	public void clearAllElements() {
		clearMethods();
		clearFields();
	}

	public void clearAllExtendsImplements() {
		clearParentInterfaces();
		clearParentClasses();
	}

	public void clearAll() {
		clearAllExtendsImplements();
		clearAllElements();
	}

	private String getElementPreprocessed(String text) {
		return StringUtils.getTabulatedNTimes(text, 1);
	}


	private <T extends AbstractClassElement> void replace(
			List<T> list, String name, T newElement) {
		for (T elementInSet : list) {
			if (Objects.equals(elementInSet.getName(), name)) {
				list.remove(elementInSet);
				break;
			}
		}
		list.add(newElement);
	}

	public <T extends AbstractClassElement> void replaceOrCreateElement(String elementName, T newElement) {
		if (newElement instanceof Field) {
			replace(fields, elementName, (Field) newElement);
		}
		if (newElement instanceof Method) {
			replace(methods, elementName, (Method) newElement);
		}
	}

	public String getCode() {
		final StringBuilder sb = new StringBuilder();
		/// Построение первой строки

		sb.append(accessLevel.getModifierCode());
		if (accessLevel != AccessLevel.PACKAGE_PRIVATE) sb.append(' ');
		sb.append("class ").append(name);

		// Вставка классов, от которых наследуется текущий
		Set<String> extendsSet = getParentClassesNames();
		if (!extendsSet.isEmpty()) {
			sb.append("extends ");
			sb.append(String.join(", ", extendsSet));
			sb.append(' ');
		}

		// Вставка интерфейсов, которые реализует текущий класс
		Set<String> implementsSet = getParentInterfacesNames();
		if (!implementsSet.isEmpty()) {
			sb.append("implements ");
			sb.append(String.join(", ", implementsSet));
			sb.append(' ');
		}

		if (implementsSet.isEmpty() && extendsSet.isEmpty()) sb.append(' ');
		sb.append('{').append('\n');

		/// Построение тела класса
		// Вставка полей
		for (Field field : fields) {
			String constantString = getElementPreprocessed(field.toString());
			sb.append(Objects.equals(constantString, "") ? "" : constantString + '\n');
		}
		// Вставка дополнительного разрыва строки, разделяющего объявления полей и методов
		if (!fields.isEmpty() && !methods.isEmpty()) sb.append("\n");
		// Вставка методов
		for (Method method : methods) {
			String methodString = getElementPreprocessed(method.toString());
			sb.append(Objects.equals(methodString, "") ? "" : methodString + '\n');
		}
		/// Построение последней строки
		sb.append('}');
		return sb.toString();
	}

	@Override
	public String toString() {
		return getCode();
	}
}
