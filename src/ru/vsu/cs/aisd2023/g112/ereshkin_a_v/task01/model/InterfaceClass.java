package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Реализация класса интерфейса.
 * Делалось в основном по <a href="https://docs.oracle.com/javase/specs/jls/se17/html/jls-9.html">этой</a> документации
 * */
public class InterfaceClass {
	/**
	 * Название интерфейса
	 **/
	private String name;
	/**
	 * Статические константы интерфейса
	 **/
	private final List<Constant> constants;
	/**
	 * Методы интерфейса
	 **/
	private final List<Method> methods;
	/**
	 * Названия интерфейсов, от которых наследуется текущий интерфейс
	 * (неясно, сильно ли требуется заморачиваться над хранением информации о действительных интерфейсах,
	 * которые находятся в каких-то реальных пакетах и т.п., либо же хватит их названий)
	 **/
	private List<String> parentInterfacesNames;

	public InterfaceClass(String name) {
		this.name = name;
		constants = new ArrayList<>();
		methods = new ArrayList<>();
	}

	public InterfaceClass() {
		constants = new ArrayList<>();
		methods = new ArrayList<>();
	}

	public void addMethods(Method... methods) {
		// Аналогично циклу, который перебирает по methods и добавляет каждый перебираемый в methods.
		// P.S. methods - varargs (аналогично массиву). Сделано для упрощения вызова функции.
		Collections.addAll(this.methods, methods);
	}
	public void addConstants(Constant... constants) {
		// Аналогично циклу, который перебирает по methods и добавляет каждый перебираемый в methods.
		// P.S. methods - varargs (аналогично массиву). Сделано для упрощения вызова функции.
		Collections.addAll(this.constants, constants);
	}
	public void setName(String newName){
		name = newName;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("interface ").append(name).append(" {").append("\n");
		for (Constant constant : constants) {
			String constantString = constant.toString();
			sb.append(Objects.equals(constantString, "") ? "" : "\t" + constantString + "\n");
		}
		if (!constants.isEmpty() && !methods.isEmpty()) sb.append("\n");
		for (Method method : methods) {
			String methodString = method.toString();
			sb.append(Objects.equals(methodString, "") ? "" : "\t" + methodString + "\n");
		}
		sb.append("}");
		return sb.toString();
	}
}
