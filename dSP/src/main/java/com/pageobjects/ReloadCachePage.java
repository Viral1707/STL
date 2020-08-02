package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class ReloadCachePage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public ReloadCachePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By generalAllCheckbox = By.xpath(readerXpath.getCellData("ReloadCache", "detail", 2));

	public WebElement getGeneralAllCheckbox() {
		return driver.findElement(generalAllCheckbox);
	}

	By reloadCacheBtn = By.xpath(readerXpath.getCellData("ReloadCache", "detail", 3));

	public WebElement getReloadCacheBtn() {
		return driver.findElement(reloadCacheBtn);
	}
	
	By generalTab = By.xpath(readerXpath.getCellData("ReloadCache", "detail", 4));

	public WebElement getGeneralTab() {
		return driver.findElement(generalTab);
	}

	By processFlowTab = By.xpath(readerXpath.getCellData("ReloadCache", "detail", 5));

	public WebElement getProcessFlowTab() {
		return driver.findElement(processFlowTab);
	}

	By processFlowAllCheckbox = By.xpath(readerXpath.getCellData("ReloadCache", "detail", 6));

	public WebElement getProcessFlowAllCheckbox() {
		return driver.findElement(processFlowAllCheckbox);
	}

	By proceedBtn = By.xpath(readerXpath.getCellData("ReloadCache", "detail", 7));

	public WebElement getProceedBtn() {
		return driver.findElement(proceedBtn);
	}

	By OKBtn = By.xpath(readerXpath.getCellData("ReloadCache", "detail", 8));

	public WebElement getOKBtn() {
		return driver.findElement(OKBtn);
	}

}
