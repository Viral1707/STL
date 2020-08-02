package com.reusableComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.pageobjects.ProcessFlowCreateScreen;
import com.pageobjects.ServiceOrder;

import com.resources.base;

import reusableMethods.Utilities;

public class ProcessFlowCreateScreenMethods extends base {

	Xls_Reader collectValues = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\CollectedValuesForDSP.xlsx");

	Xls_Reader objTestData = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	ServiceOrder objServiceOrder = new ServiceOrder(driver);
	ProcessFlowCreateScreen objPFCS = new ProcessFlowCreateScreen(driver);

	public WebDriver provideInputFields(WebDriver driver, int row) throws InterruptedException {

		List<WebElement> lable = objPFCS.getInputFieldsLable();
		List<WebElement> lableValue = objPFCS.getInputFieldsValue();
		int z;
		for (z = 0; z < lable.size(); z++) {
			Utilities.highlight(lableValue.get(z));
			String lable_name = lable.get(z).getText().trim();
			lableValue.get(z).sendKeys(objTestData.getCellData("TestCaseData", lable_name, row));
		}

		return driver;

	}
	
	public WebDriver clickOK(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objPFCS.getCreateBtn());
		objPFCS.getCreateBtn().click();
		return driver;

	}

}
