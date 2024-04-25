package mzk.PatientPortal.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mzk.PatientPortal.BaseClass.BaseTestClass;

public class Registration extends BaseTestClass {

	private static Registration instance = null;

	public Registration(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static Registration getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new Registration(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//*[@href='/signup']")
	WebElement Mzk_SignupButton;

	public void signupbutton() {
		new WebDriverWait(driver.get(), 40).until(ExpectedConditions.elementToBeClickable(Mzk_SignupButton)).click();

	}

	@FindBy(xpath = "//h2[@class='page-headingh1 mb-0']")
	WebElement Mzk_Registration;

	public WebElement getRegistration() {
		return Mzk_Registration;
	} 
	
	
	@FindBy(xpath = "//*[@id='EmiratesIdNumber']")
	WebElement Mzk_EmiratesIdNumber;

	public void patientEmiratesIdNumber(String Eid) {
		Mzk_EmiratesIdNumber.clear();
		Mzk_EmiratesIdNumber.sendKeys(Eid);
		new Actions(driver.get()).sendKeys(Keys.ARROW_UP).sendKeys(Eid).perform();
	}

	@FindBy(xpath = "//*[@id='EmiratesExpiryDate']")
	WebElement Mzk_EmiratesExpiryDate;

	public void EmiratesExpiryDateSelect(String expirydate) {
		new Actions(driver.get()).sendKeys(Mzk_EmiratesExpiryDate, expirydate).perform();
	}

	@FindBy(xpath = "//*[@id='QRFirstName']")
	WebElement Mzk_QRFirstName;

	public void firstName(String firstname) {
		Mzk_QRFirstName.sendKeys(firstname);
	}

	@FindBy(xpath = "//*[@id='QRLastName']")
	WebElement Mzk_QRLastName;

	public void lastName(String lastname) {
		Mzk_QRLastName.sendKeys(lastname);
	}

	@FindBy(xpath = "//*[@for='Male']")
	WebElement Mzk_Male;

	public void gender() {
		new WebDriverWait(driver.get(), 20).until(ExpectedConditions.elementToBeClickable(Mzk_Male)).click();
	}

	@FindBy(xpath = "//*[@id='DateofBirth']")
	WebElement Mzk_DateofBirth;

	public void patientdateOfBirth(String DOB) {
		new Actions(driver.get()).sendKeys(Mzk_DateofBirth, "1010" + DOB).perform();
	}

	@FindBy(xpath = "//*[@id='Email']")
	WebElement Mzk_Email;

	public void patientEmailId(String email) {
		Mzk_Email.sendKeys(email);
	}

	@FindBy(xpath = "//*[@class='gmail-dropdown-item']")
	WebElement Mzk_gmaildomain;

	public void Emaildomain() {
		new Actions(driver.get()).moveToElement(Mzk_gmaildomain).click().perform();
	}

	@FindBy(xpath = "//*[@id='mobileNumber']")
	WebElement Mzk_mobileNumber;

	public void patientMobilenumber(String Mobilenumber) {
		try {
			Mzk_mobileNumber.sendKeys(Mobilenumber);
		} catch (Exception e) {
			Mzk_mobileNumber.sendKeys(Mobilenumber);
		}

	}

	@FindBy(xpath = "//*[text()='Save & Continue']")
	WebElement Mzk_SaveButton;

	public void saveButton() {
		Mzk_SaveButton.click();
	}

	@FindBy(xpath = "//*[@id='login-LoginButton']")
	WebElement Mzk_LoginButton;

	public WebElement getlogin() {
		return Mzk_LoginButton;
	}

	@FindBy(xpath = "//h2[text()='Account Registration Successful ']")
	WebElement Mzk_AccountRegistration;

	public WebElement AccountReg() {
		return Mzk_AccountRegistration;
	}
}
