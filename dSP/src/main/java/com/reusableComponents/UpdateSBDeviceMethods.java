package com.reusableComponents;



import org.openqa.selenium.WebDriver;

import com.excel.utility.Xls_Reader;
import com.pageobjects.UpdateSBDevicePage;
import com.pageobjects.nbReqTrackDetails;
import com.resources.base;

import reusableMethods.Utilities;

public class UpdateSBDeviceMethods extends base {

	nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	public WebDriver updateProvisioningURL(WebDriver driver, int row) {

		UpdateSBDevicePage objUSBDP = new UpdateSBDevicePage(driver);
		Utilities.highlight(objUSBDP.getProvisioningURL());
		objUSBDP.getProvisioningURL().clear();
		objUSBDP.getProvisioningURL().sendKeys(objTestData.getCellData("TestCaseData", "provisioningURL", row));
		Utilities.highlight(objUSBDP.getUpdateBtn());
		objUSBDP.getUpdateBtn().click();
		objUSBDP.getUpdateBtnWarningPage().click();
		objUSBDP.getOKBtn().click();
		return driver;

	}
	
	
	public WebDriver setBackProvisioningURL(WebDriver driver, int row) {

		UpdateSBDevicePage objUSBDP = new UpdateSBDevicePage(driver);
		Utilities.highlight(objUSBDP.getProvisioningURL());
		objUSBDP.getProvisioningURL().clear();
		objUSBDP.getProvisioningURL().sendKeys(objTestData.getCellData("TestCaseData", "originalProvisioningURL", row));
		Utilities.highlight(objUSBDP.getUpdateBtn());
		objUSBDP.getUpdateBtn().click();
		objUSBDP.getUpdateBtnWarningPage().click();
		objUSBDP.getOKBtn().click();
		return driver;

	}

}
