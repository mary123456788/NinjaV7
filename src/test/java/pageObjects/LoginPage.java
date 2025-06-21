package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	// constructor
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locators

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_Email;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_Pwd;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_Login;

	// Action methods

//	public void setEmail(String email) {
//		txt_Email.sendKeys(email);
//	}
//
//	public void setPassword(String pwd) {
//		txt_Pwd.sendKeys(pwd);
//	}
////
//	public void clickLogin() {
//		btn_Login.click();
//	}

	// Action methods with waits
//	public void setEmail(String email) {
//		waitForVisibility(txt_Email).sendKeys(email);
//	}
//
//	public void setPassword(String pwd) {
//		waitForVisibility(txt_Pwd).sendKeys(pwd);
//	}

	
	public void setEmail(String email) {
		WebElement emailField = waitForVisibility(txt_Email);
		emailField.clear();
		emailField.sendKeys(email);
	}

	public void setPassword(String pwd) {
		WebElement pwdField = waitForVisibility(txt_Pwd);
		pwdField.clear();
		pwdField.sendKeys(pwd);
	}

//	public void clickLogin() {
//		waitForClickable(btn_Login).click();
//	}

	public void clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(btn_Login));
		btn_Login.click();
	}
}
