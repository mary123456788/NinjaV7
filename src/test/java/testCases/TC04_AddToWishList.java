package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import testBase.BaseClass;

public class TC04_AddToWishList extends BaseClass {

	// Initialize the logger
	private static final Logger logger = LogManager.getLogger(TC04_AddToWishList.class);

	@Test(groups = { "regression" }, retryAnalyzer = RetryAnalyzer.class)
	void testAddToWishList() throws InterruptedException {
		logger.debug("Starting testAddToWishList()");

		try {
			// Step 1: Navigate to My Account and Login
			HomePage hp = new HomePage(getDriver());
			logger.info("Clicking on 'My Account'");
			hp.clickMyAccount();

			logger.info("Navigating to Login Page");
			hp.goToLogin();

			LoginPage lp = new LoginPage(getDriver());
			logger.info("Entering login credentials");
			lp.setEmail("ma12345678@gmail.com");
			lp.setPassword("L0ve$elenium");
			lp.clickLogin();

			// Step 2: Navigate to the Laptops and Notebooks section
			logger.info("Navigating to Laptops & Notebooks section");
			hp.LaptopsAndNotebooks();
			hp.ShowAll_LaptopsAndNotebooks();
			Thread.sleep(3000); // It's better to avoid Thread.sleep(), consider using wait methods

			// Step 3: Select a product and add to wishlist
			ProductPage pp = new ProductPage(getDriver());
			logger.info("Selecting the HP Laptop HP LP3065");
			pp.Select_HPLP3065();
			Thread.sleep(2000);

			logger.info("Adding the product to wishlist");
			pp.AddToWishList_Btn();
			Thread.sleep(2000);

			// Step 4: Verify if product was added to wishlist
			String message = pp.message_AddToWishList();
			logger.debug("Message displayed: " + message);
			Assert.assertTrue(message.contains("Success"), "Product was not successfully added to wishlist!");

			logger.info("Product successfully added to wishlist.");
		} catch (AssertionError e) {
			logger.error("Assertion failed: " + e.getMessage(), e);
			throw e; // Rethrow to allow retry logic to take place
		} catch (Exception e) {
			logger.error("An unexpected error occurred: " + e.getMessage(), e);
			throw e;
		} finally {
			logger.debug("Test completed.");
		}
	}

	// RetryAnalyzer for retry logic
	public static class RetryAnalyzer implements org.testng.IRetryAnalyzer {
		private int count = 0;
		private static final int MAX_RETRIES = 3;

		@Override
		public boolean retry(ITestResult result) {
			if (count < MAX_RETRIES) {
				logger.warn("Retrying test: " + result.getName() + " | Retry count: " + (count + 1));
				count++;
				return true;
			}
			return false;
		}
	}
}
