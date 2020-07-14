package com.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.pageobjects.Reports;
import com.resources.base;

import reusableMethods.Utilities;

public class ReportsNav extends base{
	
	public WebDriver navigateToNbReqResponseTracking(WebDriver driver) {
		
		//WebDriver driver;
		
		Reports reports = new Reports(driver);
		Actions action = new Actions(driver);
		Utilities.highlight(reports.getNbReqResp());
		action.moveToElement(reports.getNbReqResp()).build().perform();
		
		Utilities.highlight(reports.getNbReqRespTrack());
		reports.getNbReqRespTrack().click();
		
		return driver;
		
		
		
		
	}

}
