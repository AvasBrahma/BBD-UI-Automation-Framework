package com.main.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

	public void creatorSelector(String strStringTagName) {
		  
		System.out.println(" Selection of Scenarios Progress......................");
		List<String> lstScenarios=null;
		if(strStringTagName.isEmpty()) {
			lstScenarios=GetScenarios("Scenarios", "Scenarios");
		}else {
			lstScenarios=new ArrayList<String>();
			lstScenarios.add(strStringTagName);
			
		}
		readFeatureFile(lstScenarios);
		
	}
	
	public void readFeatureFile(List<String> lstScenarios) {
		
		String strDirectory=System.getProperty("user.dir")+File.separator+"test-output";
		String strFileName="Bing.feature";
		String strAbsoluteInputPath=strDirectory+File.separator+strFileName;
		String strAbsoluteOutputPath=strDirectory+File.separator+"common.feature";
		boolean blnWriteLine=false;
		
		new File(strAbsoluteOutputPath).delete();
		
		BufferedWriter bufferedWriter=null;
		try {
			
			bufferedWriter=new BufferedWriter(new FileWriter(strAbsoluteOutputPath));
			bufferedWriter.write("Feature: Runtime Feature");
			bufferedWriter.newLine();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		String strFeatureFilePath=System.getProperty("user.dir")+"/"+ConfigDetails.getPropValue("FeatureFilesPath");
		File folder=new File(strFeatureFilePath);
		File[] listOfFiles=folder.listFiles();
		
		for(File flFeature: listOfFiles) {
			if(flFeature.isFile()) {
				String strFilePath=flFeature.getAbsolutePath();
				int intDotIndex=strFilePath.lastIndexOf(".");
				if(intDotIndex>0) {
					String strExtn=strFilePath.substring(intDotIndex+1);
					if(strExtn.equals("feature")) {
						strAbsoluteInputPath=strFilePath;
						try {
							BufferedReader bufferedReader=new BufferedReader(new FileReader(strAbsoluteInputPath));
							String strLine=bufferedReader.readLine();
							while(strLine!=null) {
								if(strLine.contains("@")) {
									blnWriteLine=false;
									if(checkTagsInclude(lstScenarios, strLine)) {
										bufferedWriter.newLine();
										blnWriteLine=true;
									}
								}
								if(blnWriteLine) {
									bufferedWriter.write(strLine);
									bufferedWriter.newLine();
								}
								strLine=bufferedReader.readLine();
							}
							bufferedReader.close();
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
				}
			}
		}
		
		if(bufferedWriter!=null) {
			try {
				bufferedWriter.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private boolean checkTagsInclude(List<String> lstScenarios, String strTagText) {
		boolean blnInclude=false;
		for(int intIndex=0;intIndex<lstScenarios.size();intIndex++) {
			String strScenario=lstScenarios.get(intIndex);
			if(strTagText.contains(strScenario)) {
				blnInclude=true;
				break;
			}
		}
		return blnInclude;
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
