package mzk.PatientPortal.BaseClass;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.PersonalDetails;
import mzk.portal.utils.ExtentReport;
import mzk.portal.utils.Readfile;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;

@Listeners(ExtentReport.class)
public class PersonalDetailsTest extends BaseTestClass {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public static void UserPersonalDetails() throws Throwable {
		System.err.println("---------------------------PersonalDetails test Start--------------------------------");
		logger.info("Starting UserPersonalDetails test...");
		LoginTestClass.getInstance(dr).login();
		PersonalDetails.getInstance(dr).profilebutton();
		logger.info("Hitting the profile button");
		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Personal Details";
		String ActualName = PersonalDetails.getInstance(dr).getPersonalDetails().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(PersonalDetails.getInstance(dr).getPersonalDetails());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-PersonalDetails.png");
		}
		Thread.sleep(2000);
		PersonalDetails.getInstance(dr).PreferredLanguage(Readfile.getInstance().getLanguage());
		logger.info("Entered the Language");
		PersonalDetails.getInstance(dr).Nationality();
		logger.info("Select the Nationality");
		PersonalDetails.getInstance(dr).Citizentype();
		logger.info("Select the Citizen type");
		PersonalDetails.getInstance(dr).Address(Readfile.getInstance().getAddress());
		logger.info("Entered the Address");
		PersonalDetails.getInstance(dr).Countryname();
		logger.info("Select the Country name");
		PersonalDetails.getInstance(dr).Cityname();
		logger.info("Select the City name");
		PersonalDetails.getInstance(dr).Areaname();
		logger.info("Select the Area name");
		PersonalDetails.getInstance(dr).save();
		logger.info("Hitting the save button");
		PersonalDetails.getInstance(dr).EmergencyContact();
		logger.info("Hitting the EmergencyContact Button");
		PersonalDetails.getInstance(dr).Checkbox();
		logger.info("Checking the checkbox");
		LogoutTestClass.getInstance(dr).logout();
		logger.info("UserPersonalDetails Test completed");
		System.err.println("---------------------------PersonalDetails test End--------------------------------");
		Assert.assertAll();
	}
}
