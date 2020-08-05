package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class nbReqTrackDetails extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public nbReqTrackDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By clearTime = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 2));

	public WebElement getClearTime() {
		return driver.findElement(clearTime);
	}

	By NBOrderID = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 3));

	public WebElement getNBOrderID() {
		return driver.findElement(NBOrderID);
	}

	By serviceOrderID = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 8));

	public WebElement getServiceOrderID() {
		return driver.findElement(serviceOrderID);
	}

	By searchBtn = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 4));

	public WebElement getSearchBtn() {
		return driver.findElement(searchBtn);
	}

	By status = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 5));

	public WebElement getStatus() {
		return driver.findElement(status);
	}

	By proReqRespLink = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 6));

	public WebElement getProReqRespLink() {
		return driver.findElement(proReqRespLink);
	}

	By serviceOrderIDLink = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 7));

	public WebElement getServiceOrderIDLink() {
		return driver.findElement(serviceOrderIDLink);
	}

	By deliveryStatus = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 9));

	public WebElement getDeliveryStatus() {
		return driver.findElement(deliveryStatus);
	}
	
	By NBReqResponseLink = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 10));

	public WebElement getNBReqResponseLink() {
		return driver.findElement(NBReqResponseLink);
	}
	
	By IMSI = By.xpath(readerXpath.getCellData("NBReqTrackingDetails", "detail", 11));

	public WebElement getIMSI() {
		return driver.findElement(IMSI);
	}
	
	
}
