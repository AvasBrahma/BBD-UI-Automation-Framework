package com.main.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHelper {
	
	
	public static boolean shootCommonEvent(WebElement webEleLocator, String strEvent, String strLocatorName, String strDataInput) {
		boolean blnResult=true;
		Actions actions=new Actions(SeleniumDriver.getDriver());
		String strLogText="";
		if(webEleLocator!=null) {
			switch(strEvent)
			{
			case "CLICK":   
				webEleLocator.click();
				strLogText=strLocatorName+ " is Clicked Succuessfully";
				break;
			case "INPUT":
				webEleLocator.clear();
				webEleLocator.sendKeys(strDataInput);
				strLogText=strLocatorName+ " is entered with " + strDataInput + " Succuessfully";
				break;
			case "DOUBLECLICK":
				actions.doubleClick(webEleLocator).perform();
                strLogText=strLocatorName+ " is double clicked successfully";
                break;
                
			default:
				break;
			}
		}
		
		return blnResult;
	}
	
	public static void ImplicitWait(int intSeconds) {
		try {
			int seconds=intSeconds*1000;
			Thread.sleep(seconds);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
