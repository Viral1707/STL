package com.reusableComponents;


import org.openqa.selenium.WebDriver;


import com.pageobjects.NBRespDetails;
import com.resources.base;

import reusableMethods.Utilities;

public class NBResponseDetails extends base {

	

	public String getResponseXML(WebDriver driver) {

		NBRespDetails objNBRespDetails = new NBRespDetails(driver);
		Utilities.highlight(objNBRespDetails.getNBResponse());
		String statusNBReq = objNBRespDetails.getNBResponse().getText();
		
		return statusNBReq;

	}
	
	public WebDriver refreshNBResponsePage(WebDriver driver) {

		NBRespDetails objNBRespDetails = new NBRespDetails(driver);
		Utilities.highlight(objNBRespDetails.getRefreshBtn());
		objNBRespDetails.getRefreshBtn().click();
		
		return driver;

	}
	
	

}
