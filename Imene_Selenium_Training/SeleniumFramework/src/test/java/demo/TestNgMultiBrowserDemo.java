package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgMultiBrowserDemo {

	WebDriver driver=null;

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("browser name is : "+browserName);
		System.out.println("Thread ID is: "+Thread.currentThread());

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
	}


	@Test
	public void test1() throws Exception {
		driver.get("https://www.google.com/");
		Thread.sleep(4000);
	}

	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("test completed successfully");
	}

}
