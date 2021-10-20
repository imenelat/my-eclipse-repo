package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGIgnoreDemo {
	
	@Ignore
	@Test(dependsOnMethods= {"test2","test3"})
	public void test1 () {
		System.out.println("this is test 1 ");
	}

	@Test(dependsOnGroups= {"sanity1.*"})
	public void test2() {
		System.out.println("this is test 2 ");
	}

	@Test(groups= {"sanity2"})
	public void test3() {
		System.out.println("this is test 3 ");
	}

	@Test(groups= {"sanity1"})
	public void test4() {
		System.out.println("this is test 4 ");
	}
}