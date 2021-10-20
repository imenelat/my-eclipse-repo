import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {

	public static void main(String[] args) {

		googleSearch();

	}
	public static void googleSearch(){

		String projectPath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",projectPath+"\\drivers\\chromeDriver\\chromedriver.exe");

		//System.setProperty("webdriver.chrome.driver","C:\\Users\\mabde\\Imene_Selenium_Training\\SeleniumFramework\\drivers\\chromeDriver\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		//go on google.com
		driver.get("https://www.google.com/");
		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("let's start");
		//click search button
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		//close browser
		driver.close();
		driver.quit();
		System.out.println("test completed succesfully");
	}




}

