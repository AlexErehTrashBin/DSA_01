package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.utils;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Field;
import ru.vsu.cs.util.ArrayUtils;

import java.io.FileNotFoundException;

public class ClassUtils {
	private static void writeAllInfoAboutClass(ClassDescription description) {
		AccessLevel accessLevel = description.getAccessLevel();
		String accessLevelString = (accessLevel == AccessLevel.PACKAGE_PRIVATE) ? "package private" : accessLevel.toString();

		System.out.println("-----------------------------------");
		System.out.printf("Имя класса: %s%n", description.getName());
		System.out.printf("Модификатор доступа класса: %s%n", accessLevelString);
		System.out.printf("Поля в классе: %s%n", description.getFieldNames());
		System.out.printf("Методы в классе: %s%n", description.getMethodNames());
		System.out.printf("Результат конвертации объявления класса в код: %n%s%n", description);
		System.out.println("-----------------------------------");
	}

	public static void writeAllInfoAboutClasses(ClassDescription... classes) {
		for (ClassDescription classDescription : classes) {
			writeAllInfoAboutClass(classDescription);
			System.out.println();
		}
	}

	public static ClassDescription loadClassFromFile(String path) throws FileNotFoundException {
		String[] lines = ArrayUtils.readLinesFromFile(path);
		String declaration = lines[0];
		AccessLevel level = AccessLevel.PACKAGE_PRIVATE;
		boolean isStatic = false;
		if (declaration.contains("public")) level = AccessLevel.PUBLIC;
		if (declaration.contains("static")) isStatic = true;
		declaration = declaration.replace("public ", "");
		declaration = declaration.replace("static ", "");
		StringBuilder nameSB = new StringBuilder();
		for (int i = 0; declaration.charAt(i) != ' '; i++) {
			nameSB.append(declaration.charAt(i));
		}
		String name = nameSB.toString();
		ClassDescription description = new ClassDescription(name);
		description.setAccessLevel(level);
		description.setStatic(isStatic);
		return new ClassDescription(name);
	}

	public static ClassDescription getDefaultClass() {
		ClassDescription result = new ClassDescription("SampleClass");

		Field field1 = new Field("int", "testInt", "0");
		Field field2 = new Field("double", "double1");
		Field field3 = new Field("int", "testInt1", "3");
		Field field4 = new Field("int", "TEST_INT_2", "300");
		field4.setStatic(true);
		field4.setFinal(true);

		result.addFields(field1, field2, field3, field4);

		return result;
	}
}
