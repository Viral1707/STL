package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class HomePage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By reports = By.xpath(readerXpath.getCellData("homePage", "detail", 2));

	public WebElement getReports() {
		return driver.findElement(reports);
	}
	
	By configuration = By.xpath(readerXpath.getCellData("homePage", "detail", 3));

	public WebElement getConfiguration() {
		return driver.findElement(configuration);
	}
	
	By execution = By.xpath(readerXpath.getCellData("homePage", "detail", 4));

	public WebElement getExecution() {
		return driver.findElement(execution);
	}
	
	

}
