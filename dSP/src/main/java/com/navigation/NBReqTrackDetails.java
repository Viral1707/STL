package com.navigation;

import org.openqa.selenium.WebDriver;

import com.pageobjects.HomePage;
import com.pageobjects.nbReqTrackDetails;
import com.resources.base;

import reusableMethods.Utilities;

public class NBReqTrackDetails extends base {

	public WebDriver navigateToExecution(WebDriver driver) {

		HomePage hp = new HomePage(driver);
		Utilities.highlight(hp.getExecution());
		hp.getExecution().click();

		return driver;

	}

	public WebDriver navigateToProReq(WebDriver driver) {

		nbReqTrackDetails nbRTD = new nbReqTrackDetails(driver);
		Utilities.highlight(nbRTD.getProReqRespLink());
		nbRTD.getProReqRespLink().click();

		return driver;

	}

	public WebDriver navigateToServiceOrderDetails(WebDriver driver) {

		nbReqTrackDetails nbRTD = new nbReqTrackDetails(driver);
		Utilities.highlight(nbRTD.getServiceOrderIDLink());
		nbRTD.getServiceOrderIDLink().click();

		return driver;

	}
	
	public WebDriver navigateToNBResponseDetails(WebDriver driver) {

		nbReqTrackDetails nbRTD = new nbReqTrackDetails(driver);
		Utilities.highlight(nbRTD.getNBReqResponseLink());
		nbRTD.getNBReqResponseLink().click();

		return driver;

	}

}
