package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC02_Login extends BaseClass {

	// Logger initialization
	private static final Logger logger = LogManager.getLogger(TC02_Login.class);

	// Retry Analyzer
	public static class RetryAnalyzer implements IRetryAnalyzer {
		private int count = 0;
		private static final int maxRetryCount = 3;

		@Override
		public boolean retry(ITestResult result) {
			if (count < maxRetryCount) {
				count++;
				return true; // retry test
			}
			return false; // no more retries
		}
	}

	@Test(groups = { "smoke", "regression",
			"datadriven" }, dataProvider = "LoginData", dataProviderClass = DataProviders.class, retryAnalyzer = RetryAnalyzer.class)
	void testLogin(String email, String pwd) {
		logger.info("Test Started: TC02_Login");

		HomePage hp = new HomePage(getDriver());
		try {
			logger.debug("Navigating to login page...");
			hp.clickMyAccount();
			hp.goToLogin();

			LoginPage lp = new LoginPage(getDriver());
			logger.debug("Setting email and password...");
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			AccountPage ap = new AccountPage(getDriver());
			boolean status = ap.getMyAccountConfirmation().isDisplayed();
			logger.debug("My account confirmation status: " + status);

			if (status) {
				logger.info("Login successful.");
				ap.clickMyAccountDropDown();
				ap.clickLogout();

				// Verifying login success
				Assert.assertTrue(status, "Login was not successful.");
				logger.info("Test Passed: Login was successful.");
			} else {
				logger.error("Login failed: My Account confirmation not displayed.");
				Assert.assertTrue(false, "Login failed. My Account confirmation is not displayed.");
			}
		} catch (Exception e) {
			logger.error("An exception occurred during the test: " + e.getMessage());
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}

		logger.info("Test Completed: TC02_Login");
	}

	// Other test setup and teardown methods can go here if necessary
}
