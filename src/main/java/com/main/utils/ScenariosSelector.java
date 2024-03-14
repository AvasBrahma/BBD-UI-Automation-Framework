package com.main.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ScenariosSelector {
	
	
	public void RunSelector() {
		ConfigDetails.setConfigPath("");
		creatorSelector("");
	}

	private void creatorSelector(String strStringTagName) {
		  
		System.out.println(" Selection of Scenarios Progress......................");
		List<String> lstScenarios=null;
		if(strStringTagName.isEmpty()) {
			lstScenarios=GetScenarios("Scenarios", "Scenarios");
		}else {
			lstScenarios=new ArrayList<String>();
			lstScenarios.add(strStringTagName);
			
		}
		
	}
	
	public void readFeatureFile() {
		String strFeatureFilePath=System.getProperty("user.dir")+"/"+ConfigDetails.getPropValue("FeatureFilesPath");
		File folder=new File(strFeatureFilePath);
		File[] listOfFiles=folder.listFiles();
		for(File flFeature: listOfFiles) {
			if(flFeature.isFile()) {
				
			}
		}
	}

	private List<String> GetScenarios(String strTableName, String strColumnName) {
		
		String strValue="";
		List<String> lstColumnValues=new ArrayList<String>();
		
		Fillo fillo=new Fillo();
		String strPath=System.getProperty("user.dir");
		try {
			Connection connection;
			String strTestDataPath=strPath+"/"+ConfigDetails.getPropValue("TestDataXLS_FilePath");
			connection=fillo.getConnection(strTestDataPath);
			
			String strQuery="Select * from " + strTableName + " Where ToBeExecuted ='Y'";
			Recordset recordset=connection.executeQuery(strQuery);
			int intIndex=0;
			while(recordset.next()) {
				strValue=recordset.getField(strColumnName);
				lstColumnValues.add(intIndex, strValue);
				intIndex++;
			}
			
			recordset.close();
			connection.close();
			fillo=null;
			
		} catch (Exception e) {
			System.out.println("Error in Fillo Table Connection.....");
		}
		return lstColumnValues;
	}

}
