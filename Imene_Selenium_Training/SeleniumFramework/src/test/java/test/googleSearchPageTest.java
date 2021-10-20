package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.googleSearchPageObject;

public class googleSearchPageTest {

	private static WebDriver driver=null;
	
	/*public static void main(String[] args) {
		googleSearchTest();
	}*/
	@Test
	public void googleSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		googleSearchPageObject SearchPageObj=new googleSearchPageObject(driver);
		
		driver.get("https://www.google.com/");
		SearchPageObj.setTextInSearchBox("abcd");
		System.out.println("abcd done");
		SearchPageObj.clickSearchButton();
		System.out.println("clicked");
		driver.close();
		driver.quit();
		System.out.println("Good");
	}
}
