package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCertificatePage;
import pageObjects.HomePage;
import testBase.BaseClass;
import testCases.TC02_Login.RetryAnalyzer;

import org.testng.Reporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TC06_PurchaseGiftCertificate extends BaseClass {

	// Logger initialization
	private static final Logger logger = LogManager.getLogger(TC06_PurchaseGiftCertificate.class);

	@Test(groups = { "regression" }, retryAnalyzer = RetryAnalyzer.class)
	void testPurchaseGiftCertificate() {
		// Log the start of the test
		logger.debug("Test started: testPurchaseGiftCertificate");

		try {
			// Log actions as they occur
			logger.debug("Navigating to HomePage.");
			HomePage hp = new HomePage(getDriver());
			hp.Select_GiftCertificate();
			logger.debug("Navigated to GiftCertificatePage.");

			GiftCertificatePage gc = new GiftCertificatePage(getDriver());

			// Fill out the Gift Certificate details and log each action
			logger.debug("Entering recipient's name.");
			gc.Recipients_Name("John Doe");

			logger.debug("Entering recipient's email.");
			gc.Recipients_Email("johndoe@gmail.com");

			logger.debug("Entering sender's name.");
			gc.Your_Name("Jane Doe");

			logger.debug("Entering sender's email.");
			gc.Your_Email("janedoe@gmail.com");

			logger.debug("Selecting birthday for the Gift Certificate.");
			gc.GC_Birthday();

			logger.debug("Agreeing to terms and conditions.");
			gc.Agree();

			logger.debug("Proceeding with the purchase.");
			gc.Continue();

			// Validate the success message after purchase
			logger.debug("Verifying purchase confirmation message.");
			String message = gc.message_PurchaseGiftCertificate();

			// Try-Catch block for assertion
			try {
				Assert.assertTrue(message.contains("Thank you for purchasing a gift certificate!"));
				logger.debug("Assertion passed: Purchase successful.");
			} catch (AssertionError e) {
				logger.error("Assertion failed. Expected success message but got: " + message, e);
				throw e; // Rethrow the error to trigger retry if necessary
			}

		} catch (Exception e) {
			// Log any unexpected errors
			logger.error("Unexpected error occurred during test execution", e);
			throw e; // Ensure the test fails
		} finally {
			// Log the end of the test
			logger.debug("Test completed: testPurchaseGiftCertificate");
		}
	}
}
