package mzk.portal.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import mzk.PatientPortal.BaseClass.BaseTestClass;

public class Selenium_Functions extends BaseTestClass {

	public static void flash(WebElement element, WebDriver driver) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changeColor("#000000", element, driver);// 1
			changeColor(bgcolor, element, driver);// 2
		}
	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
		}
	}

	public static void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) getDriver());
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void screenshot(String Filepath) {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File src = ts.getScreenshotAs(OutputType.FILE);
		File tar = new File(Filepath);
		try {
			Files.copy(src, tar);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void explicitwait(WebDriver driver, String Locatorvalue, int timeoutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locatorvalue)));
	}

	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void mouseType(WebDriver driver, WebElement element, String Value) {

		new Actions(driver).moveToElement(element).click().sendKeys(Keys.CONTROL + "a").sendKeys(Keys.DELETE)
				.sendKeys(element, Value).sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
	}

}
