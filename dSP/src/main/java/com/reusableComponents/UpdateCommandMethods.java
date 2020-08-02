package com.reusableComponents;


import org.openqa.selenium.WebDriver;

import com.excel.utility.Xls_Reader;
import com.pageobjects.UpdateCommandPage;
import com.resources.base;

import reusableMethods.Utilities;

public class UpdateCommandMethods extends base {

	UpdateCommandPage objUCP = new UpdateCommandPage(driver);

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	public WebDriver updateCommand(WebDriver driver, int row) throws InterruptedException {

		Utilities.highlight(objUCP.getCommandURL());
		objUCP.getCommandURL().clear();
		objUCP.getCommandURL().sendKeys(objTestData.getCellData("TestCaseData", "CommandURL", row));
		Utilities.highlight(objUCP.getUpdateBtn());
		objUCP.getUpdateBtn().click();
	
		if(objUCP.getUpdateBtn().isEnabled()) {
			Utilities.highlight(objUCP.getUpdateBtnWarningPage());
			objUCP.getUpdateBtnWarningPage().click();
			Thread.sleep(30000);
		}
		Utilities.highlight(objUCP.getOKBtn());
		objUCP.getOKBtn().click();
		return driver;

	}
	
	
	public WebDriver setBackCommand(WebDriver driver, int row) {

		Utilities.highlight(objUCP.getCommandURL());
		objUCP.getCommandURL().clear();
		objUCP.getCommandURL().sendKeys(objTestData.getCellData("TestCaseData", "CommandURL", row));
		Utilities.highlight(objUCP.getUpdateBtn());
		objUCP.getUpdateBtn().click();
		Utilities.highlight(objUCP.getUpdateBtnWarningPage());
		objUCP.getUpdateBtnWarningPage().click();
		Utilities.highlight(objUCP.getOKBtn());
		objUCP.getOKBtn().click();
		return driver;

	}

}
