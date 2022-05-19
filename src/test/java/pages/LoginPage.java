package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.SeleniumWrapper;

public class LoginPage extends BaseClass{
	
	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Register For Account']");
	private By oRegisterLink = By.xpath("//*[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private WebDriver driver;
	private ExtentTest node;
	private SeleniumWrapper wrap;
	
	public LoginPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		wrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean validateAllTheElementsInLoginPage() {
		if( wrap.verifyDisplayedwithReturn(driver.findElement(oUsernameText)) && wrap.verifyDisplayedwithReturn(driver.findElement(oPasswordText))
			&& wrap.verifyDisplayedwithReturn(driver.findElement(oSignInBtn))	&& wrap.verifyDisplayedwithReturn(driver.findElement(oRegisterLink))) {
			return true;
		}else {
			return false;
		} 
	}
	
	public LoginPage enterUserName(String uName) {
		wrap.type(driver.findElement(oUsernameText), uName);
		return this;
	}
	
	public LoginPage enterPassword(String sPassword) {
		wrap.type(driver.findElement(oPasswordText), sPassword);
		return this;
	}
	
	public HomePage clickOnSignInButton() {
		wrap.click(driver.findElement(oSignInBtn));
		return new HomePage(driver,node);
	}
	
	public LoginPage clickOnSignInButtonwithInvalidDetails() {
		wrap.click(driver.findElement(oSignInBtn));
		return this;
	}
	
	public boolean validateFailureMsg() {
		
		if(wrap.verifyDisplayedwithReturn(driver.findElement(oLoginFailedInnerText))) {
			return true;
		}else {
			return false;
		}
	}
	
	public RegistrationPage clickOnRegistrationLink() {
		wrap.click(driver.findElement(oRegisterLink));
		return new RegistrationPage(driver,node);
	}
	
	
	

}
