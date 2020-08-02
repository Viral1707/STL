package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class ExecutionPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public ExecutionPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By singleCommandExecutionMainMenu = By.xpath(readerXpath.getCellData("Execution", "detail", 2));

	public WebElement getSingleCommandExecutionMainMenu() {
		return driver.findElement(singleCommandExecutionMainMenu);
	}
	
	By singleCommandExecutionOption = By.xpath(readerXpath.getCellData("Execution", "detail", 3));

	public WebElement getSingleCommandExecutionOption() {
		return driver.findElement(singleCommandExecutionOption);
	}
	
	By manageNonCreatedOrders = By.xpath(readerXpath.getCellData("Execution", "detail", 7));

	public WebElement getManageNonCreatedOrders() {
		return driver.findElement(manageNonCreatedOrders);
	}
	
	By invokeNonCreatedNBOrders = By.xpath(readerXpath.getCellData("Execution", "detail", 8));

	public WebElement getInvokeNonCreatedNBOrders() {
		return driver.findElement(invokeNonCreatedNBOrders);
	}

	By NBSimulatorMainMenu = By.xpath(readerXpath.getCellData("Execution", "detail", 9));

	public WebElement getNBSimulatorMainMenu() {
		return driver.findElement(NBSimulatorMainMenu);
	}
	
	By NBSImulatorOption = By.xpath(readerXpath.getCellData("Execution", "detail", 10));

	public WebElement getNBSImulatorOption() {
		return driver.findElement(NBSImulatorOption);
	}
	
	By ManageNonCreatedOrders = By.xpath(readerXpath.getCellData("Execution", "detail", 10));

	
	
}
