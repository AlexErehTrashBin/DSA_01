import org.junit.Test;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.AccessLevel;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Method;
import ru.vsu.cs.aisd2023.g112.ereshkin_a_v.task01.model.Parameter;

public class MethodTests {
	@Test
	public void test1(){
		Method method1 = new Method("someMethod","String",
				new AccessLevel(""),
				false);
		Parameter parameter1 = new Parameter("int", "age");
		Parameter parameter2 = new Parameter("TestClass", "testClass");
		method1.addParameter(parameter1);
		method1.addParameter(parameter2);
		System.out.println(method1);
		method1.setStatic(true);
		System.out.println(method1);
		method1.setAccessLevel(new AccessLevel("public"));
		System.out.println(method1);
	}
}
