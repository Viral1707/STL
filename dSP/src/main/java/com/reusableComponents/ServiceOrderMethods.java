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

	Xls_Reader objTestData = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	ServiceOrder objServiceOrder = new ServiceOrder(driver);

	public WebDriver provideInputFields(WebDriver driver, int row) throws InterruptedException {

		ServiceOrder objServiceOrder = new ServiceOrder(driver);

		List<WebElement> lable = objServiceOrder.getInputFieldsLable();
		List<WebElement> lableValue = objServiceOrder.getInputFieldsValue();
		int z;
		for (z = 0; z < lable.size(); z++) {
			Utilities.highlight(lableValue.get(z));
			String lable_name = lable.get(z).getText().trim();
			lableValue.get(z).sendKeys(objTestData.getCellData("TestCaseData", lable_name, row));
		}

		return driver;

	}
	
	public WebDriver clickOK(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objServiceOrder.getResubmit());
		objServiceOrder.getResubmit().click();
		return driver;

	}

	
	public WebDriver verifyProvisioninggResponseCodeAs0(WebDriver driver, int row ) throws InterruptedException {

		Utilities.highlight(objServiceOrder.getProRespCodeZero());
		Assert.assertEquals(objServiceOrder.getProRespCodeZero().getText().trim(), objTestData.getCellData("TestCaseData", "ProvisioningResponseCode", row ));
		return driver;

	}

	

}
