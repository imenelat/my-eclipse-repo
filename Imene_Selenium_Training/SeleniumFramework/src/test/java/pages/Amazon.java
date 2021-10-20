package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	

	
	public static void main(String[] args) {
		
		
		AmazonAccounts();
 
	}
	
	
	public static void AmazonAccounts() {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions actions = new Actions(driver);
		WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		actions.moveToElement(account).build().perform();
		driver.findElement(By.xpath("//*[@id=\'nav-al-your-account\']/a[1]/span")).click();
		
	}

	


}
