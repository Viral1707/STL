package com.reusableComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.excel.utility.Xls_Reader;
import com.pageobjects.NBRespDetails;
import com.pageobjects.NBSimulatorAddRequest;
import com.pageobjects.UpdateSystemParametersPage;
import com.resources.base;

import reusableMethods.Utilities;

public class UpdateSystemParametersMethods extends base {

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	NBSimulatorAddRequest objNBSAR = new NBSimulatorAddRequest(driver);
	UpdateSystemParametersPage objUSPP = new UpdateSystemParametersPage(driver);

	public WebDriver switchToGeneralTab(WebDriver driver) {

		Utilities.highlight(objUSPP.getGeneralTab());
		objUSPP.getGeneralTab().click();

		return driver;

	}

	public WebDriver selectLoopbackStatus(WebDriver driver, int row) throws InterruptedException {

		Utilities.highlight(objUSPP.getLoopbackStatusDropdown());
		objUSPP.getLoopbackStatusDropdown().click();

		List<WebElement> loopbackStatusList = objUSPP.getvaluesLoopbackStatusDropdown();
		System.out.println("DataType List Size" + loopbackStatusList.size());
		int z;
		for (z = 0; z < loopbackStatusList.size(); z++) {
			Utilities.highlight(loopbackStatusList.get(z));
			String Value_LoopbackStatusList = loopbackStatusList.get(z).getText().trim();
			if (Value_LoopbackStatusList.equals(objTestData.getCellData("TestCaseData", "LoopbackStatus", row))) {
				Utilities.highlight(loopbackStatusList.get(z));
				loopbackStatusList.get(z).click();
				break;
			}

		}
		return driver;
	}

	
	
	
	public WebDriver selectIntellzaConfigStatus(WebDriver driver, int row) throws InterruptedException {

		Utilities.highlight(objUSPP.getIntellzaConfigStatusDropdown());
		objUSPP.getIntellzaConfigStatusDropdown().click();

		List<WebElement> intellzaConfigStatusList = objUSPP.getvaluesIntellzaConfigStatusDropdown();
		System.out.println("DataType List Size" + intellzaConfigStatusList.size());
		int z;
		for (z = 0; z < intellzaConfigStatusList.size(); z++) {
			Utilities.highlight(intellzaConfigStatusList.get(z));
			String Value_LoopbackStatusList = intellzaConfigStatusList.get(z).getText().trim();
			if (Value_LoopbackStatusList.equals(objTestData.getCellData("TestCaseData", "IntellzaConfigStatus", row))) {
				Utilities.highlight(intellzaConfigStatusList.get(z));
				intellzaConfigStatusList.get(z).click();
				break;
			}

		}
		return driver;
	}
	
	
	public WebDriver saveUpdatedSystemPara(WebDriver driver) {

		Utilities.highlight(objUSPP.getSaveBtn());
		objUSPP.getSaveBtn().click();

		return driver;

	}
	
	
	
	
	
}