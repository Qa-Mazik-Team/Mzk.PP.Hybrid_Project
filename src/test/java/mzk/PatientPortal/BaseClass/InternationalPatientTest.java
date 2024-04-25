package mzk.PatientPortal.BaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.InternationalPatient;
import mzk.portal.utils.ExtentReport;
import mzk.portal.utils.FakerData;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;
import mzk.portal.utils.TestData;

@Listeners(ExtentReport.class)
public class InternationalPatientTest extends BaseTestClass {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void InternationalPatientRegistration() throws Throwable {
		System.err
				.println("---------------------------InternationalPatient test Start--------------------------------");

		logger.info("Starting InternationalPatientRegistration test...");

		InternationalPatient.getInstance(dr).signupbutton();
		logger.info("Hitting the signup button");
		InternationalPatient.getInstance(dr).Clickherebutton();
		logger.info("Hitting the Clickhere button");

		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Connect With Us";
		String ActualName = InternationalPatient.getInstance(dr).getConnectWith().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(InternationalPatient.getInstance(dr).getConnectWith());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-ConnectWithUs.png");
		}
		InternationalPatient.getInstance(dr).firstname(FakerData.firstName);
		logger.info("Entered the Firstname");
		InternationalPatient.getInstance(dr).lastName(FakerData.lastName);
		logger.info("Entered the LastName");
		InternationalPatient.getInstance(dr).Malebutton();
		logger.info("Hitting Male Radio button");
		InternationalPatient.getInstance(dr).DateofBirth(TestData.getInstance().getDOB());
		logger.info("Select the DOB");
		InternationalPatient.getInstance(dr).Email(FakerData.emailid);
		logger.info("Entered the EmailID");
		InternationalPatient.getInstance(dr).mobileNumber(TestData.getInstance().getMobilenumber());
		logger.info("Entered the Mobile Number");
		Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "nationality.png");
		logger.info("Screenshots Taken");
		InternationalPatient.getInstance(dr).Nationality();
		logger.info("Selecting the Nationality");
		InternationalPatient.getInstance(dr).passportNumber(TestData.getInstance().getPassportNumber());
		logger.info("Entered the Passport Number");
		InternationalPatient.getInstance(dr).PassportExpiryDate();
		logger.info("Select the Passport Expiry Date");
		InternationalPatient.getInstance(dr).message("This is Indian Expact Member for Registration");
		logger.info("Entered the Message");
		Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "passsportExiprydate.png");
		logger.info("Screenshots Taken");
		InternationalPatient.getInstance(dr).SendMessage();
		logger.info("Hitting the SendMessage button");
		Thread.sleep(3000);
		InternationalPatient.getInstance(dr).ConnectWithUs();
		logger.info("Hitting the ConnectWithUs button");
		InternationalPatient.getInstance(dr).Register();
		logger.info("Hitting the Register button");
		logger.info("InternationalPatientRegistration Test completed");
		System.err.println("---------------------------InternationalPatient test End--------------------------------");
		Assert.assertAll();
	}
}
