import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cvs {

	public static void FindStates() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cvs.com/minuteclinic/?icid=CVS-HOME-PWRZN-MINUTECLINIC");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='button-active']")).click();
		List<WebElement> stateList = driver.findElements(By.xpath("//form[@class='ng-valid ng-dirty ng-touched']//select[@id='state-label']//option)"));
		// get the size:
		int numberOfStates = stateList.size();
		System.out.println(numberOfStates);

		// get the text of array list
		int i = 0;
		for (i = 0; i < numberOfStates; i++) {

			String states = stateList.get(i).getText();
			System.out.println(states);

		}
	}

	public static void main(String[] args) throws Exception {

		FindStates();

	}
}
