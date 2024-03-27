package com.ui.steps;

import com.main.actions.CommonUIActions;
import com.main.utils.ConfigDetails;
import com.main.utils.SeleniumDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CommonUISteps {
    
	CommonUIActions commonUIAct=new CommonUIActions();
	
	@Given("^Navigate to the URL \"([^\"]*)\"$")
	public void navigateToURL(String strURLName) {
		String strURL=ConfigDetails.getPropValue(strURLName);
		commonUIAct.enterURL(strURL);
	}
	@And("^Enter the input text for \"([^\"]*)\" as \"([^\"]*)\" in the \"([^\"]*)\" Screen$")
	public void enterInputText(String strTextBoxName, String strTextValue, String strScreenName) {
		commonUIAct.setScreenName("Login");
		commonUIAct.inputTextField(strTextBoxName, strTextValue, strScreenName);
	}
	
	@When("^Click the button for \"([^\"]*)\" in the \"([^\"]*)\" Screen$")
	public void clickTheButton(String strButtonName, String strScreenName) {
		commonUIAct.ClickButton(strButtonName, strScreenName);
	}
	
	
	
	@After
	public void tearDown() {
		System.out.println("Tear Down - Quit Driver......................");
		if(SeleniumDriver.getDriver()!=null) {
			SeleniumDriver.getDriver().quit();
			System.out.println("Driver Quit....");
		}
	}
}
