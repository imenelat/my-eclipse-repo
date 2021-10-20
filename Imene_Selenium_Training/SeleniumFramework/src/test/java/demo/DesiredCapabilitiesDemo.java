package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilitiesDemo {
	private static WebDriver driver=null;
	
	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.iedriver().setup();
		WebDriverManager.chromedriver().setup();
		//DesiredCapabilities caps=new DesiredCapabilities();
		//caps.setCapability("ignoreZoomSetting", true);
		//driver=new InternetExplorerDriver();
		driver=new ChromeDriver();
		driver.get("https://google.com");
		System.out.println("opened google");
		Thread.sleep(2000);
		System.out.println("opened google");
		driver.findElement(By.name("q")).sendKeys("automation");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();
		}
	

}
