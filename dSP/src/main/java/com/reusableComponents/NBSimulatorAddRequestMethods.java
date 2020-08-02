package com.reusableComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.excel.utility.Xls_Reader;
import com.pageobjects.NBRespDetails;
import com.pageobjects.NBSimulatorAddRequest;
import com.resources.base;

import reusableMethods.Utilities;

public class NBSimulatorAddRequestMethods extends base {

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	NBSimulatorAddRequest objNBSAR = new NBSimulatorAddRequest(driver);

	public String getResponseXML(WebDriver driver) {

		NBRespDetails objNBRespDetails = new NBRespDetails(driver);
		Utilities.highlight(objNBRespDetails.getNBResponse());
		String statusNBReq = objNBRespDetails.getNBResponse().getText();

		return statusNBReq;

	}

	public WebDriver refreshNBResponsePage(WebDriver driver) {

		NBRespDetails objNBRespDetails = new NBRespDetails(driver);
		Utilities.highlight(objNBRespDetails.getRefreshBtn());
		objNBRespDetails.getRefreshBtn().click();

		return driver;

	}

	public void addRequestInNBSimulator(WebDriver driver) {

	}

	public WebDriver provideDataType(WebDriver driver, int row) throws InterruptedException {

		objNBSAR.getDataType().click();
		
		List<WebElement> dataTypeList = objNBSAR.getDataTypeList();
		System.out.println("DataType List Size" + dataTypeList.size());
		int z;
		for (z = 0; z < dataTypeList.size(); z++) {
			Utilities.highlight(dataTypeList.get(z));
			System.out.println(dataTypeList.get(z));
			String Value_dataTypeList = dataTypeList.get(z).getText().trim();
			System.out.println(Value_dataTypeList);
			System.out.println("Excel Data : " + objTestData.getCellData("TestCaseData", "DataType", row));
			if (Value_dataTypeList.equals(objTestData.getCellData("TestCaseData", "DataType", row))) {
				System.out.println(dataTypeList.get(z));
				Utilities.highlight(dataTypeList.get(z));
				dataTypeList.get(z).click();
				break;
			}

		}

		return driver;
	}

	public WebDriver provideQueue(WebDriver driver, int row) throws InterruptedException {

		objNBSAR.getQueueList().click();
		
		List<WebElement> queueList = objNBSAR.getQueueListList();

		int z;
		for (z = 0; z < queueList.size(); z++) {
			Utilities.highlight(queueList.get(z));
			String Value_dataTypeList = queueList.get(z).getText().trim();
			System.out.println("Excel Data : " + objTestData.getCellData("TestCaseData", "QueueList", row));
			if (Value_dataTypeList.equals(objTestData.getCellData("TestCaseData", "QueueList", row))) {
				Utilities.highlight(queueList.get(z));
				queueList.get(z).click();
				break;
			}

		}

		return driver;
	}

	public void addNBRequestInSystem(WebDriver driver, int row) throws InterruptedException {
		
		System.out.println(objTestData.getCellData("TestCaseData", "RequestType", row));

		if (objTestData.getCellData("TestCaseData", "RequestType", row).equals("JMS")) {
			Utilities.highlight(objNBSAR.getRequestTypeJMS());
			objNBSAR.getRequestTypeJMS().click();
		}

		else if (objTestData.getCellData("TestCaseData", "RequestType", row).equals("REST ASYNC")) {
			Utilities.highlight(objNBSAR.getRequestTypeJMS());
			objNBSAR.getRequestTypeRestAsync().click();
		}
		provideDataType(driver, row);
		if (objNBSAR.getQueueList().isDisplayed()) {
			provideQueue(driver, row);
		}
		Utilities.highlight(objNBSAR.getAddRequestTextBox());
		objNBSAR.getAddRequestTextBox().sendKeys(objTestData.getCellData("TestCaseData", "AddRequest", row));
		Utilities.highlight(objNBSAR.getAddBtn());
		objNBSAR.getAddBtn().click();
		Utilities.highlight(objNBSAR.getOKBtn());
		objNBSAR.getOKBtn().click();

	}

	public WebDriver checkSyntaticalError(WebDriver driver) {

		Utilities.highlight(objNBSAR.getSyntaticalError());
		
		String syntaticalError = objNBSAR.getSyntaticalError().getText();
		Assert.assertEquals(syntaticalError, "Please add valid data as per the Data Type.");
		
		return driver;

	}
	
	
	
}
