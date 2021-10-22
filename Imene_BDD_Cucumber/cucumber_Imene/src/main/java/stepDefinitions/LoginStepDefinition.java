package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class LoginStepDefinition {
	WebDriver driver = null;

	@Given("^User is already on Login Page$")
	public void user_already_on_login_page() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://freecrm.com/");
		Thread.sleep(2000);

	}

	@When("^Title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM() throws Throwable {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM customer relationship management software cloud", title);

	}

	/*
	 * @Then("^User enters username and password$") public void
	 * user_enters_username_and_password() throws Throwable {
	 * driver.findElement(By.xpath("//span [contains (text(), 'Log In')]")).click();
	 * driver.findElement(By.name("email")).sendKeys("imene.manlat@gmail.com");
	 * driver.findElement(By.name("password")).sendKeys("Corporatio10");
	 * 
	 * }
	 */

	
	@Then("^User enters \"([^\"]*)\" and \"([^\"]*)\"$") // Regular expression : \"(.*)\ or \"([^\"]*\"
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//span [contains (text(), 'Log In')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);

	}

	@Then("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
		
		WebElement loginBtn = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
		Thread.sleep(3000);
	}

	@Then("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		String title2 = driver.getTitle();
		System.out.println(title2);
		Assert.assertEquals("Cogmento CRM", title2);
	}

	@Then("^User moves to new contact page$")
	public void user_moves_to_new_contact_page() throws Throwable {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[@class='item' and@href='/home']"))).build().perform();
		driver.findElement(By.xpath("//a[@class='item' and @href='/contacts']//following-sibling::button[@class='ui mini basic icon button']")).click();
		Thread.sleep(2000);
	}

	@Then("^user enters contact details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and_and(String firstname, String lastname, String position) throws Throwable {
		driver.findElement(By.name("first_name")).sendKeys(firstname);
		Thread.sleep(2000);
		driver.findElement(By.name("last_name")).sendKeys(lastname);
		driver.findElement(By.name("position")).sendKeys(position);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//i[@class='save icon']")).click();
	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}

}
