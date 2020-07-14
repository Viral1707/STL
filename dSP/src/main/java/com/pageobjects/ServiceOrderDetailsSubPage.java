package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class ServiceOrderDetailsSubPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public ServiceOrderDetailsSubPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By statusProvisioningResponse = By.xpath(readerXpath.getCellData("ServiceOrderDetailsSubPage", "detail", 2));

	public WebElement getStatusProvisioningResponse() {
		return driver.findElement(statusProvisioningResponse);
	}

}
