package com.reusableComponents;

import org.openqa.selenium.WebDriver;

import com.excel.utility.Xls_Reader;
import com.pageobjects.CreateTestProcessFlowPage;
import com.resources.base;

import reusableMethods.Utilities;

public class CreateTestProcessFlowMethods extends base {

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");
	CreateTestProcessFlowPage objCTPFP = new CreateTestProcessFlowPage(driver);
	
	
	public WebDriver createTestProcessFlow(WebDriver driver, int row) {

		
		Utilities.highlight(objCTPFP.getINP_IMSI());
		objCTPFP.getINP_IMSI().sendKeys(objTestData.getCellData("TestCaseData", "sb_imsi", row));
		Utilities.highlight(objCTPFP.getINP_KI());
		objCTPFP.getINP_KI().sendKeys(objTestData.getCellData("TestCaseData", "sb_ki", row));
		Utilities.highlight(objCTPFP.getINP_K4());
		objCTPFP.getINP_K4().sendKeys(objTestData.getCellData("TestCaseData", "sb_k4sno", row));
		Utilities.highlight(objCTPFP.getINP_CATEGORY());
		objCTPFP.getINP_CATEGORY().sendKeys(objTestData.getCellData("TestCaseData", "sb_category", row));
		Utilities.highlight(objCTPFP.getINP_SUB_CATEGORY());
		objCTPFP.getINP_SUB_CATEGORY().sendKeys(objTestData.getCellData("TestCaseData", "sb_sub_category", row));
		Utilities.highlight(objCTPFP.getCreateBtn());
		objCTPFP.getCreateBtn().click();
		
		return driver;

	}

}