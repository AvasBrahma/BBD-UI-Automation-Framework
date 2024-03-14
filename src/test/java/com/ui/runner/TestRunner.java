package com.ui.runner;

import org.testng.TestNG;

import com.main.utils.ConfigDetails;

public class TestRunner {

	public static void main(String[] args) {
		
		System.out.println("Execution Started..............");
		String strConfigFile="";
		ConfigDetails.setConfigPath(strConfigFile);
		
		TestNG testSuite=new TestNG();
		testSuite.setTestClasses(new Class[] {com.ui.runner.UITestNgExecution.class});
		testSuite.setUseDefaultListeners(false);
		testSuite.run();
	

	}

}
