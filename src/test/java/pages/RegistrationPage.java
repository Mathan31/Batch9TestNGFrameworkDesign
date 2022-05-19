package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import library.SeleniumWrapper;

public class RegistrationPage extends BaseClass{
	
	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName");
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");
	private By oEmploymentStatus = By.id("employmentStatus");
	private By oAge = By.id("age");
	private By oMartialStatus = By.id("maritalStatus");
	private By oNumberOfDependents = By.id("numberOfDependents");
	private WebDriver driver;
	private ExtentTest node;
	private SeleniumWrapper wrap;

	public RegistrationPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		wrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean verifyAllTheFields() {
		if(wrap.verifyDisplayedwithReturn(driver.findElement(oUserName)) && wrap.verifyDisplayedwithReturn(driver.findElement(oPassword))
				&& wrap.verifyDisplayedwithReturn(driver.findElement(oEmail))&& wrap.verifyDisplayedwithReturn(driver.findElement(oRegister))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public RegistrationPage enterFirstName(String firstName) {
		wrap.type(driver.findElement(oFirstName),firstName);
		return this;
	}
	
	public RegistrationPage selectTitle(String title) {
		wrap.selectDropDownUsingVisibleText(driver.findElement(oTitle), title);
		return this;
	}
	
	public RegistrationPage selectGender(String gender) {
		wrap.selectDropDownUsingVisibleText(driver.findElement(oGender), gender);
		return this;
	}
	
	public RegistrationPage enterUserName(String userName) {
		wrap.type(driver.findElement(oUserName),userName);
		return this;
	}
	
	public RegistrationPage enterEmailAddress(String email) {
		wrap.type(driver.findElement(oEmail),email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) {
		wrap.type(driver.findElement(oPassword),password);
		return this;
	}
	
	public EmailVerificationPage clickRegisterButton() {
		wrap.click(driver.findElement(oRegister));
		return new EmailVerificationPage(driver,node);
		}
	
	public LoginPage clickOnUILogo() {
		wrap.click(driver.findElement(oUILogo));
		return new LoginPage(driver,node);
	}
}
