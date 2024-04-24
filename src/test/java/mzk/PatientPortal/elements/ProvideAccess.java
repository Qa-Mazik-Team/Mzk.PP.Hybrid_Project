package mzk.PatientPortal.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import mzk.PatientPortal.BaseClass.BaseTestClass;

public class ProvideAccess extends BaseTestClass {

	private static ProvideAccess instance = null;

	public ProvideAccess(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static ProvideAccess getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new ProvideAccess(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//a[@href='profile']")
	WebElement Mzk_profileButton;

	public void profilebutton() {
		Mzk_profileButton.click();
	}

	@FindBy(xpath = "//*[@id='ProvideAccess']")
	WebElement Mzk_ProvideAccessButton;

	public void ProvideAccessButton() {
		Mzk_ProvideAccessButton.click();
	}

	@FindBy(xpath = "(//*[@id='continue'])[1]")
	WebElement Mzk_ContinueButton;

	public void ContinueButton() {
		try {
			new WebDriverWait(driver.get(), 20)
			.until(ExpectedConditions.elementToBeClickable(Mzk_ContinueButton)).click();
		} catch (Exception e) {
			Mzk_ContinueButton.sendKeys(Keys.RETURN);
		}
		
	}

	@FindBy(xpath = "//*[@id='Email']")
	WebElement Mzk_Email;

	public void Email(String emailid) {
		Mzk_Email.sendKeys(emailid);
	}

	@FindBy(xpath = "//*[@id='confirmemail']")
	WebElement Mzk_Confirmemail;

	public void confirmemail(String Conemailid) {
		Mzk_Confirmemail.sendKeys(Conemailid);
	}

	@FindBy(xpath = "//*[@id='contactname']")
	WebElement Mzk_Contactname;

	public WebElement getContactname() {
		return Mzk_Contactname;

	}

	public void contactname() {
		Mzk_Contactname.click();
	}

	@FindBy(xpath = "//select[@id='Accesslevel']")
	WebElement Mzk_Accesslevel;

	public void Accesslevel() {
		Select select = new Select(Mzk_Accesslevel);
		select.selectByVisibleText("Full");
	}

	@FindBy(xpath = "//*[@id='Relationship']")
	WebElement Mzk_Relationship;

	public void Relationship() {
		Mzk_Relationship.clear();

		String[] relationship = { "Aunty" };

		for (String R : relationship) {
			Mzk_Relationship.sendKeys(R, Keys.ARROW_DOWN, Keys.ENTER);
		}
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
