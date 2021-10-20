package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNgListeners.class)
public class TestNGListenersDemo {
	
	@Test
	public void test1() {
		System.out.println("I am inside test1");
	}
	@Test
	public void test2() {
		System.out.println("I am inside test2");
		Assert.assertTrue(false);
	}
	@Test
	public void test3() {
		System.out.println("I am inside test3");
		throw new SkipException("this test is skipped");
	}
	@Test
	public void test4() {
		System.out.println("I am inside test4");
	}
	@Test
	public void test5() {
		System.out.println("I am inside test5");
	}
}
