package com.ui.runner;

import org.testng.TestNG;

import com.main.utils.ConfigDetails;
import com.main.utils.ScenariosSelector;

public class TestRunner {

	public static void main(String[] args) {
		
		System.out.println("Execution Started..............");
		String strConfigFile="";
		String strSingleTagName="";
		ConfigDetails.setConfigPath(strConfigFile);
		
		
		ScenariosSelector scenariosSelector=new ScenariosSelector();
		scenariosSelector.creatorSelector(strSingleTagName);
		
		TestNG testSuite=new TestNG();
		testSuite.setTestClasses(new Class[] {com.ui.runner.UITestNgExecution.class});
		testSuite.setUseDefaultListeners(false);
		testSuite.run();
	

	}

}
