package mzk.PatientPortal.BaseClass;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.Login;
import mzk.portal.utils.Readfile;
import mzk.portal.utils.Selenium_Functions;

public class LoginTestClass extends BaseTestClass {

	private static LoginTestClass instance = null;

	public static LoginTestClass getInstance(RemoteWebDriver remoteWebDriver) {

		if (instance == null) {
			instance = new LoginTestClass();
		}
		return instance;
	}

	public void login() {
		System.err.println("---------------------------Login test Start--------------------------------");
		logger.info("Starting login test...");
		Login.getInstance(dr).PatientEmailAddress(Readfile.getInstance().getEmail());
		logger.info("Patient Email Address is Entered");
		Login.getInstance(dr).sendOTP();
		logger.info("Hitting the Send OTP Button");
		Login.getInstance(dr).codeOtp1(Readfile.getInstance().getOtp());
		logger.info("Entered the OTP for the codeOtp1");
		Login.getInstance(dr).codeOtp2(Readfile.getInstance().getOtp());
		logger.info("Entered the OTP for the codeOtp2");
		Login.getInstance(dr).codeOtp3(Readfile.getInstance().getOtp());
		logger.info("Entered the OTP for the codeOtp3");
		Login.getInstance(dr).codeOtp4(Readfile.getInstance().getOtp());
		logger.info("Entered the OTP for the codeOtp4");
		Login.getInstance(dr).loginButton();
		logger.info("Hitting the login Button");

		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Ayesha A";
		String ActualName = Login.getInstance(dr).getProfileName().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Patient Name deos't Matched");
			Selenium_Functions.drawBorder(Login.getInstance(dr).getProfileName());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "Dashboard.png");
		}
		System.err.println("---------------------------Login test End--------------------------------");
		Assert.assertAll();
	}
}
