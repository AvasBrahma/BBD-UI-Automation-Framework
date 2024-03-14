package com.ui.runner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UITestNgExecution {
	
	public static String strResultConsolidatedFolder="";
	
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
		System.out.println("Result Folder = " +strResultFolder);
	}
	
  @Test
  public void f() {
	  System.out.println("Test Started............");
  }
}
