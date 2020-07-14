package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class ProvisioningReqPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public ProvisioningReqPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By proReqStatus = By.xpath(readerXpath.getCellData("ProvisioningReq", "detail", 2));

	public WebElement getProReqStatus() {
		return driver.findElement(proReqStatus);
	}


}
