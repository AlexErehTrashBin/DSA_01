package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.*;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.ConstantUtils;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.MethodUtils;

public class Main {
	public static void main(String[] args) {
		Method method1 = new Method();
		method1.setName("solution");
		method1.setReturnType("int[][]");
		method1.setAccessLevel(new AccessLevel("public"));
		method1.setStatic(true);
		method1.addParameter(new Parameter("int[][]", "inputMatrix"));

		Method method2 = new Method();
		method2.setName("isRowCorrect");
		method2.setReturnType("boolean");
		method2.setAccessLevel(new AccessLevel("private"));
		method2.setStatic(true);
		method2.addParameter(new Parameter("int[][]", "matrix"));
		method2.addParameter(new Parameter("int", "row"));

		MethodUtils.writeAllInfoAboutMethods(method1, method2);

		Constant constant1 = new Constant();
		constant1.setType("int");
		constant1.setName("CHECK_THRESHOLD");
		constant1.setValue("5");

		ConstantUtils.writeAllInfoAboutConstants(constant1);

		InterfaceClass interfaceClass1 = new InterfaceClass("SomeInterface");
		interfaceClass1.addConstants(constant1);
		interfaceClass1.addMethods(method1, method2);

		System.out.println("\n\n\n");

		System.out.println(interfaceClass1);
	}
}