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
	
	public WebDriver navigateToNBSimulators(WebDriver driver) throws InterruptedException {
		
		ExecutionPage eP = new ExecutionPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(eP.getNBSimulatorMainMenu());
		action.moveToElement(eP.getNBSimulatorMainMenu()).build().perform();
		Utilities.highlight(eP.getNBSImulatorOption());
		eP.getNBSImulatorOption().click();
		return driver;
	}
	
	public WebDriver navigateToInvokeNonCreatedNBOrders(WebDriver driver) throws InterruptedException {
		
		ExecutionPage eP = new ExecutionPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(eP.getManageNonCreatedOrders());
		action.moveToElement(eP.getManageNonCreatedOrders()).build().perform();
		Utilities.highlight(eP.getInvokeNonCreatedNBOrders());
		eP.getInvokeNonCreatedNBOrders().click();
		return driver;
	}
	
	public WebDriver navigateToTestProcessFlowExecutionPage(WebDriver driver) throws InterruptedException {
		
		ExecutionPage eP = new ExecutionPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(eP.getTestCategory());
		action.moveToElement(eP.getTestCategory()).build().perform();
		Utilities.highlight(eP.getTestProcessFlow());
		eP.getTestProcessFlow().click();
		return driver;
	}

	public WebDriver navigateToTestProcessFlowJsonExecutionPage(WebDriver driver) throws InterruptedException {
		
		ExecutionPage eP = new ExecutionPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(eP.getTestCategory());
		action.moveToElement(eP.getTestCategory()).build().perform();
		Utilities.highlight(eP.getTestProcessFlowJSON());
		eP.getTestProcessFlowJSON().click();
		return driver;
	}
	
}
