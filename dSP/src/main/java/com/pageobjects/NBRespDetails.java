package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class NBRespDetails extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public NBRespDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By nbResponse = By.xpath(readerXpath.getCellData("NBResponse", "detail", 2));

	public WebElement getNBResponse() {
		return driver.findElement(nbResponse);
	}
	
	By refreshBtn = By.xpath(readerXpath.getCellData("NBResponse", "detail", 3));

	public WebElement getRefreshBtn() {
		return driver.findElement(refreshBtn);
	}
	
}
