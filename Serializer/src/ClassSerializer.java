package ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.serializer;

import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Field;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Method;

import java.util.ArrayList;

public class ClassSerializer {
	public static String serialize(ClassDescription c){
		StringBuilder sb = new StringBuilder();
		sb.append("CLASS//");
		sb.append(c.getAccessLevel().getSerial());
		sb.append("//");
		sb.append(c.isStatic() ? "S" : "X");
		sb.append("//");
		sb.append(c.getName());
		sb.append("//");
		sb.append(new ArrayList<>(c.getParentInterfacesNames()));
		sb.append("//");
		sb.append(new ArrayList<>(c.getParentClassesNames()));
		sb.append('\n');
		for (Field field : c.getFields()) {
			appendField(sb, field);
		}
		for (Method method : c.getMethods()) {
			appendMethod(sb, method);
		}
		return sb.toString();
	}
	public static void appendField(StringBuilder sb, Field field){
		sb.append("FIELD//");
		sb.append(field.getAccessLevel().getSerial());
		sb.append("//");
		sb.append(field.isStatic() ? "S" : "X");
		sb.append("//");
		sb.append(field.isFinal() ? "F" : "X");
		sb.append("//");
		sb.append(field.getType());
		sb.append("//");
		sb.append(field.getName());
		sb.append("//");
		String initialValue = field.getInitialValue();
		sb.append(initialValue == null ? "4" : initialValue.length());
		sb.append("//");
		sb.append(initialValue);
		sb.append('\n');
	}

	public static void appendMethod(StringBuilder sb, Method method){
		sb.append("METHOD//");
		sb.append(method.getAccessLevel().getSerial());
		sb.append("//");
		sb.append(method.isStatic() ? "S" : "X");
		sb.append("//");
		sb.append(method.isFinal() ? "F" : "X");
		sb.append("//");
		sb.append(method.getType());
		sb.append("//");
		sb.append(method.getName());
		sb.append("//");
		String body = method.getBody();
		sb.append(body == null ? "4" : body.length());
		sb.append("//");
		sb.append(body);
		sb.append('\n');
	}
}
