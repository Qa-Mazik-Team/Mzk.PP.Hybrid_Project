package mzk.PatientPortal.elements;

import java.awt.Robot;
import java.awt.event.KeyEvent;

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

public class EmergencyContact extends BaseTestClass {

	private static EmergencyContact instance = null;

	public EmergencyContact(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static EmergencyContact getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new EmergencyContact(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//a[@href='profile']")
	WebElement Mzk_profileButton;

	public void profilebutton() throws Throwable {
		new WebDriverWait(driver.get(), 30).until(ExpectedConditions.elementToBeClickable(Mzk_profileButton)).click();
	}

	@FindBy(xpath = "//*[@id='EmergencyContact']")
	WebElement Mzk_EmergencyContactButton;

	public void EmergencyContactButton() {
		Mzk_EmergencyContactButton.click();
	}

	
	@FindBy(xpath = "//p[@class='mb-0']")
	WebElement Mzk_EmergencyContact;

	public WebElement getEmergencyContact() {
		return Mzk_EmergencyContact;
	}
	
	
	
	@FindBy(xpath = "//*[@id='contact-tab']")
	WebElement Mzk_AddMember;

	public void AddMember() {
		Mzk_AddMember.click();
	}

	@FindBy(xpath = "//*[@id='pcINSUR']")
	WebElement Mzk_firstName;

	public void firstName(String firstname) {
		Mzk_firstName.sendKeys(firstname);
	}

	@FindBy(xpath = "//*[@id='ecMN']")
	WebElement Mzk_middletName;

	public void middletName(String Middlename) {
		Mzk_middletName.sendKeys(Middlename);
	}

	@FindBy(xpath = "//*[@id='pcMEM']")
	WebElement Mzk_lastName;

	public void lastName(String lastname) {
		Mzk_lastName.sendKeys(lastname);
	}

	@FindBy(xpath = "//*[@for='Male']")
	WebElement Mzk_Male;

	public void MaleGender() {
		new WebDriverWait(driver.get(), 30).until(ExpectedConditions.elementToBeClickable(Mzk_Male)).click();
	}

	@FindBy(xpath = "//*[@id='mobileNumber']")
	WebElement Mzk_mobileNumber;

	public void mobileNumber(String Mobilenumber) {
		Mzk_mobileNumber.sendKeys(Mobilenumber);
	}

	@FindBy(xpath = "//*[@id='EmergencyContactRoleID']")
	WebElement Mzk_EmergencyContactRole;

	public void Relationship() throws Throwable {
		Mzk_EmergencyContactRole.clear();
		String[] relationship = { "Associate" };

		for (String R : relationship) {
			Mzk_EmergencyContactRole.sendKeys(R, Keys.ARROW_DOWN, Keys.ENTER);
		}
	}

	@FindBy(xpath = "//*[@id='flexCheckChecked']")
	WebElement Mzk_flexCheckChecked;

	public void Checkbox() {
		Selenium_Functions.scrollIntoView(Mzk_flexCheckChecked, getDriver());
		Mzk_flexCheckChecked.click();
	}

	@FindBy(xpath = "(//button[@id='updateprogressbtn'])[position()=1]")
	WebElement Mzk_SaveButton;

	@FindBy(xpath = "//*[@id='oclcw-chatButton']")
	WebElement Mzk_chatbot;

	public void saveContact() throws Throwable {
		Robot robot = new Robot();
		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}

		new Actions(getDriver()).clickAndHold(Mzk_SaveButton).release().perform();

		for (int i = 0; i < 2; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
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

	@FindBy(xpath = "//button[@class='close-btn']")
	WebElement Mzk_closeButton;

	public void closeButton() {
		Mzk_closeButton.click();
	}

	@FindBy(xpath = "//*[@id='Email']")
	WebElement Mzk_Email;

	public void Email(String email) {

		Mzk_Email.sendKeys(email);
	}

	@FindBy(xpath = "//*[@id='pdADD']")
	WebElement Mzk_Address;

	public void Address(String Value) {
		Selenium_Functions.scrollIntoView(Mzk_Address, getDriver());
		Mzk_Address.clear();
		Mzk_Address.sendKeys(Value);
	}

	@FindBy(xpath = "//*[@id='CountryOfResidence']")
	WebElement Mzk_CountryOfResidence;

	public void Countryname() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].value = '';", Mzk_CountryOfResidence);
		Mzk_CountryOfResidence.sendKeys("United Arab Emirates", Keys.ARROW_DOWN, Keys.ENTER);
	}

	@FindBy(xpath = "//*[@id='city']")
	WebElement Mzk_City;

	public void Cityname() {
		Mzk_City.sendKeys("Abu Dhabi");
	}

	@FindBy(xpath = "//*[@id='Area']")
	WebElement Mzk_Area;

	public void Areaname() {
		Mzk_Area.clear();
		Mzk_Area.sendKeys("Al Ain City", Keys.ARROW_DOWN, Keys.ENTER);
	}
}
