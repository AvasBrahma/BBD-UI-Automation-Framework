package com.ui.steps;

import io.cucumber.java.Before;

public class BeforeActions {
	
	public static String strResultConsolidatedFolder="";
	
	@Before
	public void getScenariosName() {
		
		System.out.println("Finding Scenarios Name..............");
	}

}
