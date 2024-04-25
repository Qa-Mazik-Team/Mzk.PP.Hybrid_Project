package mzk.PatientPortal.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import mzk.PatientPortal.BaseClass.BaseTestClass;

public class RequestAccess extends BaseTestClass {

	private static RequestAccess instance = null;

	public RequestAccess(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static RequestAccess getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new RequestAccess(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//a[@href='profile']")
	WebElement Mzk_ProfileButton;

	public void profilebutton() {
		Mzk_ProfileButton.click();
	}

	@FindBy(xpath = "(//*[@id='RequestAccess'])[1]")
	WebElement Mzk_RequestAccessButton;

	public void RequestAccessButton() {
		Mzk_RequestAccessButton.click();
	}

	@FindBy(xpath = "//h5[@class='responsive-reverse-tablet']")
	WebElement Mzk_RequestAccess;

	public WebElement getRequestAccess() {
		return Mzk_RequestAccess;
	}
	
	@FindBy(xpath = "//*[@id='FirstName']")
	WebElement Mzk_FirstName;

	public void firstName(String firstname) {
		Mzk_FirstName.sendKeys(firstname);
	}

	@FindBy(xpath = "//*[@id='MiddleName']")
	WebElement Mzk_MiddleName;

	public void MiddleName(String middleName) {
		Mzk_MiddleName.sendKeys(middleName);
	}

	@FindBy(xpath = "//*[@id='LastName']")
	WebElement Mzk_LastName;

	public void lastName(String lastname) {
		Mzk_LastName.sendKeys(lastname);
	}

	@FindBy(xpath = "//*[@id='Relationship']")
	WebElement Mzk_Relationship;

	public void Relationship() throws Throwable {
		Mzk_Relationship.clear();

		Mzk_Relationship.sendKeys("Aunty");
		Thread.sleep(300);
		Mzk_Relationship.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(200);
		Mzk_Relationship.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//*[@id='Citizen Type']")
	WebElement Mzk_CitizenType;

	public void CitizenType() throws Throwable {
		Mzk_CitizenType.clear();
		Mzk_CitizenType.sendKeys("Emirati");
		Thread.sleep(300);
		Mzk_CitizenType.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(200);
		Mzk_CitizenType.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//*[@id='emirates']")
	WebElement Mzk_EmiratesIdNumber;

	public void patientEmiratesIdNumber(String Eid) {
		Mzk_EmiratesIdNumber.clear();
		Mzk_EmiratesIdNumber.sendKeys(Eid);
		new Actions(driver.get()).sendKeys(Keys.ARROW_UP).sendKeys(Eid).perform();
	}

	@FindBy(xpath = "//*[@id='birthdate']")
	WebElement Mzk_DateofBirth;

	public void patientdateOfBirth() throws Throwable {
		Mzk_DateofBirth.clear();
		Mzk_DateofBirth.sendKeys("10");
		Thread.sleep(200);
		Mzk_DateofBirth.sendKeys("10");
		Thread.sleep(200);
		Mzk_DateofBirth.sendKeys("2000");
	}

	@FindBy(xpath = "//*[@id='mobileNumber']")
	WebElement Mzk_mobileNumber;

	public void patientMobilenumber(String Mobilenumber) {
		Mzk_mobileNumber.sendKeys(Mobilenumber);
	}

	@FindBy(xpath = "//*[@id='Email']")
	WebElement Mzk_Email;

	public void patientEmailId(String email) {
		Mzk_Email.sendKeys(email);
	}

	@FindBy(xpath = "//select[@id='Accesslevel']")
	WebElement Mzk_Accesslevel;

	public void Accesslevel() {
		Select select = new Select(Mzk_Accesslevel);
		select.selectByVisibleText("Full");
	}

	@FindBy(xpath = "//*[@id='Submit']")
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

	@FindBy(xpath = "//*[@id='ProxyMember']")
	WebElement Mzk_ProxyMemberButton;

	public void ProxyMember() {
		Mzk_ProxyMemberButton.click();
	}

}
