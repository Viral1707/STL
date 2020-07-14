package com.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class SingleCommandExecutionPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public SingleCommandExecutionPage(WebDriver driver) {
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
	
	By listDevice = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 3));

	public List<WebElement> getListDevice() {
		return driver.findElements(listDevice);
	}
	
	
	By command = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 4));

	public WebElement getCommand() {
		return driver.findElement(command);
	}
	
	By listCommand = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 5));

	public List<WebElement> getListCommand() {
		return driver.findElements(listCommand);
	}
	
	By priorityLevel = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 6));

	public WebElement getPriorityLevel() {
		return driver.findElement(priorityLevel);
	}
	
	By listPriorityLevel = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 7));

	public List<WebElement> getListPriorityLevel() {
		return driver.findElements(listPriorityLevel);
	}

	By singleCommandInvocationBtn = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 8));

	public WebElement getSingleCommandInvocationBtn() {
		return driver.findElement(singleCommandInvocationBtn);
	}
	
	By sb_imsi = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 9));

	public WebElement getsb_imsi() {
		return driver.findElement(sb_imsi);
	}
	
	By sb_k4sno = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 10));

	public WebElement getsb_k4sno() {
		return driver.findElement(sb_k4sno);
	}
	
	By sb_ki = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 11));

	public WebElement getsb_ki() {
		return driver.findElement(sb_ki);
	}
	
	By submitBtn = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 12));

	public WebElement getsubmitBtn() {
		return driver.findElement(submitBtn);
	}
	
	By externalRefrenceID = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 13));

	public WebElement getExternalRefrenceID() {
		return driver.findElement(externalRefrenceID);
	}
	
	By label = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 15));

	public List<WebElement> getLable() {
		return driver.findElements(label);
	}
	
	By labelValue = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 16));

	public List<WebElement> getLabelValue() {
		return driver.findElements(labelValue);
	}
	
	By OKBtn = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 14));

	public WebElement getOKBtn() {
		return driver.findElement(OKBtn);
	}
	
	By errorMessage = By.xpath(readerXpath.getCellData("SingleCommandExecution", "detail", 17));

	public WebElement getErrorMessage() {
		return driver.findElement(errorMessage);
	}
	
}
