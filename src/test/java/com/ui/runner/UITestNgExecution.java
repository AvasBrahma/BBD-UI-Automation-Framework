package com.ui.runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.main.utils.ScenariosSelector;
import com.ui.steps.BeforeActions;

public class UITestNgExecution {
	
	public static String strResultConsolidatedFolder="";
	ScenariosSelector scenariosSelector=new ScenariosSelector();
	
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
  public void f() {
	  System.out.println("Test Started............");
	  scenariosSelector.RunSelector();
  }
}
