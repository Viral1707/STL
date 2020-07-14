package com.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class ServiceOrder extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public ServiceOrder(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By actions = By.xpath(readerXpath.getCellData("ServiceOrder", "detail", 2));

	public WebElement getActions() {
		return driver.findElement(actions);
	}
	
	By resubmit = By.xpath(readerXpath.getCellData("ServiceOrder", "detail", 3));

	public WebElement getResubmit() {
		return driver.findElement(resubmit);
	}
	
	By inputFieldsLable = By.xpath(readerXpath.getCellData("ServiceOrder", "detail", 4));

	public List<WebElement> getInputFieldsLable() {
		return driver.findElements(inputFieldsLable);
	}
	
	By inputFieldsValue = By.xpath(readerXpath.getCellData("ServiceOrder", "detail", 5));

	public List<WebElement> getInputFieldsValue() {
		return driver.findElements(inputFieldsValue);
	}
	
	
	By proRespCodeZero = By.xpath(readerXpath.getCellData("ServiceOrder", "detail", 6));

	public WebElement getProRespCodeZero() {
		return driver.findElement(proRespCodeZero);
	}
	
	By proRespCodeMinusOne = By.xpath(readerXpath.getCellData("ServiceOrder", "detail", 7));

	public WebElement getProRespCodeMinusOne() {
		return driver.findElement(proRespCodeMinusOne);
	}
	
	By proRespCodeMinusTwo = By.xpath(readerXpath.getCellData("ServiceOrder", "detail", 8));

	public WebElement getProRespCodeMinusTwo() {
		return driver.findElement(proRespCodeMinusTwo);
	}
}
