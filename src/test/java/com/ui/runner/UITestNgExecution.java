package com.ui.runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ui.steps.BeforeActions;




@CucumberOptions(	
		features="test-output/common.feature",
		dryRun=false,
		monochrome=true,
		glue= {"com.ui.steps"}
)
public class UITestNgExecution extends AbstractTestNGCucumberTests
{
	public static String strResultConsolidatedFolder="";
	
	
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	@BeforeClass
	public void setup() {
		System.out.println("Setting up Data & Configuration started.......");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmdd_hhmmss");
		Date curDate=new Date();
		String strDate=sdf.format(curDate);
		String strResultFolder=System.getProperty("user.dir")+"/test-output/"+strDate;
		strResultConsolidatedFolder=strResultFolder;
		File fldrResult=new File(strResultConsolidatedFolder);
		fldrResult.mkdir();
		BeforeActions.strResultConsolidatedFolder=strResultConsolidatedFolder;
		System.out.println("Result Folder = " +strResultFolder);
	}
	
	@Test
	public void runTestNg() {
		System.out.println("Running TestNg................");
	}
}
