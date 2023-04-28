package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.tests;

import org.junit.Test;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Method;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Parameter;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.utils.MethodUtils;

public class MethodTests {
	@Test
	public void test1() {
		Method method1 = new Method("someMethod", "String",
				AccessLevel.PUBLIC,
				false, false);
		Parameter parameter1 = new Parameter("int", "age");
		Parameter parameter2 = new Parameter("TestClass", "testClass");
		method1.addParameter(parameter1);
		method1.addParameter(parameter2);
		System.out.println(method1);
		method1.setStatic(true);
		System.out.println(method1);
		method1.setAccessLevel(AccessLevel.PUBLIC);
		System.out.println(method1);
		method1.setBody("someCall();");
		method1.setType("void");
		System.out.println(method1);
	}

	@Test
	public void test2() {
		Method method = new Method("bruhMethod", "void");
		method.setBody(
				"call1();\ncall2();\ncall3();"
		);
		method.setFinal(true);
		MethodUtils.writeAllInfoAboutMethods(method);
	}
}
