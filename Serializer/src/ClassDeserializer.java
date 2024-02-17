package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Field;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Method;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassDeserializer {
	public static ClassDescription getClassFromLines(String[] lines){
		String[] classDeclarationArr = lines[0].split("(//)+");
		if (!Objects.equals(classDeclarationArr[0], "CLASS")) return null;
		AccessLevel level = AccessLevel.getBySerial(classDeclarationArr[1]);
		boolean isStatic = classDeclarationArr[2].equals("S");
		String name = classDeclarationArr[3];
		List<String> parentInterfaces = getListFromString(classDeclarationArr[4]);
		List<String> parentClasses = getListFromString(classDeclarationArr[5]);
		ClassDescription classDescription = new ClassDescription(name);
		classDescription.setAccessLevel(level);
		classDescription.setStatic(isStatic);
		parentClasses.forEach(classDescription::addParentClassName);
		parentInterfaces.forEach(classDescription::addParentInterfaceName);

		for (int i = 1; i < lines.length; i++) {
			String line = lines[i];
			if (line.startsWith("FIELD")){
				Field field = getFieldFromLine(line);
				if (field == null) continue;
				classDescription.addFields(field);
			} else if (line.startsWith("METHOD")){
				Method method = getMethodFromLine(line);
				if (method == null) continue;
				classDescription.addMethods(method);
			}
		}

		return classDescription;
	}

	private static Field getFieldFromLine(String line) {
		String[] split = line.split("(//)+");
		if (!Objects.equals(split[0], "FIELD")) return null;
		AccessLevel level = AccessLevel.getBySerial(split[1]);
		boolean isStatic = split[2].equals("S");
		boolean isFinal = split[3].equals("F");
		String type = split[4];
		String name = split[5];
		int length = Integer.parseInt(split[6]);
		String value = length != 0 ? split[7] : null;
		Field field = new Field(type, name);
		field.setAccessLevel(level);
		field.setStatic(isStatic);
		field.setFinal(isFinal);
		field.setInitialValue(value);
		return field;
	}

	private static Method getMethodFromLine(String line) {
		String[] split = line.split("(//)+");
		if (!Objects.equals(split[0], "METHOD")) return null;
		AccessLevel level = AccessLevel.getBySerial(split[1]);
		boolean isStatic = split[2].equals("S");
		boolean isFinal = split[3].equals("F");
		String type = split[4];
		String name = split[5];
		int length = Integer.parseInt(split[6]);
		String body = length != 0 ? split[7] : null;
		Method method = new Method(type, name);
		method.setAccessLevel(level);
		method.setStatic(isStatic);
		method.setFinal(isFinal);
		method.setBody(body);
		return method;
	}

	public static List<String> getListFromString(String input){
		// Remove leading and trailing square brackets
		String trimmedInput = input.substring(1, input.length() - 1);

		// Remove spaces within the string
		String cleanedInput = trimmedInput.replaceAll("\\s+", "");

		// Split the string by comma
		String[] stringArray = cleanedInput.split(",");

		// Create a list to store the extracted strings
		List<String> stringList = new ArrayList<>();

		// Iterate over the string array and add elements to the list
		for (String str : stringArray) {
			// Remove surrounding double quotes
			String cleanedStr = str.replaceAll("\"", "");
			if (cleanedStr.isEmpty()) continue;
			if (cleanedStr.equals(" ")) continue;
			stringList.add(cleanedStr);
		}

		return stringList;
	}
}
