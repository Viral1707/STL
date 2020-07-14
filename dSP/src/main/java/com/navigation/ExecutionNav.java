package com.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.pageobjects.ExecutionPage;
import com.resources.base;

import reusableMethods.Utilities;

public class ExecutionNav extends base {

	public WebDriver navigateToSingleCommandExecution(WebDriver driver) throws InterruptedException {

		ExecutionPage eP = new ExecutionPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(eP.getSingleCommandExecutionMainMenu());
		action.moveToElement(eP.getSingleCommandExecutionMainMenu()).build().perform();
		Utilities.highlight(eP.getSingleCommandExecutionOption());
		eP.getSingleCommandExecutionOption().click();
		return driver;
	}
	
	public WebDriver navigateToNonCreatedNBOrders(WebDriver driver) throws InterruptedException {

		ExecutionPage eP = new ExecutionPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(eP.getManageNonCreatedOrders());
		action.moveToElement(eP.getSingleCommandExecutionMainMenu()).build().perform();
		Utilities.highlight(eP.getInvokeNonCreatedNBOrders());
		eP.getInvokeNonCreatedNBOrders().click();
		return driver;
	}

}
