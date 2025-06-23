package testCases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

import pageObjects.ProductPage;
import testBase.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.RetryAnalyzer;

public class TC03_AddToCart extends BaseClass {

	// Initialize the Logger
	private static final Logger logger = LogManager.getLogger(TC03_AddToCart.class);

	@Test(groups = { "smoke", "regression" }, retryAnalyzer = RetryAnalyzer.class)
	public void testAddToCart() {
		logger.debug("Test Started: testAddToCart");

		try {
			HomePage hp = new HomePage(getDriver());
			logger.debug("Navigating to Laptops and Notebooks section");
			hp.LaptopsAndNotebooks();
			hp.ShowAll_LaptopsAndNotebooks();

			ProductPage pp = new ProductPage(getDriver());
			logger.debug("Selecting product: HP LP3065");
			pp.Select_HPLP3065();

			// Setting the delivery date
			logger.debug("Setting the delivery date");

			pp.setDeliveryDate.clear();
			LocalDate today = LocalDate.now(); // Got today's date
			logger.debug("Today's date: " + today);

			// Add 7 days to today's date
			LocalDate deliveryDate = today.plusDays(7);
			logger.debug("Calculated delivery date: " + deliveryDate);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedDeliveryDate = deliveryDate.format(formatter);
			logger.debug("Formatted delivery date: " + formattedDeliveryDate);

			pp.setDeliveryDate.sendKeys(formattedDeliveryDate);
			logger.debug("Delivery date entered in input field");

			// Adding product to cart
			pp.AddToCart_Btn();
			logger.debug("Clicked on Add to Cart button");

			// Verifying the success message
			String message = pp.message_AddToCart();
			logger.debug("Message received: " + message);

			Assert.assertTrue(message.contains("Success"));
			logger.debug("Assertion passed: Product added to cart successfully");

		} catch (AssertionError e) {
			logger.error("Assertion failed: " + e.getMessage());
			throw e; // Rethrow to fail the test

		} catch (Exception e) {
			logger.error("Unexpected exception occurred: " + e.getMessage());
			throw e; // Rethrow to fail the test

		} finally {
			logger.debug("Test Ended: testAddToCart");
		}
	}
}
