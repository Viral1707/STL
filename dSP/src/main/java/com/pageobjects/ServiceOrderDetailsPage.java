package com.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class ServiceOrderDetailsPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public ServiceOrderDetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By nbOrderID = By.xpath(readerXpath.getCellData("ServiceOrderDetails", "detail", 2));

	public WebElement getNBOrderID() {
		return driver.findElement(nbOrderID);
	}
	
	By serviceOrderStatus = By.xpath(readerXpath.getCellData("ServiceOrderDetails", "detail", 3));

	public WebElement getServiceOrderStatus() {
		return driver.findElement(serviceOrderStatus);
	}
	
	By searchBtn = By.xpath(readerXpath.getCellData("ServiceOrderDetails", "detail", 4));

	public WebElement getSearchBtn() {
		return driver.findElement(searchBtn);
	}
	
	By searchedNBOrderID = By.xpath(readerXpath.getCellData("ServiceOrderDetails", "detail", 4));

	public WebElement getSearchedNBOrderID() {
		return driver.findElement(searchedNBOrderID);
	}
}
