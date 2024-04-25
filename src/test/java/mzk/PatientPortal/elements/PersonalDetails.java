package mzk.PatientPortal.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mzk.PatientPortal.BaseClass.BaseTestClass;
import mzk.portal.utils.Selenium_Functions;


public class PersonalDetails extends BaseTestClass {

	private static PersonalDetails instance = null;

	public PersonalDetails(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static PersonalDetails getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new PersonalDetails(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//a[@href='profile']")
	WebElement Mzk_profileButton;

	public void profilebutton() {
		Mzk_profileButton.click();
	}

	
	@FindBy(xpath = "//p[@class='mb-0']")
	WebElement Mzk_PersonalDetails;

	public WebElement getPersonalDetails() {
		return Mzk_PersonalDetails;
	}
	
	@FindBy(xpath = "//*[contains(@name,'dropdownlist')]")
	WebElement Mzk_PreferredLanguage;

	public void PreferredLanguage(String Value) {
		new WebDriverWait(getDriver(), 20)
		.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name,'dropdownlist')]")));
		try {
			Selenium_Functions.scrollIntoView(Mzk_PreferredLanguage, getDriver());
			Mzk_PreferredLanguage.sendKeys(Value);
		} catch (Exception e) {
			Selenium_Functions.scrollIntoView(Mzk_PreferredLanguage, getDriver());
			Mzk_PreferredLanguage.sendKeys(Value);
		}
		
	}

	@FindBy(xpath = "//*[@id='nationality']")
	WebElement Mzk_Nationality;

	public void Nationality() {

		String[] nation = { "Emirati" };
		for (String N : nation) {
			Selenium_Functions.mouseType(getDriver(), Mzk_Nationality, N);
		}
	}

	@FindBy(xpath = "//*[@id='Citizentype']")
	WebElement Mzk_Citizentype;

	public void Citizentype() {

		String[] Citizen = { "Expat" };

		for (String C : Citizen) {
			Selenium_Functions.mouseType(getDriver(), Mzk_Citizentype, C);
		}
	}

	@FindBy(xpath = "//*[@id='pdADD']")
	WebElement Mzk_Address;

	public void Address(String Value) {

		Selenium_Functions.scrollIntoView(Mzk_Address, getDriver());

		Mzk_Address.clear();
		Mzk_Address.sendKeys(Value);
	}

	@FindBy(xpath = "//*[@id='PresentCountry']")
	WebElement Mzk_PresentCountry;

	public void Countryname() {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].value = '';", Mzk_PresentCountry);
		String[] Country = { "United Arab Emirates" };

		for (String P : Country) {
			Mzk_PresentCountry.sendKeys(P, Keys.ARROW_DOWN, Keys.ENTER);
		}
	}

	@FindBy(xpath = "//*[@id='City']")
	WebElement Mzk_City;

	public void Cityname() {

		String[] city = { "Abu Dhabi" };

		for (String c : city) {
			Selenium_Functions.mouseType(getDriver(), Mzk_City, c);
		}
	}

	@FindBy(xpath = "//*[@id='Area']")
	WebElement Mzk_Area;

	public void Areaname() {
		Mzk_Area.clear();
		String[] area = { "Al Ain City" };

		for (String A : area) {
			Mzk_Area.sendKeys(A, Keys.ARROW_DOWN, Keys.ENTER);
		}
	}

	@FindBy(xpath = "//*[@class='blazored-toast-heading']")
	WebElement Mzk_ToasterTitle;

	public String getToasterTitle() {
		String title = Mzk_ToasterTitle.getText();
		return title;
	}

	@FindBy(xpath = "//p[@class='blazored-toast-message']")
	WebElement Mzk_ToasterMessage;

	public String getToasterMessage() {
		String message = Mzk_ToasterMessage.getText();
		return message;
	}

	@FindBy(xpath = "//*[@class='blazored-toast-container position-bottomright']")
	WebElement Mzk_ToasterImage;

	public WebElement getToasterImage() {
		return Mzk_ToasterImage;
	}

	@FindBy(xpath = "//*[@class='submit mt-2']")
	WebElement Mzk_SaveButton;

	public void save() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Mzk_SaveButton);

	}

	@FindBy(xpath = "//*[@id='EmergencyContact']")
	WebElement Mzk_EmergencyContactButton;

	public void EmergencyContact() {
		Mzk_EmergencyContactButton.click();
	}

	@FindBy(xpath = "//*[@id='flexCheckChecked']")
	WebElement Mzk_flexCheckChecked;

	public void Checkbox() {
		Selenium_Functions.scrollIntoView(Mzk_flexCheckChecked, getDriver());
		new WebDriverWait(driver.get(), 20).
             until(ExpectedConditions.elementToBeClickable(Mzk_flexCheckChecked)).click();
	}

	public WebElement getCheckChecked() {
		return Mzk_flexCheckChecked;

	}
}
