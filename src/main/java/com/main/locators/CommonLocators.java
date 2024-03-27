package com.main.locators;

import java.util.ArrayList;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.main.utils.ConfigDetails;
import com.main.utils.SeleniumDriver;

public class CommonLocators {
	
	Hashtable<String, String> commonObjects=null;
	static String strObjectSheetName="";
	String errorLog="";
	
	public CommonLocators() {
		strObjectSheetName="Common";
	}
	public void setObjectSheetName(String strSheetName) {
		if(!strSheetName.equalsIgnoreCase(strObjectSheetName)) {
			strObjectSheetName=strSheetName;
			commonObjects=GetObjectData(strObjectSheetName);
		}
	}
	
	public WebElement getElementFromID(String strObjectId) {
		return GetElementFromId(strObjectId, strObjectSheetName);
	}

	public WebElement GetElementFromId(String strObjectId, String strScreenName) {
		WebElement objEelement=null;
		if(!strScreenName.equalsIgnoreCase(strObjectSheetName)) {
			strObjectSheetName=strScreenName;
			commonObjects=GetObjectData(strObjectSheetName);
		}
		
		if(commonObjects.contains(strObjectId)) {
		   String strXPath=commonObjects.get(strObjectId);
		   try {
			   objEelement=SeleniumDriver.getDriver().findElement(By.xpath(strXPath));
		} catch (Exception e) {}
		   if(objEelement==null) {
			   errorLog="Not able to find the XPath "+strXPath+ " Of Object "+ strObjectId;
			   System.out.println(errorLog);
		   }
		   
		}else {
			   errorLog="Not able to find Data in Locators Test Data for "+ strObjectId;
			   System.out.println(errorLog);
		}
		return null;
	}

	public Hashtable<String, String> GetObjectData(String strSheetName) {
		Fillo fillo=new Fillo();
		Hashtable<String,String> htblObjectData=new Hashtable<String, String>();
		Connection connection;
		try {
			String strLocatorsFilePath=System.getProperty("user.dir")+"/"+ConfigDetails.getPropValue("LocatorTestDataPATH");
			connection=fillo.getConnection(strLocatorsFilePath);
			
			ArrayList<String> arrExistingTables=connection.getMetaData().getTableNames();
			if(!arrExistingTables.contains(strSheetName)) {
				return htblObjectData;
			}
			String strQuery="Select * From "+ strSheetName;
			Recordset recordset=connection.executeQuery(strQuery);
			while(recordset.next()) {
				String strObjectName=recordset.getField("ObjectName");
				String strObjectXPATH=recordset.getField("ObjectXPATH");
				
				if(!strObjectName.isEmpty()) {
					strObjectName=strObjectName.toUpperCase();
					htblObjectData.put(strObjectName, strObjectXPATH);
				}
			}
			recordset.close();
			connection.close();
			
			
		} catch (Exception e) {
			connection=null;
			e.printStackTrace();
		}
		return htblObjectData;
	}

}
