package com.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class ProcessFlowCreateScreen extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public ProcessFlowCreateScreen(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By deviceName = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 2));

	public WebElement getDeviceName() {
		return driver.findElement(deviceName);
	}
	/*
	By listDeviceName = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 3));

	public <WebElements> List<WebElement> getListDeviceName() {
		
		ArrayList<WebElements> deviceList = new ArrayList<WebElements>();
		
		
		return driver.findElements(listDeviceName);
	}
	*/
	
	By inputFieldsLable = By.xpath(readerXpath.getCellData("CreateScreen", "detail", 2));

	public List<WebElement> getInputFieldsLable() {
		return driver.findElements(inputFieldsLable);
	}
	
	By inputFieldsValue = By.xpath(readerXpath.getCellData("CreateScreen", "detail", 3));

	public List<WebElement> getInputFieldsValue() {
		return driver.findElements(inputFieldsValue);
	}
	
	By createBtn = By.xpath(readerXpath.getCellData("CreateScreen", "detail", 4));

	public WebElement getCreateBtn() {
		return driver.findElement(createBtn);
	}
	
	
}
