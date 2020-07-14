package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class Reports extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public Reports(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By nbReqResp = By.xpath(readerXpath.getCellData("reports", "detail", 2));

	public WebElement getNbReqResp() {
		return driver.findElement(nbReqResp);
	}
	
	By nbReqRespTrack = By.xpath(readerXpath.getCellData("reports", "detail", 3));

	public WebElement getNbReqRespTrack() {
		return driver.findElement(nbReqRespTrack);
	}

}
