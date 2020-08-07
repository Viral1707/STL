package com.reusableComponents;

import org.openqa.selenium.WebDriver;

import com.excel.utility.Xls_Reader;
import com.pageobjects.SearchTestProcessFlowPage;
import com.resources.base;

import reusableMethods.Utilities;

public class SearchTestProcessFlowMethods extends base {

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");
	SearchTestProcessFlowPage objSTPFP = new SearchTestProcessFlowPage(driver);

	public WebDriver openCreateProcessFlowScreen(WebDriver driver) {

		Utilities.highlight(objSTPFP.getCreateBtn());
		objSTPFP.getCreateBtn().click();

		return driver;

	}

}