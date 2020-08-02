package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class ConfigurationPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public ConfigurationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By sbDevideMainMenu = By.xpath(readerXpath.getCellData("Configuration", "detail", 2));

	public WebElement getSBDevideMainMenu() {
		return driver.findElement(sbDevideMainMenu);
	}

	By searchSBDeviceOptionMenu = By.xpath(readerXpath.getCellData("Configuration", "detail", 3));

	public WebElement getSearchSBDeviceOptionMenu() {
		return driver.findElement(searchSBDeviceOptionMenu);
	}

	By systemAdministrationMainMenu = By.xpath(readerXpath.getCellData("Configuration", "detail", 5));

	public WebElement getSystemAdministrationMainMenu() {
		return driver.findElement(systemAdministrationMainMenu);
	}

	By reloadCacheOptionMenu = By.xpath(readerXpath.getCellData("Configuration", "detail", 6));

	public WebElement getReloadCacheOptionMenu() {
		return driver.findElement(reloadCacheOptionMenu);
	}

}
