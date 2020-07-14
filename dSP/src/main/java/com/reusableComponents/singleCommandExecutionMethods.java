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

	Xls_Reader abc = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\TCsSingleCommandExecution.xlsx");

	SingleCommandExecutionPage objSCEP = new SingleCommandExecutionPage(driver);

	public WebDriver invokeSingleCommand(WebDriver driver, String TestCaseName) throws InterruptedException {

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

		Utilities.highlight(objSCEP.getDeviceName());
		objSCEP.getDeviceName().click();
		List<WebElement> listOfDevices = objSCEP.getListDevice();
		int i;
		for (i = 0; i < listOfDevices.size(); i++) {
			String device_name = listOfDevices.get(i).getText().trim();
			if (device_name.equalsIgnoreCase(abc.getCellData("TestCasesData", "DeviceName", row))) {
				listOfDevices.get(i).click();
				break;
			}

		}

		Utilities.highlight(objSCEP.getCommand());
		objSCEP.getCommand().click();
		List<WebElement> listOfCommands = objSCEP.getListCommand();
		int j;
		for (j = 0; j < listOfCommands.size(); j++) {
			String command_name = listOfCommands.get(j).getText().trim();
			if (command_name.equalsIgnoreCase(abc.getCellData("TestCasesData", "Command", row))) {
				listOfCommands.get(j).click();
				break;
			}

		}

		Utilities.highlight(objSCEP.getPriorityLevel());
		objSCEP.getPriorityLevel().click();
		List<WebElement> listOfPriority = objSCEP.getListPriorityLevel();
		int k;
		for (k = 0; k < listOfPriority.size(); k++) {
			String priority = listOfPriority.get(k).getText().trim();
			if (priority.equalsIgnoreCase(abc.getCellData("TestCasesData", "PriorityLevel", row))) {
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
			String lable_name = lable.get(z).getText().trim();
			lableValue.get(z).sendKeys(abc.getCellData("TestCasesData", lable_name, row));
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

		String ErrorMessage = objSCEP.getErrorMessage().toString();
		System.out.println(ErrorMessage);
		ErrorMessage.contentEquals("Please input valid value");
		return driver;

	}

}
