package mzk.PatientPortal.BaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.ProvideAccess;
import mzk.portal.utils.ExtentReport;
import mzk.portal.utils.Readfile;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;

@Listeners(ExtentReport.class)
public class ProvideAccessTest extends BaseTestClass {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void UserProvideAccess() throws Throwable {
		System.err.println("---------------------------ProvideAccess test Start--------------------------------");

		logger.info("Starting UserProvideAccess test...");
		LoginTestClass.getInstance(dr).login();
		ProvideAccess.getInstance(dr).profilebutton();
		logger.info("Hitting the profile button");
		ProvideAccess.getInstance(dr).ProvideAccessButton();
		logger.info("Hitting the ProvideAccess Button");
		ProvideAccess.getInstance(dr).ContinueButton();
		logger.info("Hitting Continue button");

		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Invite someone to have access to your Record.";
		String ActualName = ProvideAccess.getInstance(dr).getProvideAccess().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(ProvideAccess.getInstance(dr).getProvideAccess());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-ProvideAccess.png");
		}

		ProvideAccess.getInstance(dr).Email(Readfile.getInstance().getEmailid());
		logger.info("Entered the EmailID");
		ProvideAccess.getInstance(dr).confirmemail(Readfile.getInstance().getEmailid());
		logger.info("Entered the confirm EmailID");
		ProvideAccess.getInstance(dr).contactname();
		logger.info("Display the Contact Name");
		Thread.sleep(3000);
		ProvideAccess.getInstance(dr).Accesslevel();
		logger.info("Select the Accesslevel");
		ProvideAccess.getInstance(dr).Relationship();
		logger.info("Select the Relationship");
		ProvideAccess.getInstance(dr).SubmitButton();
		logger.info("Hitting the Submit button");
		Thread.sleep(3000);
		try {
			String Actaul = ProvideAccess.getInstance(dr).getToasterTitle();
			String Expected = "Success";
			String expectedtitle = "Warning";

			if (Actaul.equalsIgnoreCase(Expected)) {
				Assert.assertEquals(Actaul, Expected);
				logger.info("Validate the Toaste Message with Actual And Expected" + Actaul + " " + Expected);
			} else if (Actaul.equalsIgnoreCase(expectedtitle)) {
				Assert.assertEquals(Actaul, expectedtitle);
				logger.info("Validate the Toaste Message with Actual And Expected" + Actaul + " " + expectedtitle);
			}

		} catch (Exception e) {
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "WithoutInputValues.png");
			logger.info("Screenshot taken Without giving input Values");
		}
		LogoutTestClass.getInstance(dr).logout();
		logger.info("UserProvideAccess Test completed");
		System.err.println("---------------------------ProvideAccess test End--------------------------------");
		Assert.assertAll();
	}
}
