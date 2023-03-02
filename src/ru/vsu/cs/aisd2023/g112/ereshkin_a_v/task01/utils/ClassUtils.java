package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Field;

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

	public static ClassDescription loadClassFromFile(String path) {
		return new ClassDescription("TestClass");
	}

	public static ClassDescription getDefaultClass(){
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
