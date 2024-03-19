package com.main.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriver {
	
	
	private static SeleniumDriver seleniumDriver;
	private static WebDriver driver;
	
	private SeleniumDriver()
	{
		
		System.out.println("Setting up Selenium Driver..............");
		String strBrowserName=ConfigDetails.getPropValue("Browser");
		String strChromeDriverPath=ConfigDetails.getPropValue("ChromeDriverPath");
		//String strChromeBinaryPath=ConfigDetails.getPropValue("ChromeBinaryPath");
		if(strBrowserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions chromeOptions=new ChromeOptions();
			chromeOptions.setExperimentalOption("useAutomationExtension", false);
			System.setProperty("webdriver.chrome.driver", strChromeDriverPath);
			//chromeOptions.setBinary(strChromeBinaryPath);
			
			driver=new ChromeDriver(chromeOptions);
		}
	}   
	
	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static void setUpDriver() {
		if(seleniumDriver==null) {
			seleniumDriver=new SeleniumDriver();
		}
	}

}
