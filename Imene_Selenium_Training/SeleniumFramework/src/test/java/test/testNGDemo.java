package test;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testNGDemo {
	WebDriver driver=null;
	String text="abcd";
	By textboxSearch=By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input");
	By buttonSearch=By.name("btnK");

	@BeforeTest
	public void setUpTest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	@Test
	public void googleSearch() {
		driver.get("https://www.google.com/");
		driver.findElement(textboxSearch).sendKeys(text);
		driver.findElement(textboxSearch).sendKeys(Keys.ENTER);

	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
