package com.reusableComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.excel.utility.Xls_Reader;
import com.pageobjects.ServiceOrderDetailsPage;
import com.resources.base;

import reusableMethods.Utilities;

public class ServiceOrderPageMethods extends base {

	Xls_Reader collectValues = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\CollectedValuesForDSP.xlsx");
	
	ServiceOrderDetailsPage objServiceOrderDetailsPage = new ServiceOrderDetailsPage(driver);

	public WebDriver getExternalRefrenceID(WebDriver driver) {
		ServiceOrderDetailsPage objServiceOrderDetailsPage = new ServiceOrderDetailsPage(driver);
		Utilities.highlight(objServiceOrderDetailsPage.getNBOrderID());
		String ServiceOrderID = objServiceOrderDetailsPage.getNBOrderID().getAttribute("Value");
		collectValues.setCellData("ServiceOrderDetails", "detail", 2, ServiceOrderID);
		return driver;

	}

	public WebDriver verifyServiceOrderStatusCompleted(WebDriver driver) throws InterruptedException {

		
		Thread.sleep(5000);
		Utilities.highlight(objServiceOrderDetailsPage.getSearchBtn());
		objServiceOrderDetailsPage.getSearchBtn().click();
		Thread.sleep(5000);
		Utilities.highlight(objServiceOrderDetailsPage.getServiceOrderStatus());
		String statusServiceOrder = objServiceOrderDetailsPage.getServiceOrderStatus().getText();
		System.out.println("Status" + statusServiceOrder);
		Assert.assertEquals("Completed", statusServiceOrder);
		return driver;

	}

	public WebDriver verifyServiceOrderStatusFailed(WebDriver driver) throws InterruptedException {

		ServiceOrderDetailsPage objServiceOrderDetailsPage = new ServiceOrderDetailsPage(driver);
		Thread.sleep(10000);
		Utilities.highlight(objServiceOrderDetailsPage.getSearchBtn());
		objServiceOrderDetailsPage.getSearchBtn().click();
		Thread.sleep(10000);
		Utilities.highlight(objServiceOrderDetailsPage.getServiceOrderStatus());
		String statusServiceOrder = objServiceOrderDetailsPage.getServiceOrderStatus().getText();
		System.out.println("Status" + statusServiceOrder);
		Assert.assertEquals("Failed", statusServiceOrder);
		return driver;

	}
	
	public WebDriver searchServiceOrderWithNBOrderIDandOpenIt(WebDriver driver) throws InterruptedException {

		
		Utilities.highlight(objServiceOrderDetailsPage.getNBOrderID());
		objServiceOrderDetailsPage.getNBOrderID().sendKeys("");
		objServiceOrderDetailsPage.getSearchBtn().click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.doubleClick(objServiceOrderDetailsPage.getSearchedNBOrderID()).perform();
		
		return driver;

	}
	

}
