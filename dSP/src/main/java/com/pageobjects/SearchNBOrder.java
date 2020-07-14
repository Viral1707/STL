package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class SearchNBOrder extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public SearchNBOrder(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By NBOrderID = By.xpath(readerXpath.getCellData("SearchNBOrder", "detail", 2));

	public WebElement getNBOrderID() {
		return driver.findElement(NBOrderID);
	}
	
	By searchBtn = By.xpath(readerXpath.getCellData("SearchNBOrder", "detail", 3));

	public WebElement getSearchBtn() {
		return driver.findElement(searchBtn);
	}
	/*
	By createOrderBtn = By.xpath(readerXpath.getCellData("Execution", "detail", 4));

	public WebElement getCreateOrderBtn() {
		return driver.findElement(createOrderBtn);
	}
	*/
	By firstNBOrderID = By.xpath(readerXpath.getCellData("ServiceOrderDetails", "detail", 6));

	public WebElement getFirstNBOrderID() {
		return driver.findElement(firstNBOrderID);
	}
	
	

}
