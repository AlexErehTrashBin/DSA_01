package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Constant;

public class ConstantUtils {
	private static void writeAllInfoAboutConstant(Constant constant){
		System.out.println("-----------------------------------");
		System.out.printf("Результат конвертации объявления константы в код: %n%s%n", constant);
		System.out.printf("Тип константы: %s%n", constant.getType());
		System.out.printf("Имя константы: %s%n", constant.getName());
		System.out.printf("Значение константы: %s%n", constant.getValue());
		System.out.printf("Константа помечена как final: %s%n", constant.isFinal());
		System.out.println("-----------------------------------");
	}
	public static void writeAllInfoAboutConstants(Constant... constants){
		for (Constant constant : constants) {
			writeAllInfoAboutConstant(constant);
		}
	}
}
