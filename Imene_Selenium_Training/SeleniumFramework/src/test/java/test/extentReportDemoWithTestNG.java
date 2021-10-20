package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentReportDemoWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	private static WebDriver driver=null;
	
@BeforeSuite
	public void setUp() {
	htmlReporter = new ExtentHtmlReporter("extent.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
}
@BeforeTest
public void setUpTest() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
@Test	
	public void test1() throws Exception {
	  ExtentTest test = extent.createTest("googlePage", "Sample description");
	  driver.get("https://www.google.com/");
		test.pass("navigated to google.com");
      test.log(Status.INFO, "This step shows usage of log(status, details)");
      test.info("This step shows usage of info(details)");
      test.addScreenCaptureFromPath("screenshot.png");
 	}
@Test	
public void test2() throws Exception {
  ExtentTest test2 = extent.createTest("emptytest", "Sample description");
  test2.log(Status.INFO, "This step shows usage of log(status, details)");
  test2.info("This step shows usage of info(details)");
  test2.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
  test2.addScreenCaptureFromPath("screenshot.png");
	}

@AfterTest
public void tearDownTest() {
driver.close();
driver.quit();
System.out.println("test completed successfully");
}

@AfterSuite	
	public void tearDown() {
	extent.flush();
	}
}
