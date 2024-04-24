package mzk.PatientPortal.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mzk.PatientPortal.BaseClass.BaseTestClass;

public class PaymentCategory extends BaseTestClass {

	private static PaymentCategory instance = null;

	public PaymentCategory(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static PaymentCategory getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new PaymentCategory(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//a[@href='profile']")
	WebElement Mzk_ProfileButton;

	public void profilebutton() {
		Mzk_ProfileButton.click();
	}

	@FindBy(xpath = "//*[@id='PatientCategory']")
	WebElement Mzk_PaymentCategoryButton;

	public void PaymentCategoryButton() {
		Mzk_PaymentCategoryButton.click();
	}
	
	@FindBy(xpath = "//p[@class='mb-0']")
	WebElement Mzk_PaymentCategory;

	public WebElement getPaymentCategory() {
		return Mzk_PaymentCategory;
	}

	@FindBy(xpath = "//*[text()='Insurance']")
	WebElement Mzk_Insurance;

	public void Insurance() {
		Mzk_Insurance.click();
	}

	@FindBy(xpath = "//*[@id='contact-tab']")
	WebElement Mzk_Contact;

	public void contact() {
		Mzk_Contact.click();
	}

	@FindBy(xpath = "//*[@id='InsuranceCompanyID']")
	WebElement Mzk_InsuranceCompanyID;

	public void InsuranceCompany() {
		Mzk_InsuranceCompanyID.clear();

		String[] relationship = { "ADNIC Healthcare" };

		for (String R : relationship) {
			Mzk_InsuranceCompanyID.sendKeys(R, Keys.ARROW_DOWN, Keys.ENTER);
		}
	}

	@FindBy(xpath = "(//*[@id='pcMEM'])[1]")
	WebElement Mzk_MemberID;

	public void MemberID(String Memberid) {
		Mzk_MemberID.sendKeys(Memberid);
	}

	@FindBy(xpath = "(//*[@id='pcMEM'])[2]")
	WebElement Mzk_PolicyHolder;

	public void PolicyHolder(String name) {
		Mzk_PolicyHolder.sendKeys(name);
	}

	@FindBy(xpath = "//*[@id='NetworkID']")
	WebElement Mzk_NetworkID;

	public void NetworkID() {
		Mzk_NetworkID.clear();

		String[] network = { "Gold" };

		for (String n : network) {
			Mzk_NetworkID.sendKeys(n, Keys.ARROW_DOWN, Keys.ENTER);
		}
	}

	@FindBy(xpath = "//*[@id='Effective From']")
	WebElement Mzk_EffectiveDate;

	public void EffectiveDate(String effectiveDate) {
		new Actions(driver.get()).sendKeys(Mzk_EffectiveDate, effectiveDate).perform();
	}

	@FindBy(xpath = "//*[@id='Valid Until']")
	WebElement Mzk_ValidDate;

	public void ValidDate() {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", Mzk_ValidDate);
		new Actions(driver.get()).moveToElement(Mzk_ValidDate).click().sendKeys("12112030",Keys.TAB).perform();
		
	}

	@FindBy(xpath = "//*[@id='updateprogressbtn']")
	WebElement Mzk_SubmitButton;

	public void SubmitButton() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Mzk_SubmitButton);
	}

	@FindBy(xpath = "//*[@class='blazored-toast-heading']")
	WebElement Mzk_ToasterTitle;

	public String getToasterTitle() {
		return Mzk_ToasterTitle.getText();
	}

	@FindBy(xpath = "//p[@class='blazored-toast-message']")
	WebElement Mzk_ToasterMessage;

	public String getToasterMessage() {
		return Mzk_ToasterMessage.getText();
	}

	@FindBy(xpath = "//*[@class='blazored-toast-container position-bottomright']")
	WebElement Mzk_ToasterImage;

	public WebElement getToasterImage() {
		return Mzk_ToasterImage;
	}

	@FindBy(xpath = "(//*[@class='nav-item d-flex flex-column align-items-left'])[last()]")
	WebElement Mzk_InsuranceList;

	public void InsuranceList() {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Mzk_InsuranceList);
	}
}
