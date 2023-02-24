package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.tests;

import org.junit.Test;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Field;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.FieldUtils;

public class FieldTests {
	@Test
	public void baseFieldTest(){
		Field field1 = new Field("SomeClass", "someClass", "new SomeClass()");
		field1.setAccessLevel(AccessLevel.PROTECTED);
		field1.setStatic(true);
		field1.setFinal(true);

		Field field2 = new Field("int", "counter");

		FieldUtils.writeAllInfoAboutFields(field1, field2);
	}
}
