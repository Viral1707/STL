package com.reusableComponents;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.pageobjects.CommandListPage;
import com.pageobjects.nbReqTrackDetails;
import com.resources.base;

import reusableMethods.Utilities;

public class CommandListMethods extends base {

	nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");
	CommandListPage objCLP = new CommandListPage(driver);
	public WebDriver searchAndOpenCommand(WebDriver driver, int row) throws InterruptedException {

		
		Utilities.highlight(objCLP.getCommandName());
		objCLP.getCommandName().sendKeys(objTestData.getCellData("TestCaseData", "searchCommandName", row));
		Utilities.highlight(objCLP.getSearchCommand());
		objCLP.getSearchCommand().click();
		Thread.sleep(3000);
		Utilities.highlight(objCLP.getEditCommand());
		objCLP.getEditCommand().click();

		return driver;

	}
	
public WebDriver searchCommand(WebDriver driver, int row) throws InterruptedException {

		objCLP.getCommandName().clear();
		Utilities.highlight(objCLP.getCommandName());
		objCLP.getCommandName().sendKeys(objTestData.getCellData("TestCaseData", "searchCommandName", row));
		Utilities.highlight(objCLP.getSearchCommand());
		objCLP.getSearchCommand().click();
		Thread.sleep(3000);

		return driver;

	}
	
	
	public WebDriver activateReactivateCommandDBLookupYes(WebDriver driver, int row) {
		Utilities.highlight(objCLP.getActivateBtn());
		objCLP.getActivateBtn().click();
		/*
		if (objCLP.getActivateBtn().isDisplayed()) {
			Utilities.highlight(objCLP.getActivateBtn());
			objCLP.getActivateBtn().click();	
		}
		else if(objCLP.getReactivateBtn().isDisplayed()) {
			Utilities.highlight(objCLP.getReactivateBtn());
			objCLP.getReactivateBtn().click();	
		}*/
		Utilities.highlight(objCLP.getYesDBLookup());
		objCLP.getYesDBLookup().click();
		Utilities.highlight(objCLP.getDBLookupDropdown());
		objCLP.getDBLookupDropdown().click();
		
		List<WebElement> dbLookupTableNameList = objCLP.getDBLookupOptions();
		System.out.println("Lookup Taple List Size" + dbLookupTableNameList.size());
		int z;
		for (z = 0; z < dbLookupTableNameList.size(); z++) {
			Utilities.highlight(dbLookupTableNameList.get(z));
			System.out.println(dbLookupTableNameList.get(z));
			String Value_TableNameList = dbLookupTableNameList.get(z).getText().trim();
			System.out.println(Value_TableNameList);
			System.out.println("Excel Data : " + objTestData.getCellData("TestCaseData", "DBLookuptable", row));
			if (Value_TableNameList.equals(objTestData.getCellData("TestCaseData", "DBLookuptable", row))) {
				System.out.println(dbLookupTableNameList.get(z));
				Utilities.highlight(dbLookupTableNameList.get(z));
				dbLookupTableNameList.get(z).click();
				break;
			}

		}

		Utilities.highlight(objCLP.getSubmitBtn());
		objCLP.getSubmitBtn().click();
		objCLP.getOKBtn().click();

		return driver;

	}
	
	
	public WebDriver activateReactivateCommandDBLookupNo(WebDriver driver, int row) {
		Utilities.highlight(objCLP.getActivateBtn());
		objCLP.getActivateBtn().click();
		
		Utilities.highlight(objCLP.getNoDBLookup());
		objCLP.getNoDBLookup().click();
		Utilities.highlight(objCLP.getDBLookupDropdown());
		objCLP.getDBLookupDropdown().click();
	

		Utilities.highlight(objCLP.getSubmitBtn());
		objCLP.getSubmitBtn().click();
		objCLP.getOKBtn().click();

		return driver;

	}

}
