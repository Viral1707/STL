package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.resources.base;

public class LoginPage extends base {

	public WebDriver driver;

	Xls_Reader readerXpath = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\XPathForDSP.xlsx");

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;

	}

	By username = By.xpath(readerXpath.getCellData("loginPage", "detail", 2));

	public WebElement getUsername() {
		return driver.findElement(username);
	}

	By password = By.xpath(readerXpath.getCellData("loginPage", "detail", 3));

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	By loginBtn = By.xpath(readerXpath.getCellData("loginPage", "detail", 4));

	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}

}
