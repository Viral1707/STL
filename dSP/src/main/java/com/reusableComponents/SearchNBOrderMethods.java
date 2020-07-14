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

	Xls_Reader abc = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\TCsSingleCommandExecution.xlsx");

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
	
	public WebDriver verifyProvisioningResponseCode(WebDriver driver, String TestCaseName) throws InterruptedException {
		
		
		int row = 1;

		if (TestCaseName.equalsIgnoreCase(abc.getCellData("TestCasesData", "TestCaseName", 2))) {
			row = 2;
		} else if (TestCaseName.equalsIgnoreCase(abc.getCellData("TestCasesData", "TestCaseName", 3))) {
			row = 3;
		} else if (TestCaseName.equalsIgnoreCase(abc.getCellData("TestCasesData", "TestCaseName", 4))) {
			row = 4;
		} else if (TestCaseName.equalsIgnoreCase(abc.getCellData("TestCasesData", "TestCaseName", 5))) {
			row = 5;
		} else if (TestCaseName.equalsIgnoreCase(abc.getCellData("TestCasesData", "TestCaseName", 6))) {
			row = 6;
		} else if (TestCaseName.equalsIgnoreCase(abc.getCellData("TestCasesData", "TestCaseName", 7))) {
			row = 7;
		} else if (TestCaseName.equalsIgnoreCase(abc.getCellData("TestCasesData", "TestCaseName", 8))) {
			row = 8;
		} else if (TestCaseName.equalsIgnoreCase(abc.getCellData("TestCasesData", "TestCaseName", 9))) {
			row = 9;
		}

		Utilities.highlight(objSODSP.getStatusProvisioningResponse());
		String statusProvisioningResponse = objSODSP.getStatusProvisioningResponse().getText();
		System.out.println(statusProvisioningResponse);
		Assert.assertEquals(statusProvisioningResponse, abc.getCellData("TestCasesData", "statusProvisioningResponse", row));
		return driver;

	}
	
	
	

}
