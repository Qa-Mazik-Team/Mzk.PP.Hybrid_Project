package mzk.PatientPortal.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mzk.PatientPortal.BaseClass.BaseTestClass;
import mzk.portal.utils.Selenium_Functions;

public class InternationalPatient extends BaseTestClass {

	private static InternationalPatient instance = null;

	public InternationalPatient(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static InternationalPatient getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new InternationalPatient(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//*[@href='/signup']")
	WebElement Mzk_SignupLink;

	public void signupbutton() {
		new WebDriverWait(driver.get(), 30).until(ExpectedConditions.elementToBeClickable(Mzk_SignupLink)).click();
	}

	@FindBy(xpath = "//*[text()='Click here']")
	WebElement Mzk_ClickhereLink;

	public void Clickherebutton() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Mzk_ClickhereLink);
	}

	@FindBy(xpath = "//*[@class='page-headingh1 ']")
	WebElement Mzk_ConnectWith;

	public WebElement getConnectWith() {
		return Mzk_ConnectWith;
	} 
	
	@FindBy(xpath = "//*[@id='firstname']")
	WebElement Mzk_firstname;

	public void firstname(String FirstName) {
		Mzk_firstname.sendKeys(FirstName);
	}

	@FindBy(xpath = "//*[@id='lastName']")
	WebElement Mzk_lastName;

	public void lastName(String LastName) {
		Mzk_lastName.sendKeys(LastName);
	}

	@FindBy(xpath = "//*[@for='gender Male']")
	WebElement Mzk_Male;

	public void Malebutton() {
		new WebDriverWait(driver.get(), 20).until(ExpectedConditions.elementToBeClickable(Mzk_Male)).click();
	}

	@FindBy(xpath = "//*[@id='DateofBirth']")
	WebElement Mzk_DateofBirth;

	public void DateofBirth(String DOB) {
		new Actions(driver.get()).sendKeys(Mzk_DateofBirth, "1010" + DOB).perform();
	}

	@FindBy(xpath = "//*[@id='Email']")
	WebElement Mzk_Email;

	public void Email(String email) {
		Mzk_Email.sendKeys(email);
	}

	@FindBy(xpath = "//*[@id='mobileNumber']")
	WebElement Mzk_mobileNumber;

	public void mobileNumber(String number) {
		Mzk_mobileNumber.sendKeys(number);
	}

	@FindBy(xpath = " //*[@id='Nationality']")
	WebElement Mzk_Nationality;

	public void Nationality() {
		String[] country = { "Emirati" };
		for (String N : country) {
			Selenium_Functions.mouseType(getDriver(), Mzk_Nationality, N);
		}
	}

	@FindBy(xpath = "//*[@id='passportNumber']")
	WebElement Mzk_PassportNumber;

	public void passportNumber(String number) {
		Mzk_PassportNumber.sendKeys("J" + number);
	}

	@FindBy(xpath = "//*[@id='PassportExpiryDate']")
	WebElement Mzk_PassportExpiryDate;

	public void PassportExpiryDate() {
		new Actions(driver.get()).moveToElement(Mzk_PassportExpiryDate).click().sendKeys("1010").sendKeys(Keys.ARROW_UP)
				.perform();
	}

	@FindBy(xpath = "//*[@id='message']")
	WebElement Mzk_Message;

	public void message(String Message) {
		Mzk_Message.sendKeys(Message, Keys.TAB);
	}

	@FindBy(xpath = "//input[@type='file']") // *[@src='./img/upload.svg']
	WebElement Mzk_file;

	public void Attachment(String filelocation) {
		Mzk_file.sendKeys(filelocation);
	}

	@FindBy(xpath = "//*[@id='onquickregisterbtn']")
	WebElement Mzk_Onquickregisterbtn;

	public void SendMessage() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Mzk_Onquickregisterbtn);
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

	@FindBy(xpath = "//*[@class=' me-2 ']")
	WebElement Mzk_ConnectWithUs;

	public void ConnectWithUs() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Mzk_ConnectWithUs);
	}

	@FindBy(xpath = "//*[@class=' me-2 ']")
	WebElement Register;

	public void Register() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Register);
	}
}
