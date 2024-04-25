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


public class ForgotEmail extends BaseTestClass {

	private static ForgotEmail instance = null;

	public ForgotEmail(RemoteWebDriver remoteWebDriver) {

		PageFactory.initElements(driver.get(), this);
	}

	public static ForgotEmail getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new ForgotEmail(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//*[text()='Forgot Email/Mobile Number?']")
	WebElement Mzk_ForgotEmailLink;

	public void ForgotEmaillink() {
		Mzk_ForgotEmailLink.click();
	}
	
	@FindBy(xpath = "//h2[text()='Recover Your Login Details ']")
	WebElement Mzk_ForgotEmail;

	public WebElement getForgotEmail() {
		return Mzk_ForgotEmail;
	} 
	

	@FindBy(xpath = "//*[@id='EmiratesIdNumber']")  
	WebElement Mzk_EmiratesIdNumber;

	public void EmiratesIdNumber(String EmiratesId) {
		Mzk_EmiratesIdNumber.clear();
		Mzk_EmiratesIdNumber.sendKeys(EmiratesId);
        new Actions(driver.get()).sendKeys(Keys.ARROW_UP).sendKeys(EmiratesId).perform();
	}

	@FindBy(xpath = "//*[@class='mt-3 submit']")
	WebElement Mzk_GetDetailsButton;

	public void getDetails() {
		Mzk_GetDetailsButton.click();
	}

	@FindBy(xpath = "//*[@class=' mt-3 forgot-details']")
	WebElement Mzk_forgotDetails;
	
	public WebElement forgotDetails() {
		return Mzk_forgotDetails;
		
	}

	@FindBy(xpath = "(//*[@class='ms-2 mt-1'])[position()=1]")
	WebElement Mzk_email;

	public WebElement getEmail() {
		return Mzk_email;
	}

	@FindBy(xpath = "(//*[@class='ms-2 mt-1'])[position()=2]")
	WebElement Mzk_mobilenumber;

	public WebElement getmobilenumber() {
		return Mzk_mobilenumber;
	}

	@FindBy(xpath = "//*[@id='passport']")
	WebElement Mzk_Viapassport;

	public void passport() {
		Mzk_Viapassport.click();
	}

	@FindBy(xpath = "//*[@id='emirates_id']")
	WebElement Mzk_emirates_id;

	public void emirates_id() {
		Mzk_emirates_id.click();
	}
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement Mzk_LoginLink;

	public void Login() {
		try {
			new WebDriverWait(driver.get(), 20).
			until(ExpectedConditions.elementToBeClickable(Mzk_LoginLink)).click();
		} catch (Exception e) {
			new WebDriverWait(driver.get(), 20).
			until(ExpectedConditions.elementToBeClickable(Mzk_LoginLink)).click();
		}
		
	}
}
