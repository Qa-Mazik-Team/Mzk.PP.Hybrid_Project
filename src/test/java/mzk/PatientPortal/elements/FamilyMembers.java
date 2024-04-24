package mzk.PatientPortal.elements;

import java.util.List;

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

public class FamilyMembers extends BaseTestClass {

	private static FamilyMembers instance = null;

	public FamilyMembers(RemoteWebDriver remoteWebDriver) {

		PageFactory.initElements(driver.get(), this);
	}

	public static FamilyMembers getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new FamilyMembers(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//a[@href='profile']")
	WebElement Mzk_profileButton;

	public void profilebutton() {
		Mzk_profileButton.click();
	}

	@FindBy(xpath = "//*[@id='Familymembers']")
	WebElement Mzk_FamilymembersButton;

	public void FamilymembersButton() {
		Mzk_FamilymembersButton.click();
	}

	@FindBy(xpath = "//p[@class='mb-0']")
	WebElement Mzk_FamilyMembers;

	public WebElement getFamilyMembers() {
		return Mzk_FamilyMembers;
	} 

	@FindBy(xpath = "//*[@id='contact-tab']")
	WebElement Mzk_AddMember;

	public void AddMember() {
		Mzk_AddMember.click();
	}

	@FindBy(xpath = "//*[@id='profileFirstName ']")
	WebElement Mzk_firstName;

	public void firstName(String firstname) {
		Mzk_firstName.sendKeys(firstname);
	}

	@FindBy(xpath = "//*[@id='LastName ']")
	WebElement Mzk_lastName;

	public void lastName(String lastname) {
		Mzk_lastName.sendKeys(lastname);
	}

	@FindBy(xpath = "//*[@for='Male']")
	WebElement Mzk_Male;

	public void MaleGender() {
		
		new WebDriverWait(driver.get(), 20).until(ExpectedConditions.elementToBeClickable(Mzk_Male)).click();
	}

	@FindBy(xpath = "//*[@id='RelationshipID']")
	WebElement Mzk_RelationshipID;

	public void Relationship() {
		Mzk_RelationshipID.clear();

		String[] relationship = { "Aunty" };

		for (String R : relationship) {
			Mzk_RelationshipID.sendKeys(R, Keys.ARROW_DOWN, Keys.ENTER);
		}
	}

	@FindBy(xpath = "//*[@id='submitmemberbtn']")
	WebElement Mzk_Submitmemberbtn;

	public void savemember() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", Mzk_Submitmemberbtn);
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

	@FindBy(xpath = "//*[@class='dropdown w-25']")
	WebElement Mzk_MobilrDropdown;

	@FindBy(xpath = "//*[@class='dropdown-content ']/li")
	List<WebElement> AllOptions;

	public void mobiledropedown(String CountryCode) {
		new Actions(getDriver()).clickAndHold(Mzk_MobilrDropdown).perform();

		for (WebElement option : AllOptions) {
			if (option.getText().contains(CountryCode)) {
				option.click();
				System.out.println("clicked");
				break;
			}
		}
	}

	@FindBy(xpath = "//*[@id='mobileNumber']")
	WebElement Mzk_mobileNumber;

	public void mobileNumber(String Mobilenumber) {
		Mzk_mobileNumber.sendKeys(Mobilenumber);
	}
}
