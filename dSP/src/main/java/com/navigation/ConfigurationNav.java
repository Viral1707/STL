package com.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.pageobjects.ConfigurationPage;
import com.resources.base;

import reusableMethods.Utilities;

public class ConfigurationNav extends base {

	public WebDriver navigateToSearchSBDevie(WebDriver driver) throws InterruptedException {

		ConfigurationPage cP = new ConfigurationPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(cP.getSBDevideMainMenu());
		action.moveToElement(cP.getSBDevideMainMenu()).build().perform();
		Utilities.highlight(cP.getSearchSBDeviceOptionMenu());
		cP.getSearchSBDeviceOptionMenu().click();
		return driver;
	}
	
	
	public WebDriver navigateToReloadCache(WebDriver driver) throws InterruptedException {

		ConfigurationPage cP = new ConfigurationPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(cP.getSystemAdministrationMainMenu());
		action.moveToElement(cP.getSystemAdministrationMainMenu()).build().perform();
		Utilities.highlight(cP.getReloadCacheOptionMenu());
		cP.getReloadCacheOptionMenu().click();
		return driver;
	}
	
	
	public WebDriver navigateConfigSystemPara(WebDriver driver) throws InterruptedException {

		ConfigurationPage cP = new ConfigurationPage(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(cP.getSystemAdministrationMainMenu());
		action.moveToElement(cP.getSystemAdministrationMainMenu()).build().perform();
		Utilities.highlight(cP.getConfigSystemParaMenu());
		cP.getConfigSystemParaMenu().click();
		return driver;
	}
	

}
