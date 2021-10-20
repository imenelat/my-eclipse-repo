package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void browserSearch() throws InterruptedException {

		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		//driver.findElement(By.className("LC20lb DKV0Md")).click();
		//driver.findElement(By.partialLinkText("ABCD Study")).click();
	

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement linkElement= driver.findElement(By.partialLinkText("ABCD Pediatrics"));
				if(linkElement.isEnabled()) {
					System.out.println("element found");
				}
				return linkElement;
			}
		});
		element.click();
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
}
