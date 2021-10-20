package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNgListeners.class)
public class TestNGListenersDemo2 {
	
	@Test(priority= 2)
	public void test6() {
		System.out.println("I am inside test6");
	}
	@Test(priority= 2)
	public void test7(){
		System.out.println("I am inside test7");
		Assert.assertTrue(false);
	}
	@Test(priority= 1)
	public void test8() {
		System.out.println("I am inside test8");
		throw new SkipException("this test is skipped");
	}
	@Test
	public void test9() {
		System.out.println("I am inside test9");
	}

}
