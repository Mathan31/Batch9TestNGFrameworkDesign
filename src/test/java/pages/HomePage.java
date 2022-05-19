package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.SeleniumWrapper;

public class HomePage extends BaseClass {

	private By oWelcome = By.xpath("//h3[contains(text(),'Welcome!')]");
	private By oLogout = By.xpath("//a[text()='Logout']");
	private By oApplyForNewAccount = By.xpath("//div[@class='btn btn-white card-header-item']");

	private WebDriver driver;
	private ExtentTest node;
	private SeleniumWrapper wrap;
	public HomePage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		wrap = new SeleniumWrapper(driver, node);
	}

	public HomePage validateWelcomeMsg() {
		if(wrap.verifyDisplayedwithReturn(driver.findElement(oWelcome)) && wrap.verifyDisplayedwithReturn(driver.findElement(oLogout))) {
			System.out.println("User Landed to the Home Page!!!");
			return this;
		}else {
			System.out.println("User not in Home Page.");
			return this;
		}
	}

	public LoginPage clickOnLogOut() {
		wrap.click(driver.findElement(oLogout));
		return new LoginPage(driver,node);
	}

}
