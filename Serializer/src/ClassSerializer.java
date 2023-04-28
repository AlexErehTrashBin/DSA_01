package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer.enums.AccessLevelCode;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer.enums.StaticCode;

public class ClassSerializer {
	private static String getAccessLevelString(ClassDescription description) {
		AccessLevel accessLevel = description.getAccessLevel();
		AccessLevelCode accessLevelCode = AccessLevelCode.getByAccessLevel(accessLevel);
		return String.valueOf(accessLevelCode.getChar());
	}

	private static String getStaticString(ClassDescription description) {
		boolean isStatic = description.isStatic();
		StaticCode staticCode = StaticCode.getByBoolean(isStatic);
		return String.valueOf(staticCode.getChar());
	}

	/*private static String getClassDeclarationString(ClassDescription description) {

	}

	public static String serialize(ClassDescription description) {

	}*/
}
