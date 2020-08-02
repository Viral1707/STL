package com.reusableComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.pageobjects.SingleCommandExecutionPage;
import com.resources.base;

import reusableMethods.Utilities;

public class singleCommandExecutionMethods extends base {

	Xls_Reader inputValues = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\InputValuesForDSP.xlsx");

	Xls_Reader objTestData = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	SingleCommandExecutionPage objSCEP = new SingleCommandExecutionPage(driver);

	public WebDriver invokeSingleCommand(WebDriver driver, int row) throws InterruptedException {

		Utilities.highlight(objSCEP.getDeviceName());
		objSCEP.getDeviceName().click();
		List<WebElement> listOfDevices = objSCEP.getListDevice();
		int i;
		System.out.println("Excel Data" + objTestData.getCellData("TestCaseData", "DeviceName", row));
		for (i = 0; i < listOfDevices.size(); i++) {
			String device_name = listOfDevices.get(i).getText().trim();
			if (device_name.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "DeviceName", row))) {
				Utilities.highlight(listOfDevices.get(i));
				listOfDevices.get(i).click();
				break;
			}

		}

		
		Thread.sleep(5000);
		Utilities.highlight(objSCEP.getCommand());
		objSCEP.getCommand().click();
		List<WebElement> listOfCommands = objSCEP.getListCommand();
		int j;
		for (j = 0; j < listOfCommands.size(); j++) {
			String command_name = listOfCommands.get(j).getText().trim();
			if (command_name.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "Command", row))) {
				Utilities.highlight(listOfCommands.get(j));
				listOfCommands.get(j).click();
				break;
			}

		}

		
		Thread.sleep(5000);
		Utilities.highlight(objSCEP.getPriorityLevel());
		objSCEP.getPriorityLevel().click();
		List<WebElement> listOfPriority = objSCEP.getListPriorityLevel();
		int k;
		for (k = 0; k < listOfPriority.size(); k++) {
			String priority = listOfPriority.get(k).getText().trim();
			if (priority.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "PriorityLevel", row))) {
				Utilities.highlight(listOfPriority.get(k));
				listOfPriority.get(k).click();
				break;
			}

		}

		Utilities.highlight(objSCEP.getSingleCommandInvocationBtn());
		objSCEP.getSingleCommandInvocationBtn().click();

		List<WebElement> lable = objSCEP.getLable();
		List<WebElement> lableValue = objSCEP.getLabelValue();
		int z;
		for (z = 0; z < lable.size(); z++) {
			Utilities.highlight(lable.get(z));
			String lable_name = lable.get(z).getText().trim();
			Utilities.highlight(lableValue.get(z));
			lableValue.get(z).sendKeys(objTestData.getCellData("TestCaseData", lable_name, row));
		}

		Utilities.highlight(objSCEP.getsubmitBtn());
		objSCEP.getsubmitBtn().click();
		Thread.sleep(5000);
		return driver;

	}

	public WebDriver clickOK(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objSCEP.getOKBtn());
		objSCEP.getOKBtn().click();
		return driver;

	}

	public WebDriver verifyFailedServiceOrderMessage(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objSCEP.getErrorMessage());
		String ErrorMessage = objSCEP.getErrorMessage().toString();
		System.out.println(ErrorMessage);
		ErrorMessage.contentEquals("Please input valid value");
		return driver;

	}

}
