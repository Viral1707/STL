package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class UpdateSystemParametersPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public UpdateSystemParametersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By batchUploadTab = By.xpath(readerXpath.getCellData("UpdateSystemParameter", "detail", 2));

	public WebElement getBatchUploadTab() {
		return driver.findElement(batchUploadTab);
	}
	
	
	By generalTab = By.xpath(readerXpath.getCellData("UpdateSystemParameter", "detail", 3));

	public WebElement getGeneralTab() {
		return driver.findElement(generalTab);
	}

	By passwordPolicyTab = By.xpath(readerXpath.getCellData("UpdateSystemParameter", "detail", 4));

	public WebElement getPasswordPolicyTab() {
		return driver.findElement(passwordPolicyTab);
	}
	
	By loopbackStatusDropdown = By.xpath(readerXpath.getCellData("UpdateSystemParameter", "detail", 5));

	public WebElement getLoopbackStatusDropdown() {
		return driver.findElement(loopbackStatusDropdown);
	}
	
	By valuesLoopbackStatusDropdown = By.xpath(readerXpath.getCellData("UpdateSystemParameter", "detail", 6));

	public List<WebElement> getvaluesLoopbackStatusDropdown() {
		return driver.findElements(valuesLoopbackStatusDropdown);
	}
	
	
	By saveBtn = By.xpath(readerXpath.getCellData("UpdateSystemParameter", "detail", 7));

	public WebElement getSaveBtn() {
		return driver.findElement(saveBtn);
	}
	

	By intellzaConfigStatusDropdown = By.xpath(readerXpath.getCellData("UpdateSystemParameter", "detail", 8));

	public WebElement getIntellzaConfigStatusDropdown() {
		return driver.findElement(intellzaConfigStatusDropdown);
	}
	
	By valuesIntellzaConfigStatusDropdown = By.xpath(readerXpath.getCellData("UpdateSystemParameter", "detail", 9));

	public List<WebElement> getvaluesIntellzaConfigStatusDropdown() {
		return driver.findElements(valuesIntellzaConfigStatusDropdown);
	}
	
}
