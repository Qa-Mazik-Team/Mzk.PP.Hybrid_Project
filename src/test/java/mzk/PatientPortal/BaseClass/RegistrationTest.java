package mzk.PatientPortal.BaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.InternationalPatient;
import mzk.PatientPortal.elements.Registration;
import mzk.portal.utils.ExtentReport;
import mzk.portal.utils.FakerData;
import mzk.portal.utils.Readfile;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;
import mzk.portal.utils.TestData;

@Listeners(ExtentReport.class)
public class RegistrationTest extends BaseTestClass {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void registerPatient() throws Throwable {
		System.err.println("---------------------------Registration test Start--------------------------------");

		logger.info("Starting registerPatient test...");

		Registration.getInstance(dr).signupbutton();
		logger.info("Hitting the signup button");

		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Register Your Account";
		String ActualName = Registration.getInstance(dr).getRegistration().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(Registration.getInstance(dr).getRegistration());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-Registration.png");
		}

		Registration.getInstance(dr).patientEmiratesIdNumber(TestData.getInstance().getEmirateID());
		logger.info("Entered the EmirateID");
		Registration.getInstance(dr).EmiratesExpiryDateSelect(Readfile.getInstance().getExpiryYear());
		logger.info("Select the ExpiryYear");
		Registration.getInstance(dr).firstName(FakerData.firstName);
		logger.info("Entered the Firstname");
		Registration.getInstance(dr).lastName(FakerData.lastName);
		logger.info("Entered the LastName");
		Registration.getInstance(dr).gender();
		logger.info("Hitting gender button");
		Registration.getInstance(dr).patientdateOfBirth(TestData.getInstance().getDOB());
		logger.info("Select the DOB");
		Registration.getInstance(dr).patientEmailId(FakerData.emailid);
		logger.info("Entered the EmailID");
		Registration.getInstance(dr).Emaildomain();
		logger.info("hitting the Emaildomain");
		Registration.getInstance(dr).patientMobilenumber(TestData.getInstance().getMobilenumber());
		logger.info("Entered the Mobile Number");
		Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "beforeReg.png");
		logger.info("Screenshots Taken");
		InternationalPatient.getInstance(dr).Register();
		logger.info("Hitting Register Your Account, Navigate to the Login Page");
		logger.info("registerPatient Test completed");
		System.err.println("---------------------------Registration_01 test End--------------------------------");

		Assert.assertAll();
	}

}
