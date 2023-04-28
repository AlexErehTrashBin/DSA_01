package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.utils;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Method;

public class MethodUtils {
	private static void writeAllInfoAboutMethod(Method method) {
		AccessLevel accessLevel = method.getAccessLevel();
		String accessLevelString = (accessLevel == AccessLevel.PACKAGE_PRIVATE) ? "package private" : accessLevel.toString();

		System.out.println("-----------------------------------");
		System.out.printf("Имя метода: %s%n", method.getName());
		System.out.printf("Возвращаемый тип метода: %s%n", method.getType());
		System.out.printf("Модификатор доступа метода: %s%n", accessLevelString);
		System.out.printf("Метод помечен как static: %b%n", method.isStatic());
		System.out.printf("Метод помечен как final: %b%n", method.isFinal());
		System.out.printf("Количество параметров метода: %d%n", method.getNumberOfParameters());
		System.out.printf("Результат конвертации объявления метода в код: %n%s%n", method);
		System.out.println("-----------------------------------");
	}

	public static void writeAllInfoAboutMethods(Method... methods) {
		for (Method method : methods) {
			writeAllInfoAboutMethod(method);
			System.out.println();
		}
	}

	public static Method getDefaultMethod() {
		Method method = new Method("main", "void");
		method.setBody("return;");
		method.setAccessLevel(AccessLevel.PUBLIC);
		method.setStatic(true);
		return method;
	}
}
