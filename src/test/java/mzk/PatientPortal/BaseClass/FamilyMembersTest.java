package mzk.PatientPortal.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.FamilyMembers;
import mzk.portal.utils.FakerData;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;

public class FamilyMembersTest extends BaseTestClass {

	private static final Logger logger = LogManager.getLogger(FamilyMembersTest.class);

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void PatientFamilyMember() {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		System.err.println("---------------------------FamilyMembers test Start--------------------------------");
		logger.info("Starting FamilyMembersDetails test...");
		LoginTestClass.getInstance(dr).login();
		FamilyMembers.getInstance(dr).profilebutton();
		logger.info("Hitting the profile button");
		FamilyMembers.getInstance(dr).FamilymembersButton();
		logger.info("Hitting the Familymembers Button");
		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Family Members";
		String ActualName = FamilyMembers.getInstance(dr).getFamilyMembers().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(FamilyMembers.getInstance(dr).getFamilyMembers());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-FamilyMembers.png");
		}
		FamilyMembers.getInstance(dr).firstName(FakerData.firstName);
		logger.info("Entered the Firstname");
		FamilyMembers.getInstance(dr).lastName(FakerData.lastName);
		logger.info("Entered the LastName");
		FamilyMembers.getInstance(dr).MaleGender();
		logger.info("Hitting Male Radio button");
		FamilyMembers.getInstance(dr).Relationship();
		logger.info("Entered the Relationship");
		FamilyMembers.getInstance(dr).savemember();
		logger.info("Hitting the savemember button");
		LogoutTestClass.getInstance(dr).logout();
		logger.info("FamilyMembersDetails Test completed");
		System.err.println("---------------------------FamilyMembers test End--------------------------------");
		Assert.assertAll();
	}
}
