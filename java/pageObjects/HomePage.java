package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	// constructor
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//a[normalize-space()='Qafox.com']")
	WebElement content_HomePage;

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement link_MyAccount;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement link_Login;

	@FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
	WebElement LaptopsAndNotebooks;

	@FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']")
	WebElement ShowAll_LaptopsAndNotebooks;

	@FindBy(xpath = "//a[normalize-space()='HP LP3065']")
	WebElement Select_HPLP3065;

	@FindBy(xpath = "//a[normalize-space()='Gift Certificates']")
	WebElement Select_GiftCertificate;

	// Action Methods
	public String confirmHomepage() {
		return content_HomePage.getText();
	}

//	public void clickMyAccount() {
//		link_MyAccount.click();
//	}

	public void clickMyAccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(link_MyAccount));
		waitForClickable(link_MyAccount).click();
	}

//	public void goToLogin() {
//		link_Login.click();
//	}
//	
	public void goToLogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(link_Login));
		link_Login.click();
	}

//	public void LaptopsAndNotebooks() {
//		LaptopsAndNotebooks.click();
//	}

	public void LaptopsAndNotebooks() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(LaptopsAndNotebooks));
		waitForClickable(LaptopsAndNotebooks).click();
	}

	public void ShowAll_LaptopsAndNotebooks() {
		ShowAll_LaptopsAndNotebooks.click();
	}

	public void Select_HPLP3065() {
		Select_HPLP3065.click();
	}

	public void Select_GiftCertificate() {
		Select_GiftCertificate.click();
	}

}
