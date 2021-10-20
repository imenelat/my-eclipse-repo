package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class googleSearchPageObject {

	WebDriver driver=null;
	By textboxSearch=By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[1]/div/div[2]/input");
	By buttonSearch=By.name("btnK");
	
	public googleSearchPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public void setTextInSearchBox(String text) {
		driver.findElement(textboxSearch).sendKeys(text);
	}
	public void clickSearchButton() {
		//driver.findElement(textboxSearch).sendKeys(Keys.ENTER);
		driver.findElement(buttonSearch).sendKeys(Keys.RETURN);	
		//driver.findElement(buttonSearch).click();	
	}
}