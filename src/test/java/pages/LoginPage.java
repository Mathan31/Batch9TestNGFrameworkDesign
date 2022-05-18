package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Register For Account']");
	private By oRegisterLink = By.xpath("//*[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean validateAllTheElementsInLoginPage() {
		if(driver.findElement(oUsernameText).isDisplayed() && driver.findElement(oPasswordText).isDisplayed()
			&& driver.findElement(oSignInBtn).isDisplayed()	&& driver.findElement(oRegisterLink).isDisplayed()) {
			return true;
		}else {
			return false;
		} 
	}
	
	public LoginPage enterUserName(String uName) {
		driver.findElement(oUsernameText).sendKeys(uName);
		return this;
	}
	
	public LoginPage enterPassword(String sPassword) {
		driver.findElement(oPasswordText).sendKeys(sPassword);
		return this;
	}
	
	public HomePage clickOnSignInButton() {
		driver.findElement(oSignInBtn).click();
		return new HomePage(driver);
	}
	
	public LoginPage clickOnSignInButtonwithInvalidDetails() {
		driver.findElement(oSignInBtn).click();
		return this;
	}
	
	public boolean validateFailureMsg() {
		if(driver.findElement(oLoginFailedInnerText).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public RegistrationPage clickOnRegistrationLink() {
		driver.findElement(oRegisterLink).click();
		return new RegistrationPage(driver);
	}
	
	
	

}
