package mzk.PatientPortal.BaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.RequestAccess;
import mzk.portal.utils.ExtentReport;
import mzk.portal.utils.Readfile;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;

@Listeners(ExtentReport.class)
public class RequestAccessTest extends BaseTestClass {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void UserRequestAccess() throws Throwable {
		System.err.println("---------------------------RequestAccess test Start--------------------------------");

		logger.info("Starting UserRequestAccess test...");

		LoginTestClass.getInstance(dr).login();
		RequestAccess.getInstance(dr).profilebutton();
		logger.info("Hitting the profile button");
		RequestAccess.getInstance(dr).RequestAccessButton();
		logger.info("Hitting the RequestAccess Button");

		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Request Access To Medical Record";
		String ActualName = RequestAccess.getInstance(dr).getRequestAccess().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(RequestAccess.getInstance(dr).getRequestAccess());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-RequestAccess.png");
		}

		RequestAccess.getInstance(dr).firstName(Readfile.getInstance().getFirstName());
		logger.info("Entered the Firstname");
		RequestAccess.getInstance(dr).lastName(Readfile.getInstance().getLastName());
		logger.info("Entered the LastName");
		RequestAccess.getInstance(dr).Relationship();
		logger.info("Entered the Relationship");
		RequestAccess.getInstance(dr).CitizenType();
		logger.info("Select the Citizen type");
		RequestAccess.getInstance(dr).patientEmiratesIdNumber(Readfile.getInstance().getEIDNumber());
		logger.info("Entered the patient EmiratesId Number");
		Thread.sleep(4000);
		RequestAccess.getInstance(dr).patientdateOfBirth();
		logger.info("Select the patient DateOfBirth");
		RequestAccess.getInstance(dr).patientMobilenumber(Readfile.getInstance().getMobilenumber());
		logger.info("Entered the Mobilenumber");
		RequestAccess.getInstance(dr).patientEmailId(Readfile.getInstance().getEmailid());
		logger.info("Entered the patient EmailId");
		RequestAccess.getInstance(dr).Accesslevel();
		logger.info("Select the Accesslevel");
		RequestAccess.getInstance(dr).SubmitButton();
		logger.info("Hitting the Submit button");
		try {
			String Actaul = RequestAccess.getInstance(dr).getToasterTitle();
			String Expected = "Success";
			String expectedtitle = "Warning";

			if (Actaul.equalsIgnoreCase(Expected)) {
				Assert.assertEquals(Actaul, Expected);
				logger.info("Validate the Toaste Message with Actual And Expected" + Actaul + " " + Expected);
			} else if (Actaul.equalsIgnoreCase(expectedtitle)) {
				Assert.assertEquals(Actaul, expectedtitle);
				logger.info("Validate the Toaste Message with Actual And Expected" + Actaul + " " + expectedtitle);
				Thread.sleep(2000);
				Selenium_Functions.drawBorder(RequestAccess.getInstance(dr).getToasterImage());
				logger.info("drawing border on Toaster Message");
				Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "warning.png");
				logger.info("Toaster Message Screenshot Taken");
			}

		} catch (Exception e) {
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "WithoutRequestValues.png");
			logger.info("Screenshot taken Without giving input Values");
		}
		LogoutTestClass.getInstance(dr).logout();
		logger.info("UserRequestAccess Test completed");
		System.err.println("---------------------------RequestAccess test End--------------------------------");
		Assert.assertAll();
	}

}
