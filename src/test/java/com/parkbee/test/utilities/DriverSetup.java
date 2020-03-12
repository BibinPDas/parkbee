package com.parkbee.test.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
	private static final WebDriver driver;
	
	static {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		    driver = new ChromeDriver(); 
		    
	}
	
	public static WebDriver getDriver() {
		Runtime.getRuntime().addShutdownHook(new Thread() {
	    	
	    	@Override
	    	public void run() {
	    		driver.quit();
	    	}
	    });
		return driver;
	}
	
}
