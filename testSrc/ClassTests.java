import org.junit.Test;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.ClassDescription;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Field;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Method;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Parameter;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.utils.ClassUtils;

public class ClassTests {
	@Test
	public void testBodyTabulations(){
		ClassDescription classDescription = new ClassDescription("SampleClass");
		Method method = new Method("bruh", "void");
		method.setStatic(true);
		method.addParameter(new Parameter("String", "someText"));
		method.setBody("call1();\ncall2();");
		classDescription.addMethods(method);
		System.out.println(classDescription);
		method.setBody("");
		System.out.println(classDescription);
		classDescription.clearMethods();
		classDescription.clearFields();
		System.out.println(classDescription);
	}
	@Test
	public void testExtendsImplements(){
		ClassDescription description = new ClassDescription("SampleClass");
		description.addMethods(new Method("testMethodName", "String"));
		ClassUtils.writeAllInfoAboutClasses(description);
		//description.addImplements();
		//description.addExtends();
	}
	@Test
	public void baseTests(){
		ClassDescription classDescription = new ClassDescription("TestClass");

		Field field1 = new Field("int", "field1");
		Field field2 = new Field("int", "field2");
		Field field3 = new Field("int", "field3");
		Field field4 = new Field("int", "field4");

		classDescription.addFields(field1, field2, field3, field4);

		Method method1 = new Method("method1", "void");
		Method method2 = new Method("method2", "void");
		Method method3 = new Method("method3", "void");

		classDescription.addMethods(method1, method2, method3);

		ClassUtils.writeAllInfoAboutClasses(classDescription);
	}
}
