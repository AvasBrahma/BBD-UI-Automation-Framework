package com.main.utils;

import org.openqa.selenium.WebDriver;

public class SeleniumDriver {
	
	
	private static SeleniumDriver seleniumDriver;
	private static WebDriver driver;
	
	private SeleniumDriver()
	{
		
		System.out.println("Setting up Selenium Driver Started...............");
		
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
