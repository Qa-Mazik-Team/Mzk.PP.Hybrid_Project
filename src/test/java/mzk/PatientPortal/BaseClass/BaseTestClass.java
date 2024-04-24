package mzk.PatientPortal.BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import mzk.portal.utils.Readfile;

public class BaseTestClass {

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public static RemoteWebDriver dr;
	@BeforeSuite
	public void initBrowser() throws Throwable {

		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get().get(Readfile.getInstance().getUrl()); 
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	@AfterSuite
	public void tearDown() {
		driver.get().quit();
	}
}
