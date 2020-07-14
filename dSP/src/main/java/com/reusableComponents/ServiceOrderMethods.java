package com.reusableComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.excel.utility.Xls_Reader;
import com.pageobjects.ServiceOrder;

import com.resources.base;

import reusableMethods.Utilities;

public class ServiceOrderMethods extends base {

	Xls_Reader collectValues = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\CollectedValuesForDSP.xlsx");

	Xls_Reader abc = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\TCsSingleCommandExecution.xlsx");

	ServiceOrder objServiceOrder = new ServiceOrder(driver);

	public WebDriver provideInputFields(WebDriver driver, String TestCaseName) throws InterruptedException {

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

		ServiceOrder objServiceOrder = new ServiceOrder(driver);

		List<WebElement> lable = objServiceOrder.getInputFieldsLable();
		List<WebElement> lableValue = objServiceOrder.getInputFieldsValue();
		int z;
		for (z = 0; z < lable.size(); z++) {
			Utilities.highlight(lableValue.get(z));
			String lable_name = lable.get(z).getText().trim();
			lableValue.get(z).sendKeys(abc.getCellData("TestCasesData", lable_name, row));
		}

		return driver;

	}
	
	public WebDriver clickOK(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objServiceOrder.getResubmit());
		objServiceOrder.getResubmit().click();
		return driver;

	}

	
	public WebDriver verifyProvisioninggResponseCodeAs0(WebDriver driver, String TestCaseName) throws InterruptedException {

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
		
		Utilities.highlight(objServiceOrder.getProRespCodeZero());
		Assert.assertEquals(objServiceOrder.getProRespCodeZero(), abc.getCellData("TestCasesData", "statusProvisioningResponse", row));
		return driver;

	}

	

}
