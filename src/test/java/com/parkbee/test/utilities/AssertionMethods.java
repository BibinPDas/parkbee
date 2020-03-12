package com.parkbee.test.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AssertionMethods extends SelectElementByType {

	private WebElement element = null;

	public String getPageTitle() {
		return driver.getTitle();
	}

	public void checkTitle(String title, boolean testCase) throws TestCaseFailed {
		String pageTitle = getPageTitle();
		System.out.println("Page Title" + pageTitle);
		if (testCase) {
			if (!pageTitle.equals(title))
				throw new TestCaseFailed(
						"Page Title not matching,Given " + title + " Actual Page Title : " + pageTitle);

		} else {
			if (pageTitle.equals(title))
				throw new TestCaseFailed("Page Title  matching,Given " + title + " Actual Page Title : " + pageTitle);
		}

	}
	
	public String getElementText(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getText();
		
	}
	
	public void checkElementText(String accessType,String actualValue,String accessName,boolean testCase) throws TestCaseFailed
	{
		String elementText = getElementText(accessType, accessName);
		if (testCase)
		{
			if (!elementText.equals(actualValue))
				throw new TestCaseFailed("Given text "+actualValue+",actual text "+elementText+", Text Not Matched");
		}
		else
		{
			if (elementText.equals(actualValue))
				throw new TestCaseFailed("Given text "+actualValue+",actual text "+elementText+", Text  Matched");
		}
	}
	
	public void click(String accessType, String accessName)
	{
		element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		element.click();
	}
}
