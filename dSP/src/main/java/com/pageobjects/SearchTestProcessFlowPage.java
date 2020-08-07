package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class SearchTestProcessFlowPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public SearchTestProcessFlowPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	
	By createBtn = By.xpath(readerXpath.getCellData("SearchTestProcessFlowScreen", "detail", 5));

	public WebElement getCreateBtn() {
		return driver.findElement(createBtn);
	}
	

}
