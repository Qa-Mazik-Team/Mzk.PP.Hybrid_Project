package mzk.PatientPortal.BaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.ForgotEmail;
import mzk.portal.utils.ExtentReport;
import mzk.portal.utils.Readfile;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;

@Listeners(ExtentReport.class)
public class ForgotEmailTest extends BaseTestClass {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void ForgotEmailID() throws Throwable {
		System.err.println("---------------------------ForgotEmail test Start--------------------------------");
		logger.info("Starting ForgotEmailID test...");
		ForgotEmail.getInstance(dr).ForgotEmaillink();
		logger.info("Hitting the Forgot Email Link");

		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Recover Your Login Details";
		String ActualName = ForgotEmail.getInstance(dr).getForgotEmail().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(ForgotEmail.getInstance(dr).getForgotEmail());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-ForgotEmail.png");
		}

		ForgotEmail.getInstance(dr).EmiratesIdNumber(Readfile.getInstance().getEID());
		logger.info("Entered the EmiratesId Number");
		ForgotEmail.getInstance(dr).getDetails();
		Thread.sleep(3000);
		logger.info("Hitting the getDetails button");
		ForgotEmail.getInstance(dr).passport();
		logger.info("Hitting the ViaPassport button");
		ForgotEmail.getInstance(dr).Login();
		logger.info("Hitting the Login button");
		logger.info("ForgotEmailID Test completed");
		System.err.println("---------------------------ForgotEmail test End--------------------------------");
		Assert.assertAll();
	}
}
