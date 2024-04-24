package mzk.PatientPortal.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.EmergencyContact;
import mzk.portal.utils.FakerData;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;
import mzk.portal.utils.TestData;

public class EmergencyContactTest extends BaseTestClass {
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	private static final Logger logger = LogManager.getLogger(EmergencyContactTest.class);

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void PoratlEmergencyContact() throws Throwable {

		System.err.println("---------------------------EmergencyContact test Start--------------------------------");
		logger.info("Starting EmergencyContact test...");
		LoginTestClass.getInstance(dr).login();
		EmergencyContact.getInstance(dr).profilebutton();
		logger.info("Hitting the profile button");
		EmergencyContact.getInstance(dr).EmergencyContactButton();
		logger.info("Hitting the EmergencyContact Button");
		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Emergency Contact";
		String ActualName = EmergencyContact.getInstance(dr).getEmergencyContact().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(EmergencyContact.getInstance(dr).getEmergencyContact());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-EmergencyContact.png");
		}
		EmergencyContact.getInstance(dr).firstName(FakerData.firstName);
		logger.info("Entered the Firstname");
		EmergencyContact.getInstance(dr).lastName(FakerData.lastName);
		logger.info("Entered the LastName");
		EmergencyContact.getInstance(dr).MaleGender();
		logger.info("Hitting Male Radio button");
		EmergencyContact.getInstance(dr).mobileNumber(TestData.getInstance().getMobilenumber());
		logger.info("Entered the Mobile Number");
		EmergencyContact.getInstance(dr).Relationship();
		logger.info("Entered the Relationship");
		EmergencyContact.getInstance(dr).Checkbox();
		logger.info("Checking the checkbox");
		EmergencyContact.getInstance(dr).Email(FakerData.emailid);
		logger.info("Entered the EmailId");
		EmergencyContact.getInstance(dr).saveContact();
		logger.info("Hitting the saveContact button");
		Thread.sleep(3000);
		LogoutTestClass.getInstance(dr).logout();
		logger.info("EmergencyContact Test completed");
		System.err.println("---------------------------EmergencyContact test End--------------------------------");
		Assert.assertAll();
	}
}
