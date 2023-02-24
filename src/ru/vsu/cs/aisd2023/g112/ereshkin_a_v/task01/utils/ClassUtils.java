package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;

public class ClassUtils {
	private static void writeAllInfoAboutClass(ClassDescription description){

		System.out.println("-----------------------------------");
		System.out.printf("Результат конвертации объявления класса в код: %n%s%n", description);
		System.out.printf("Имя класса: %s%n", description.getName());
		System.out.printf("Поля в классе: %s%n", description.getFieldNames());
		System.out.printf("Методы в классе: %s%n", description.getMethodNames());
		System.out.println("-----------------------------------");
	}
	public static void writeAllInfoAboutClasses(ClassDescription... classes){
		for (ClassDescription classDescription : classes) {
			writeAllInfoAboutClass(classDescription);
			System.out.println();
		}
	}
	public static ClassDescription loadClassFromFile(String path){
		return new ClassDescription("TestClass");
	}
}
