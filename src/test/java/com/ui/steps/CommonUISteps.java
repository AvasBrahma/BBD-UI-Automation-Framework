package com.ui.steps;

import com.main.actions.CommonUIActions;

import io.cucumber.java.en.Given;

public class CommonUISteps {
    
	CommonUIActions commonUIAct=new CommonUIActions();
	
	@Given("^Setup and Driver$")
	public void setupDriver() {
		System.out.println("Inside Step Definition");
	}
	
	
	
	
}
