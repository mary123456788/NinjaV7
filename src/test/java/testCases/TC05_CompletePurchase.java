package testCases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.RetryAnalyzer;

public class TC05_CompletePurchase extends BaseClass {

	private static final Logger logger = LogManager.getLogger(TC05_CompletePurchase.class);

	@Test(groups = { "smoke", "regression" }, retryAnalyzer = RetryAnalyzer.class)
	void testCompletePurchase() throws InterruptedException {
		logger.debug("Test execution started.");

		HomePage hp = new HomePage(getDriver());
		try {
			Thread.sleep(3000);
			logger.info("Navigating to Laptops and Notebooks section.");
			hp.LaptopsAndNotebooks();
			Thread.sleep(3000);
			hp.ShowAll_LaptopsAndNotebooks();
			Thread.sleep(3000);

			ProductPage pp = new ProductPage(getDriver());
			pp.Select_HPLP3065();
			Thread.sleep(2000);

			pp.setDeliveryDate.clear();
			LocalDate today = LocalDate.now(); // Today's date
			LocalDate deliveryDate = today.plusDays(7); // Add 7 days to today's date
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedDeliveryDate = deliveryDate.format(formatter);

			logger.info("Setting the delivery date: " + formattedDeliveryDate);
			pp.setDeliveryDate.sendKeys(formattedDeliveryDate);
			pp.AddToCart_Btn();

			pp.ItemsInCart();
			pp.Checkout();
			Thread.sleep(10000);

			LoginPage lp = new LoginPage(getDriver());
			lp.setEmail("ma12345678@gmail.com");
			lp.setPassword("L0ve$elenium");
			lp.clickLogin();
			Thread.sleep(10000);

			CheckOutPage chp = new CheckOutPage(getDriver());
			chp.Billing_IWantToUseANewAddress();
			Thread.sleep(10000);

			// Billing Details
			chp.Billing_FirstName("Mary");
			chp.Billing_LastName("Selenium");
			chp.Billing_Address1("12345 Dodge Avenue");
			chp.Billing_City("Omaha");
			chp.Billing_PostCode("543218");
			chp.Billing_Country("United States");
			chp.Billing_RegionState("California");
			Thread.sleep(3000);
			chp.Billing_Continue();
			Thread.sleep(3000);

			// Delivery Details
			chp.Delivery_IWantToUseANewAddress();
			Thread.sleep(5000);
			chp.Delivery_FirstName("Jane");
			chp.Delivery_LastName("Selenium");
			chp.Delivery_Address1("12345 Maple Street");
			chp.Delivery_City("Des Moines");
			chp.Delivery_PostCode("4562313");
			chp.Delivery_Country("United States");
			chp.Delivery_RegionState("Guam");
			Thread.sleep(3000);
			chp.Delivery_Continue();
			Thread.sleep(5000);

			chp.DeliveryMethod_Continue();
			Thread.sleep(3000);
			chp.Payment_Agree();
			Thread.sleep(5000);
			chp.PM_Continue();
			Thread.sleep(3000);

			chp.ConfirmOrder();
			Thread.sleep(3000);

			String message = chp.message_CompletePurchase();
			try {
				logger.info("Verifying order confirmation message.");
				Assert.assertTrue(message.contains("Your order has been placed!"));
				logger.debug("Order placed confirmation message verified successfully.");
			} catch (AssertionError e) {
				logger.error("Assertion error: " + e.getMessage());
				throw e; // Rethrow to fail the test
			}
		} catch (Exception e) {
			logger.error("An unexpected error occurred: " + e.getMessage(), e);
			throw e; // Rethrow to fail the test
		}

		logger.debug("Test execution completed.");
	}
}
