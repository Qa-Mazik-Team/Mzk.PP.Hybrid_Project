package mzk.PatientPortal.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mzk.PatientPortal.elements.PaymentCategory;
import mzk.PatientPortal.elements.ProvideAccess;
import mzk.portal.utils.FakerData;
import mzk.portal.utils.Readfile;
import mzk.portal.utils.RetryAnalyzer;
import mzk.portal.utils.Selenium_Functions;

public class PaymentCategoryTest extends BaseTestClass {

	private static final Logger logger = LogManager.getLogger(PaymentCategoryTest.class);

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void PatientPaymentCategory() {

		System.err.println("---------------------------PaymentCategory test Start--------------------------------");

		logger.info("Starting PaymentCategory test...");
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());

		LoginTestClass.getInstance(dr).login();
		PaymentCategory.getInstance(dr).profilebutton();
		logger.info("Hitting the profile button");
		PaymentCategory.getInstance(dr).PaymentCategoryButton();
		logger.info("Hitting the PatientCategory Button");
		SoftAssert Assert = new SoftAssert();

		String EXpecteName = "Payment Category";
		String ActualName = PaymentCategory.getInstance(dr).getPaymentCategory().getText();

		if (ActualName.equalsIgnoreCase(EXpecteName)) {
			Assert.assertEquals(ActualName, EXpecteName);
		} else {
			Assert.assertEquals(ActualName, EXpecteName, "Both Text deos't Matched");
			Selenium_Functions.drawBorder(PaymentCategory.getInstance(dr).getPaymentCategory());
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "-PaymentCategory.png");
		}

		PaymentCategory.getInstance(dr).Insurance();
		logger.info("Hitting the Insurance Button");
		PaymentCategory.getInstance(dr).contact();
		logger.info("Hitting the contact Button");
		PaymentCategory.getInstance(dr).InsuranceCompany();
		logger.info("Entered the InsuranceCompany Name");
		PaymentCategory.getInstance(dr).MemberID(FakerData.MemberID);
		logger.info("Entered the MemberID");
		PaymentCategory.getInstance(dr).PolicyHolder(FakerData.firstName);
		logger.info("Entered the Firstname");
		PaymentCategory.getInstance(dr).NetworkID();
		logger.info("Entered the NetworkID");
		PaymentCategory.getInstance(dr).EffectiveDate(Readfile.getInstance().getEffectiveDate());
		logger.info("Selecting the EffectiveDate");
		PaymentCategory.getInstance(dr).ValidDate();
		logger.info("Selecting the ValidDate");
		PaymentCategory.getInstance(dr).SubmitButton();
		logger.info("Hitting the Submit button");
		PaymentCategory.getInstance(dr).InsuranceList();
		logger.info("Hitting the InsuranceList button");
		try {

			String Expected = ProvideAccess.getInstance(dr).getToasterTitle();
			String Actaul = "Success";

			if (Actaul.equalsIgnoreCase(Expected)) {
				if (ProvideAccess.getInstance(dr).getToasterImage().isDisplayed()) {
					Thread.sleep(2000);
					Assert.assertEquals(Actaul, Expected);
					logger.info("Validate the Toaste Message with Actual And Expected");
				}
			}
		} catch (Exception e) {
			Selenium_Functions.screenshot("./Screenshots/" + timeStamp + "WithOutValues.png");
			logger.info("Screenshot taken Without giving input Values");
		}
		LogoutTestClass.getInstance(dr).logout();
		logger.info("PaymentCategory Test completed");
		System.err.println("---------------------------PaymentCategory test End--------------------------------");
		Assert.assertAll();
	}
}
