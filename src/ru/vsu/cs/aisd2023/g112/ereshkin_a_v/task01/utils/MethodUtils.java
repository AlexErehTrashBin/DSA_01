package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Method;

public class MethodUtils {
	private static void writeAllInfoAboutMethod(Method method){
		System.out.println("-----------------------------------");
		System.out.printf("Результат конвертации объявления метода в код: %n%s%n", method);
		System.out.printf("Имя метода: %s%n", method.getName());
		System.out.printf("Возвращаемый тип метода: %s%n", method.getReturnType());
		System.out.printf("Модификатор доступа метода: %s%n", method.getAccessLevel());
		System.out.printf("Метод статичен: %b%n", method.isStatic());
		System.out.printf("Количество параметров метода: %d%n", method.getNumberOfParameters());
		System.out.println("-----------------------------------");
	}
	public static void writeAllInfoAboutMethods(Method... methods){
		for (Method method : methods) {
			writeAllInfoAboutMethod(method);
		}
	}
}
