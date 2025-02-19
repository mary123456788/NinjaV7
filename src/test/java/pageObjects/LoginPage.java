package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


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

	public void setEmail(String email) {
		txt_Email.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txt_Pwd.sendKeys(pwd);
	}

	public void clickLogin() {
		btn_Login.click();
	}

}
