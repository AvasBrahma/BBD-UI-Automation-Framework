package com.ui.steps;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.main.utils.SeleniumDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeActions {
	
	public static String strResultConsolidatedFolder="";
	private static Scenario scenario;
	
	@Before
	public void getScenariosName(Scenario scenarios) {
		this.scenario=scenarios;
		
		System.out.println("Scenario = " + this.scenario.getName());
        Collection<String> collTags=this.scenario.getSourceTagNames();
        String strTagName="";
        for(Iterator strTags=collTags.iterator(); strTags.hasNext();) {
        	String strTempTag=(String)strTags.next();
        	if(strTempTag.contains("TC"));
        	{
        		strTagName=strTempTag;
        		strTagName=strTagName.replace("Q", "");
        		strTagName=strTagName.trim();
        	}
        }
        
        System.out.println("Scenarios Tag Names = " +this.scenario.getSourceTagNames().toArray()[0]+ " ID : " + this.scenario.getId());
        
        if(!strTagName.isEmpty()) {
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd_hhmmss");
        	Date curDate=new Date();
        	String strDate=sdf.format(curDate);
        	String[] arrTag=strTagName.split("_");
        	String strCurrentTestCaseNumber=arrTag[0]+"_"+arrTag[1]+"_"+arrTag[2];
        	String strResultFolder=strCurrentTestCaseNumber+"_"+strDate;
        	strResultFolder=strResultConsolidatedFolder+"/"+strResultFolder;
            File fldrResult=new File(strResultFolder);
            fldrResult.mkdir();
            //can call to logger class for logging.
            //call get Scenarios Data from Excel and set to HashTable
            
            
            
            
        }
        
	}
	
	@Before
	public static void setUp() {
		SeleniumDriver.setUpDriver();
		
	}

}
