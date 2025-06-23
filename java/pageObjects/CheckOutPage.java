package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

	// constructor
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);

	}

	// Locators
	@FindBy(xpath = "//input[@value='new']")
	WebElement Billing_IWantToUseANewAddress;

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	WebElement Billing_FirstName;

	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	WebElement Billing_LastName;

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	WebElement Billing_Address1;

	@FindBy(xpath = "//input[@id='input-payment-city']")
	WebElement Billing_City;

	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	WebElement Billing_PostCode;

	@FindBy(xpath = "//select[@id='input-payment-country']")
	private WebElement Billing_Country;

	@FindBy(xpath = "//select[@id='input-payment-zone']")
	private WebElement Billing_RegionState;

	public void CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='button-payment-address']")
	WebElement Billing_Continue;

	@FindBy(xpath = "//label[normalize-space()='I want to use a new address']//input[@name='shipping_address']")
	WebElement Delivery_IWantToUseANewAddress;

	@FindBy(xpath = "//input[@id='input-shipping-firstname']")
	WebElement Delivery_FirstName;

	@FindBy(xpath = "//input[@id='input-shipping-lastname']")
	WebElement Delivery_LastName;

	@FindBy(xpath = "//input[@id='input-shipping-address-1']")
	WebElement Delivery_Address1;

	@FindBy(xpath = "//input[@id='input-shipping-city']")
	WebElement Delivery_City;

	@FindBy(xpath = "//input[@id='input-shipping-postcode']")
	WebElement Delivery_PostCode;

	@FindBy(xpath = "//select[@id='input-shipping-country']")
	private WebElement Delivery_Country;

	@FindBy(xpath = "//select[@id='input-shipping-zone']")
	private WebElement Delivery_RegionState;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	WebElement Delivery_Continue;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement DeliveryMethod_Continue;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement Payment_Agree;

	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement PM_Continue;

	@FindBy(xpath = "//input[@id='button-confirm']")
	WebElement ConfirmOrder;

	@FindBy(xpath = "//h1[normalize-space()='Your order has been placed!']")
	WebElement message_CompletePurchase;

	// Action Methods
	public void Billing_IWantToUseANewAddress() {
		Billing_IWantToUseANewAddress.click();
	}

	public void Billing_FirstName(String fn) {
		Billing_FirstName.sendKeys(fn);
	}

	public void Billing_LastName(String ln) {
		Billing_LastName.sendKeys(ln);
	}

	public void Billing_Address1(String add1) {
		Billing_Address1.sendKeys(add1);
	}

	public void Billing_City(String city) {
		Billing_City.sendKeys(city);
	}

	public void Billing_PostCode(String pc) {
		Billing_PostCode.sendKeys(pc);
	}

	public void Billing_Country(String countryName) {
		Select dropdown = new Select(Billing_Country);
		dropdown.selectByVisibleText(countryName);
	}

	public void Billing_RegionState(String RegionStateName) {
		Select dropdown = new Select(Billing_RegionState);
		dropdown.selectByVisibleText(RegionStateName);
	}

	public void Billing_Continue() {
		Billing_Continue.click();
	}

	public void Delivery_IWantToUseANewAddress() {
		Delivery_IWantToUseANewAddress.click();
	}

	public void Delivery_FirstName(String fn) {
		Delivery_FirstName.sendKeys(fn);
	}

	public void Delivery_LastName(String ln) {
		Delivery_LastName.sendKeys(ln);
	}

	public void Delivery_Address1(String add1) {
		Delivery_Address1.sendKeys(add1);
	}

	public void Delivery_City(String city) {
		Delivery_City.sendKeys(city);
	}

	public void Delivery_PostCode(String pc) {
		Delivery_PostCode.sendKeys(pc);
	}

	public void Delivery_Country(String countryName) {
		Select dropdown = new Select(Delivery_Country);
		dropdown.selectByVisibleText(countryName);
	}

	public void Delivery_RegionState(String RegionStateName) {
		Select dropdown = new Select(Delivery_RegionState);
		dropdown.selectByVisibleText(RegionStateName);
	}

	public void Delivery_Continue() {
		Delivery_Continue.click();
	}

	public void DeliveryMethod_Continue() {
		DeliveryMethod_Continue.click();
	}

	public void Payment_Agree() {
		Payment_Agree.click();
	}

	public void PM_Continue() {
		PM_Continue.click();
	}

	public void ConfirmOrder() {
		ConfirmOrder.click();
	}

	public String message_CompletePurchase() {
		return message_CompletePurchase.getText();
	}

}
