package com.reusableComponents;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.excel.utility.Xls_Reader;
import com.pageobjects.SearchNBOrder;
import com.pageobjects.ServiceOrderDetailsSubPage;
import com.resources.base;

import reusableMethods.Utilities;

public class SearchNBOrderMethods extends base {

	Xls_Reader collectValues = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\CollectedValuesForDSP.xlsx");

	Xls_Reader objTestData = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	SearchNBOrder objSNBO = new SearchNBOrder(driver);

	ServiceOrderDetailsSubPage objSODSP = new ServiceOrderDetailsSubPage(driver);
	
	public WebDriver searchNBOrderWithNBOrderID(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objSNBO.getNBOrderID());
		objSNBO.getNBOrderID().sendKeys("");
		Utilities.highlight(objSNBO.getSearchBtn());
		objSNBO.getSearchBtn().click();
		return driver;

	}
	
	
	public WebDriver openServiceOrderWithNBOrderID(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objSNBO.getFirstNBOrderID());
		Actions actions = new Actions(driver);
		actions.doubleClick(objSNBO.getFirstNBOrderID()).perform();
		return driver;

	}
	
	public WebDriver verifyProvisioningResponseCode(WebDriver driver, int row) throws InterruptedException {
	
		Utilities.highlight(objSODSP.getStatusProvisioningResponse());
		String statusProvisioningResponse = objSODSP.getStatusProvisioningResponse().getText();
		System.out.println(statusProvisioningResponse);
		Assert.assertEquals(statusProvisioningResponse, objTestData.getCellData("TestCaseData", "statusProvisioningResponse", row));
		return driver;

	}
	
	
	

}
