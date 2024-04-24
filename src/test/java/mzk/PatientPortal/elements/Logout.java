package mzk.PatientPortal.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import mzk.PatientPortal.BaseClass.BaseTestClass;

public class Logout extends BaseTestClass {

	private static Logout instance = null;

	public Logout(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static Logout getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new Logout(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//h3[@class='ms-2']")
	WebElement Mzk_profileButton;

	public WebElement getProfile() {
		return Mzk_profileButton;

	}

	@FindBy(xpath = "(//img[@alt='account-logout'])[position()=1]")
	WebElement Mzk_logoutLink;

	public void logoutButton() {
		Mzk_logoutLink.click();
	}

	@FindBy(xpath = "//*[@id=\"yes\"]")
	WebElement Mzk_yesButton;

	public void yesButton() {
		Mzk_yesButton.click();
	}
}
