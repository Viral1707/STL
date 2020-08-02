package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class SearchSBDevicePage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public SearchSBDevicePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By sbDeviceName = By.xpath(readerXpath.getCellData("SearchSBDevice", "detail", 3));

	public WebElement getSBDeviceName() {
		return driver.findElement(sbDeviceName);
	}
	
	By protocolDropdown = By.xpath(readerXpath.getCellData("SearchSBDevice", "detail", 4));

	public WebElement getProtocolDropdown() {
		return driver.findElement(protocolDropdown);
	}
	
	By protocolDropdownOption = By.xpath(readerXpath.getCellData("SearchSBDevice", "detail", 5));

	public List<WebElement> getProtocolDropdownOption() {
		return driver.findElements(protocolDropdownOption);
	}
	
	By searchBtn = By.xpath(readerXpath.getCellData("SearchSBDevice", "detail", 6));

	public WebElement getSearchBtn() {
		return driver.findElement(searchBtn);
	}
	
	By editFirstSBDevice = By.xpath(readerXpath.getCellData("SearchSBDevice", "detail", 9));

	public WebElement getEditFirstSBDevice() {
		return driver.findElement(editFirstSBDevice);
	}
	
	By openCommandList = By.xpath(readerXpath.getCellData("SearchSBDevice", "detail", 10));

	public WebElement getopenCommandList() {
		return driver.findElement(openCommandList);
	}
	
	
}
