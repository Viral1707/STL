package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class UpdateCommandPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public UpdateCommandPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By commandURL = By.xpath(readerXpath.getCellData("UpdateCommand", "detail", 2));

	public WebElement getCommandURL() {
		return driver.findElement(commandURL);
	}

	By updateBtn = By.xpath(readerXpath.getCellData("UpdateCommand", "detail", 3));

	public WebElement getUpdateBtn() {
		return driver.findElement(updateBtn);
	}
	
	By updateBtnWarningPage = By.xpath(readerXpath.getCellData("EditSBDeviceDetails", "detail", 4));

	public WebElement getUpdateBtnWarningPage() {
		return driver.findElement(updateBtnWarningPage);
	}
	
	By OKBtn = By.xpath(readerXpath.getCellData("EditSBDeviceDetails", "detail", 5));

	public WebElement getOKBtn() {
		return driver.findElement(OKBtn);
	}
	
	By enableRadioBtn = By.xpath(readerXpath.getCellData("EditSBDeviceDetails", "detail", 6));

	public WebElement getEnableRadioBtn() {
		return driver.findElement(enableRadioBtn);
	}
	
	
	By disableRadioBtn = By.xpath(readerXpath.getCellData("EditSBDeviceDetails", "detail", 7));

	public WebElement getDisableRadioBtn() {
		return driver.findElement(disableRadioBtn);
	}
	
	
	By loopbackResponse = By.xpath(readerXpath.getCellData("EditSBDeviceDetails", "detail", 8));

	public WebElement getLoopbackResponse() {
		return driver.findElement(loopbackResponse);
	}
	

}
