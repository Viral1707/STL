package com.pageobjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class CommandListPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public CommandListPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By commandName = By.xpath(readerXpath.getCellData("CommandList", "detail", 2));

	public WebElement getCommandName() {
		return driver.findElement(commandName);
	}
	
	By searchCommand = By.xpath(readerXpath.getCellData("CommandList", "detail", 3));

	public WebElement getSearchCommand() {
		return driver.findElement(searchCommand);
	}
	
	By editCommand = By.xpath(readerXpath.getCellData("CommandList", "detail", 4));

	public WebElement getEditCommand() {
		return driver.findElement(editCommand);
	}
	
	
	By activateBtn = By.xpath(readerXpath.getCellData("CommandList", "detail", 5));

	public WebElement getActivateBtn() {
		return driver.findElement(activateBtn);
	}
	
	By reactivateBtn = By.xpath(readerXpath.getCellData("CommandList", "detail", 6));

	public WebElement getReactivateBtn() {
		return driver.findElement(reactivateBtn);
	}
	
	
	By yesDBLookup = By.xpath(readerXpath.getCellData("CommandList", "detail", 7));

	public WebElement getYesDBLookup() {
		return driver.findElement(yesDBLookup);
	}
	
	By noDBLookup = By.xpath(readerXpath.getCellData("CommandList", "detail", 8));

	public WebElement getNoDBLookup() {
		return driver.findElement(noDBLookup);
	}
	
	
	By dbLookupDropdown = By.xpath(readerXpath.getCellData("CommandList", "detail", 9));

	public WebElement getDBLookupDropdown() {
		return driver.findElement(dbLookupDropdown);
	}
	
	By dbLookupOptions = By.xpath(readerXpath.getCellData("CommandList", "detail", 10));

	public List<WebElement> getDBLookupOptions() {
		return driver.findElements(dbLookupOptions);
	}
	
	By submitBtn = By.xpath(readerXpath.getCellData("CommandList", "detail", 11));

	public WebElement getSubmitBtn() {
		return driver.findElement(submitBtn);
	}
	
	By okBtn = By.xpath(readerXpath.getCellData("CommandList", "detail", 12));

	public WebElement getOKBtn() {
		return driver.findElement(okBtn);
	}
	
}
