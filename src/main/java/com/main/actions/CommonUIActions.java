package com.main.actions;

import org.openqa.selenium.WebElement;

import com.main.locators.CommonLocators;
import com.main.utils.SeleniumDriver;
import com.main.utils.SeleniumHelper;

public class CommonUIActions {
	
	String strExpectedLogText="";
	String errorLog="";
	CommonLocators commonLocators=null;
	
	public CommonUIActions() {
		this.commonLocators=new CommonLocators();
	}
	public void setScreenName(String strScreenSheetName) {
		if(!strScreenSheetName.trim().isEmpty()) {
			commonLocators.setObjectSheetName(strScreenSheetName);
		}
	}
	
	
	public void enterURL(String strURL) {
		SeleniumDriver.getDriver().get(strURL);
	}
	
	public void inputTextField(String strTextBoxName, String strTextBoxValue, String strScreenName) {
		
		String strElementId="txt"+strTextBoxName.trim()+"In"+strScreenName.trim();
		WebElement  webEle=commonLocators.getElementFromID(strElementId);
		strExpectedLogText="Enter Text For "+ strTextBoxName + "Should be as " +strTextBoxValue;
		if(webEle!=null) {
			webEle.clear();
			SeleniumHelper.shootCommonEvent(webEle, "INPUT", strTextBoxName, strTextBoxValue);
		}else {
			errorLog=strTextBoxName + " Object Unavailable";
		}
		
	}

	public void ClickButton(String strButtonName, String strScreenName) {
		
		String strElementId="btn"+strButtonName.trim()+"In"+strScreenName.trim();
		WebElement  webEle=commonLocators.getElementFromID(strElementId);
		if(webEle!=null) {

			SeleniumHelper.shootCommonEvent(webEle, "CLICK", strButtonName, "");
		}else {
			errorLog=strButtonName + " Object Unavailable";
		}
	}

}
