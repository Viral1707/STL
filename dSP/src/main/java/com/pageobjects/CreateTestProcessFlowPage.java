package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class CreateTestProcessFlowPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public CreateTestProcessFlowPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By INP_IMSI = By.xpath(readerXpath.getCellData("CreateTestProcessFlowScreen", "detail", 2));

	public WebElement getINP_IMSI() {
		return driver.findElement(INP_IMSI);
	}
	
	By INP_KI = By.xpath(readerXpath.getCellData("CreateTestProcessFlowScreen", "detail", 3));

	public WebElement getINP_KI() {
		return driver.findElement(INP_KI);
	}
	
	By INP_K4 = By.xpath(readerXpath.getCellData("CreateTestProcessFlowScreen", "detail", 4));

	public WebElement getINP_K4() {
		return driver.findElement(INP_K4);
	}
	
	By INP_CATEGORY = By.xpath(readerXpath.getCellData("CreateTestProcessFlowScreen", "detail", 5));

	public WebElement getINP_CATEGORY() {
		return driver.findElement(INP_CATEGORY);
	}
	
	By INP_SUB_CATEGORY = By.xpath(readerXpath.getCellData("CreateTestProcessFlowScreen", "detail", 6));

	public WebElement getINP_SUB_CATEGORY() {
		return driver.findElement(INP_SUB_CATEGORY);
	}
	
	By createBtn = By.xpath(readerXpath.getCellData("CreateTestProcessFlowScreen", "detail", 7));

	public WebElement getCreateBtn() {
		return driver.findElement(createBtn);
	}
	

}
