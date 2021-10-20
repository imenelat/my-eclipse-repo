package demo;

import org.testng.annotations.Test;

@Test(groups= {"AllClassTests"})
public class TestNGGroupsDemo {

	@Test(groups= {"sanity"})
	public void test1() {
		System.out.println("this is tes 1 ");
	}
	
	@Test(groups= {"windows.smoke"})
	public void test2() {
		System.out.println("this is tes 2 ");
	}
	
	@Test(groups= {"sanity","regression"})
	public void test3() {
		System.out.println("this is tes 3 ");
	}
	
	@Test(groups= {"linux.smoke"})
	public void test4() {
		System.out.println("this is tes 4 ");
	}
}
