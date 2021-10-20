package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;


public class extentReportsDemo {
	private static WebDriver driver=null;
	
	
	
	public static void main(String[] args) {
		// start reporters
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM.dd HH.mm.ss");  
		LocalDateTime now = LocalDateTime.now();
		String fileName = "test1"+" " + dtf.format(now)+".html";
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test1 = extent.createTest("GoogleSearch Test One", "This is a test to validate googleSearch functionality");

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		// log(Status, details)
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com/");
		test1.pass("navigated to google.com");

		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in search box");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.name("btnK")).click();
		
		test1.pass("pressed keyboard enterkey");

		driver.close();
		driver.quit();
		test1.pass("closed the browser");

		test1.info("test completed");

		// calling flush writes everything to the log file
		extent.flush();

	}
}