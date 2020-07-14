package com.reusableComponents;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.excel.utility.Xls_Reader;
import com.pageobjects.ProvisioningReqPage;
import com.resources.base;

import reusableMethods.Utilities;

public class ProRequestMethods extends base {

	Xls_Reader inputValues = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\InputValuesForDSP.xlsx");

	public WebDriver verifyProReqRespStatusAsProcessed(WebDriver driver) {

		ProvisioningReqPage objProReqPage = new ProvisioningReqPage(driver);
		Utilities.highlight(objProReqPage.getProReqStatus());
		String statusProReq = objProReqPage.getProReqStatus().getText();
		Assert.assertEquals(inputValues.getCellData("ProRequest", "detail", 2), statusProReq);
		return driver;

	}

	public WebDriver verifyProReqRespStatusAsProcessedWithLoopback(WebDriver driver) {

		ProvisioningReqPage objProReqPage = new ProvisioningReqPage(driver);
		Utilities.highlight(objProReqPage.getProReqStatus());
		String statusProReq = objProReqPage.getProReqStatus().getText();
		Assert.assertEquals(inputValues.getCellData("ProRequest", "detail", 3), statusProReq);
		return driver;

	}

	public WebDriver verifyProReqRespStatusAsError(WebDriver driver) {

		ProvisioningReqPage objProReqPage = new ProvisioningReqPage(driver);
		Utilities.highlight(objProReqPage.getProReqStatus());
		String statusProReq = objProReqPage.getProReqStatus().getText();
		Assert.assertEquals(inputValues.getCellData("ProRequest", "detail", 4), statusProReq);
		return driver;

	}

	public WebDriver verifyProReqRespStatusAsDeviceCommunicationfailure(WebDriver driver) {

		ProvisioningReqPage objProReqPage = new ProvisioningReqPage(driver);
		Utilities.highlight(objProReqPage.getProReqStatus());
		String statusProReq = objProReqPage.getProReqStatus().getText();
		Assert.assertEquals(inputValues.getCellData("ProRequest", "detail", 5), statusProReq);
		return driver;

	}

}
