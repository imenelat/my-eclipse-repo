package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParametersDemo {

	@Test
	@Parameters({"MyName"})
	public void test(String name) {
	//public void test(@Optional ("Imene") String name) {
		System.out.println("name is : "+ name);
	}
}
