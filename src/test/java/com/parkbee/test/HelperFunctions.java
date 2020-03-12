package com.parkbee.test;

import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.parkbee.test.utilities.DriverSetup;
import com.parkbee.test.utilities.ElementProperties;
import com.parkbee.test.utilities.ScreenShot;
import com.parkbee.test.utilities.SelectElementByType;

import cucumber.api.Scenario;

public class HelperFunctions extends SelectElementByType {

	private static final WebDriver driver = DriverSetup.getDriver();
	private final SelectElementByType elements = new SelectElementByType();
	private WebElement element = null;
	String parkbeerate;
	private final ScreenShot screenshot = new ScreenShot();

	public void getURL(String url) {
		driver.get(url);
	}

	public void closeBrowser() {
		driver.quit();
	}

	public void entertoInputField(String arg1, String arg2) {

		String[] elementsAcess = splitAndGet(arg1);

		driver.findElement(elements.getelementbytype(elementsAcess[0], elementsAcess[1])).sendKeys(arg2);

	}

	public void takeScreenshot(Scenario scenario) {
		screenshot.addScreenshotTestreport(scenario);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public boolean valid_locator_type(String type) {
		return Arrays.asList("id", "class", "css", "name", "xpath").contains(type);
	}

	public void validateLocator(String type) throws Exception {
		if (!valid_locator_type(type))
			throw new Exception("Invalid locator type - " + type);
	}
	
	public void getRate(String rate) throws Exception
	{
		String[] KeyAccess = splitAndGet(rate);
		validateLocator(KeyAccess[0]);
		WebElement parkrate=driver.findElement(elements.getelementbytype(KeyAccess[0], KeyAccess[1]));
		parkbeerate = parkrate.getText();
	}
	
	public void scrollToElement(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType,accessName)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", element);
	}

	public String[] splitAndGet(String key) {

		String[] keyAccess = new String[2];
		String value = ElementProperties.get(key);
		keyAccess[0] = value.substring(0, value.indexOf(",")).trim();
		keyAccess[1] = value.substring(value.indexOf(",") + 1).trim();
		return keyAccess;

	}
}
