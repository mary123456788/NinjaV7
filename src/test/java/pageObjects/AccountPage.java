package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement confirmationText_MyAccount;

	@FindBy(xpath = "//span[@class='caret']")
	WebElement dropDown_MyAccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
	WebElement link_Logout;

	public WebElement getMyAccountConfirmation() {
		return confirmationText_MyAccount;

	}

	public void clickMyAccountDropDown() {
		dropDown_MyAccount.click();
	}

//	public void clickLogout() {
//		link_Logout.click();
//	}
	
	public void clickLogout() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	    wait.until(ExpectedConditions.visibilityOf(link_Logout));
	    link_Logout.click();
	}
	
	
//	public void clickLogout() {
//		waitForClickable(link_Logout).click();
//	}


}
