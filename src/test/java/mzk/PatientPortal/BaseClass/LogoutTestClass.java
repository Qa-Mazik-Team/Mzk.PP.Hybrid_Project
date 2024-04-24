package mzk.PatientPortal.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.Login;
import mzk.PatientPortal.elements.Logout;
import mzk.portal.utils.Selenium_Functions;

public class LogoutTestClass extends BaseTestClass {
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	private static final Logger logger = LogManager.getLogger(LogoutTestClass.class);

	private static LogoutTestClass instance = null;

	public static LogoutTestClass getInstance(RemoteWebDriver remoteWebDriver) {

		if (instance == null) {
			instance = new LogoutTestClass();
		}
		return instance;
	}

	public void logout() {
		System.err.println("---------------------------Logout test Start--------------------------------");
		Logout.getInstance(dr).logoutButton();
		logger.info("Hitting the Logout Button");
		Logout.getInstance(dr).yesButton();
		logger.info("Hitting the yes Button");
		logger.info("logout Test completed");

		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "New User ? Sign up here"; 
		String ActualName = Login.getInstance(dr).getSignUp().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(Login.getInstance(dr).getSignUp());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "Login Details.png");
		}

		System.err.println("---------------------------Logout test End--------------------------------");
		Assert.assertAll();
	}
}
