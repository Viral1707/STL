package com.reusableComponents;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.excel.utility.Xls_Reader;
import com.pageobjects.nbReqTrackDetails;
import com.resources.base;

import reusableMethods.Utilities;

public class nbReqTrackDetailsMethods extends base {

	
	
	public WebDriver clearTime(WebDriver driver) {

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getClearTime());
		nbReqTrackObj.getClearTime().click();
		return driver;

	}

	public WebDriver searchWithNBOrderID(WebDriver driver) {

		Xls_Reader inputValues = new Xls_Reader(
				".\\src\\main\\java\\com\\testdata\\InputValuesForDSP.xlsx");

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getNBOrderID());
		nbReqTrackObj.getNBOrderID().clear();
		nbReqTrackObj.getNBOrderID().sendKeys(inputValues.getCellData("NBReqResp", "detail", 2));
		Utilities.highlight(nbReqTrackObj.getSearchBtn());
		nbReqTrackObj.getSearchBtn().click();
		return driver;

	}

	public WebDriver verifyStatusAsCompleted(WebDriver driver) {

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getStatus());
		String statusNBReq = nbReqTrackObj.getStatus().getText();
		Assert.assertEquals("Completed", statusNBReq);
		return driver;

	}

	public WebDriver searchWithServiceOrderID(WebDriver driver) {

		Xls_Reader inputValues = new Xls_Reader(
				".\\src\\main\\java\\com\\testdata\\InputValuesForDSP.xlsx");

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getServiceOrderID());
		nbReqTrackObj.getServiceOrderID().clear();
		nbReqTrackObj.getServiceOrderID().sendKeys(inputValues.getCellData("NBReqResp", "detail", 3));
		Utilities.highlight(nbReqTrackObj.getSearchBtn());
		nbReqTrackObj.getSearchBtn().click();
		return driver;

	}

	public WebDriver verifyDelveryStatusAsCompleted(WebDriver driver) {

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getDeliveryStatus());
		String deliveryStatusNBReq = nbReqTrackObj.getDeliveryStatus().getText();
		Assert.assertEquals("Completed", deliveryStatusNBReq);
		return driver;

	}

	public WebDriver verifyStatusAsFailed(WebDriver driver) {

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getStatus());
		String statusNBReq = nbReqTrackObj.getStatus().getText();
		Assert.assertEquals("Failed", statusNBReq);
		return driver;

	}

	public WebDriver verifyStatusAsRejected(WebDriver driver) {

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getStatus());
		String statusNBReq = nbReqTrackObj.getStatus().getText();
		Assert.assertEquals("Rejected", statusNBReq);
		return driver;

	}

	public WebDriver verifyStatusAsNonCreated(WebDriver driver) {

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getStatus());
		String statusNBReq = nbReqTrackObj.getStatus().getText();
		Assert.assertEquals("Non Created", statusNBReq);
		return driver;

	}

	public WebDriver verifyStatusAsInProgress(WebDriver driver) {

		nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);
		Utilities.highlight(nbReqTrackObj.getStatus());
		String statusNBReq = nbReqTrackObj.getStatus().getText();
		Assert.assertEquals("In Progress", statusNBReq);
		return driver;

	}

}
