package com.main.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHelper {
	
	
	public static boolean shootCommonEvent(WebElement webEleLocator, String strEvent, String strLocatorName, String strDataInput) {
		boolean blnResult=true;
		Actions actions=new Actions(SeleniumDriver.getDriver());
		
		
		
		return blnResult;
	}

}
