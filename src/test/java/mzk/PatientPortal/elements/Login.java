package mzk.PatientPortal.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mzk.PatientPortal.BaseClass.BaseTestClass;

public class Login extends BaseTestClass {

	private static Login instance = null;

	public Login(RemoteWebDriver remoteWebDriver) {
		PageFactory.initElements(driver.get(), this);
	}

	public static Login getInstance(RemoteWebDriver remoteWebDriver) {
		if (instance == null) {
			instance = new Login(remoteWebDriver);
		}
		return instance;
	}

	@FindBy(xpath = "//*[@id='Email']")
	WebElement Mzk_Email;

	public void PatientEmailAddress(String Pemail) {
		new WebDriverWait(getDriver(), 60)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Email']")));
		try {
			Mzk_Email.sendKeys(Pemail);
		} catch (Exception e) {
			Mzk_Email.sendKeys(Pemail);
		}

	}

	@FindBy(xpath = "//*[@id='login-LoginButton']")
	WebElement Mzk_SendOtpButton;

	public void sendOTP() {
		new WebDriverWait(driver.get(), 20).until(ExpectedConditions.elementToBeClickable(Mzk_SendOtpButton)).click();
	}

	@FindBy(xpath = "//*[@id='codeBox1']")
	WebElement Mzk_codeBox1;

	public void codeOtp1(String Potp1) {
		Mzk_codeBox1.sendKeys(Potp1);
	}

	@FindBy(xpath = "//*[@id='codeBox2']")
	WebElement Mzk_codeBox2;

	public void codeOtp2(String Potp2) {
		Mzk_codeBox2.sendKeys(Potp2);
	}

	@FindBy(xpath = "//*[@id='codeBox3']")
	WebElement Mzk_codeBox3;

	public void codeOtp3(String Potp3) {
		Mzk_codeBox3.sendKeys(Potp3);
	}

	@FindBy(xpath = "//*[@id='codeBox4']")
	WebElement Mzk_codeBox4;

	public void codeOtp4(String Potp4) {
		Mzk_codeBox4.sendKeys(Potp4);
	}

	@FindBy(xpath = "//*[@id='codeBox5']")
	WebElement Mzk_loginButton;

	public WebElement login() {
		return Mzk_loginButton;
	}

	public void loginButton() {
		Mzk_loginButton.click();
	}

	@FindBy(xpath = "//h3[@class='ms-2']")
	WebElement Mzk_profileButton;

	public WebElement getProfile() {
		return Mzk_profileButton;

	}
	
	@FindBy(xpath = "//h4[text()]")
	WebElement Mzk_ProfileName;
	 
	public WebElement getProfileName() {
		return Mzk_ProfileName;
	}
	
	@FindBy(xpath = "//a[text()='New User ? Sign up here']")
	WebElement Mzk_Signup;
	 
	public WebElement getSignUp() {
		return Mzk_Signup;
	}
}
