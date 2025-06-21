package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//public class BasePage {
//	
//
//	// constructor
//	WebDriver driver;
//	BasePage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//	}
//
//}

public class BasePage {

	protected WebDriver driver;
	private WebDriverWait wait;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Wait for visibility
	protected WebElement waitForVisibility(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for element to be clickable
	protected WebElement waitForClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for element to be invisible
	protected boolean waitForInvisibility(WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}

	// Optional: wait for presence by locator if you use By objects
	
	 protected WebElement waitForPresence(By locator) { return
	 wait.until(ExpectedConditions.presenceOfElementLocated(locator)); }
	
}
