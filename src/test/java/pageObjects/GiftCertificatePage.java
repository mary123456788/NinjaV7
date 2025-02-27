package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCertificatePage extends BasePage {
	// constructor
	WebDriver driver;

	public GiftCertificatePage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//input[@id='input-to-name']")
	WebElement Recipients_Name;

	@FindBy(xpath = "//input[@id='input-to-email']")
	WebElement Recipients_Email;

	@FindBy(xpath = "//input[@id='input-from-name']")
	WebElement Your_Name;

	@FindBy(xpath = "//input[@id='input-from-email']")
	WebElement Your_Email;

	@FindBy(xpath = "//input[@value='7']")
	WebElement GC_Birthday;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement Agree;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Continue;
	
	@FindBy(xpath = "//p[contains(text(),'Thank you for purchasing a gift certificate! Once ')]")
	WebElement message_PurchaseGiftCertificate;

	// Action Methods
	public void Recipients_Name(String rn) {
		Recipients_Name.sendKeys(rn);
	}

	public void Recipients_Email(String rn) {
		Recipients_Email.sendKeys(rn);
	}

	public void Your_Name(String rn) {
		Your_Name.sendKeys(rn);
	}

	public void Your_Email(String rn) {
		Your_Email.sendKeys(rn);
	}

	public void GC_Birthday() {
		GC_Birthday.click();
	}

	public void Agree() {
		Agree.click();
	}

	public void Continue() {
		Continue.click();
	}
	
	public String message_PurchaseGiftCertificate() {
		return message_PurchaseGiftCertificate.getText();
	}

	
}
