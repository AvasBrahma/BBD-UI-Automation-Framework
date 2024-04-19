package com.main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDetails {
	
	public static String strPropertyFilePath="";
	public static Properties propConfig=new Properties();
	
	public static void setConfigPath(String strPath) {
		if(strPath.isEmpty()) {
			strPropertyFilePath=System.getProperty("user.dir")+"/config.properties";
			
		}else {
			strPropertyFilePath=strPath;
		}
	}
	
	public ConfigDetails() {
		
	}
	
	

	public static void getConfigValue() {
		// TODO Auto-generated method stub
		try {
			FileInputStream fisConfig=new FileInputStream(new File(strPropertyFilePath));
			propConfig.load(fisConfig);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getPropValue(String strKey) {
		
		if(propConfig.isEmpty()) {
			getConfigValue();
		}
		String strPropValue="";
		try {
			strPropValue=propConfig.getProperty(strKey);
			
		} catch (Exception e) {
			System.out.println("Expected Value unavailable for " +strKey);
			// TODO: handle exception
		}
		
		return strPropValue;
	}

}
