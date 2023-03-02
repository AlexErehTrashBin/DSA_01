package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Field;

public class FieldUtils {
	private static void writeAllInfoAboutField(Field field) {
		AccessLevel accessLevel = field.getAccessLevel();
		String accessLevelString = (accessLevel == AccessLevel.PACKAGE_PRIVATE) ? "package private" : accessLevel.toString();

		System.out.println("-----------------------------------");
		System.out.printf("Имя поля: %s%n", field.getName());
		System.out.printf("Тип поля: %s%n", field.getType());
		System.out.printf("Модификатор доступа поля: %s%n", accessLevelString);
		System.out.printf("Поле помечено как static: %s%n", field.isStatic());
		System.out.printf("Поле помечено как final: %s%n", field.isFinal());
		System.out.printf("Начальное значение поля: %s%n", field.getInitialValue());
		System.out.printf("Результат конвертации объявления поля в код: %n%s%n", field);
		System.out.println("-----------------------------------");
	}

	public static void writeAllInfoAboutFields(Field... fields) {
		for (Field field : fields) {
			writeAllInfoAboutField(field);
			System.out.println();
		}
	}

	public static Field getDefault(){
		Field result = new Field("int", "sampleInt", "1");
		result.setFinal(true);
		return result;
	}
}
