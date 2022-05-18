package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class HomePage extends BaseClass {

	private By oWelcome = By.xpath("//h3[contains(text(),'Welcome!')]");
	private By oLogout = By.xpath("//a[text()='Logout']");
	private By oApplyForNewAccount = By.xpath("//div[@class='btn btn-white card-header-item']");

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage validateWelcomeMsg() {
		if (driver.findElement(oWelcome).isDisplayed() && driver.findElement(oLogout).isDisplayed()) {
			System.out.println("User is in Home Page");
		} else {
			System.out.println("User Not in Home Page");
		}
		return this;
	}

	public LoginPage clickOnLogOut() {
		driver.findElement(oLogout).click();
		return new LoginPage(driver);
	}

}
