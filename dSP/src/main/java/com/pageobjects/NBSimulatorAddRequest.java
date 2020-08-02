package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class NBSimulatorAddRequest extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public NBSimulatorAddRequest(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By requestTypeJMS = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 2));

	public WebElement getRequestTypeJMS() {
		return driver.findElement(requestTypeJMS);
	}

	By RequestTypeRestAsync = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 3));

	public WebElement getRequestTypeRestAsync() {
		return driver.findElement(RequestTypeRestAsync);
	}

	By DataType = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 4));

	public WebElement getDataType() {
		return driver.findElement(DataType);
	}

	By DataTypeList = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 5));

	public List<WebElement> getDataTypeList() {
		return driver.findElements(DataTypeList);
	}

	By QueueList = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 6));

	public WebElement getQueueList() {
		return driver.findElement(QueueList);
	}

	By QueueListList = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 7));

	public List<WebElement> getQueueListList() {
		return driver.findElements(QueueListList);
	}

	By AddRequestTextBox = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 8));

	public WebElement getAddRequestTextBox() {
		return driver.findElement(AddRequestTextBox);
	}

	By addBtn = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 9));

	public WebElement getAddBtn() {
		return driver.findElement(addBtn);
	}

	By resetBtn = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 10));

	public WebElement getResetBtn() {
		return driver.findElement(resetBtn);
	}

	By okBtn = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 11));

	public WebElement getOKBtn() {
		return driver.findElement(okBtn);
	}

	By syntaticalError = By.xpath(readerXpath.getCellData("NBSimulatorAddRequest", "detail", 12));

	public WebElement getSyntaticalError() {
		return driver.findElement(syntaticalError);
	}
}
