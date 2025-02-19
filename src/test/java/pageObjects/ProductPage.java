package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

	// constructor
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//div[@class='caption']//a[contains(text(),'HP LP3065')]")
	WebElement Select_HPLP3065;

	@FindBy(xpath = "//input[@id='input-option225']")
	public WebElement setDeliveryDate;

	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement AddToCart_Btn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement message_AddToCart;

	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']")
	WebElement AddToWishList_Btn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement message_AddToWishList;
	
	@FindBy(xpath = "//span[@id='cart-total']")
	WebElement ItemsInCart;

	@FindBy(xpath = "//strong[normalize-space()='Checkout']")
	WebElement Checkout;

	// Action Methods
	public void Select_HPLP3065() {
		Select_HPLP3065.click();
	}

	public void AddToCart_Btn() {
		AddToCart_Btn.click();
	}

	public String message_AddToCart() {
		return message_AddToCart.getText();
	}

	public void AddToWishList_Btn() {
		AddToWishList_Btn.click();
	}

	public String message_AddToWishList() {
		return message_AddToWishList.getText();
	}
	public void ItemsInCart() {
		ItemsInCart.click();
	}
	public void Checkout() {
		Checkout.click();
	}

}
