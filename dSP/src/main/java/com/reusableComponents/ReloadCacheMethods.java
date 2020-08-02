package com.reusableComponents;

import org.openqa.selenium.WebDriver;

import com.excel.utility.Xls_Reader;
import com.pageobjects.ReloadCachePage;
import com.pageobjects.nbReqTrackDetails;
import com.resources.base;

import reusableMethods.Utilities;

public class ReloadCacheMethods extends base {

	nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	ReloadCachePage objRCP = new ReloadCachePage(driver);

	public WebDriver reloadGeneralCache(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objRCP.getGeneralTab());
		objRCP.getGeneralTab().click();
		Utilities.highlight(objRCP.getGeneralAllCheckbox());
		objRCP.getGeneralAllCheckbox().click();
		Thread.sleep(5000);
		Utilities.highlight(objRCP.getReloadCacheBtn());
		objRCP.getReloadCacheBtn().click();
		Utilities.highlight(objRCP.getProceedBtn());
		objRCP.getProceedBtn().click();
		Thread.sleep(10000);
		Utilities.highlight(objRCP.getOKBtn());
		objRCP.getOKBtn().click();

		return driver;

	}

	public WebDriver reloadProcessFlowCache(WebDriver driver) throws InterruptedException {

		Utilities.highlight(objRCP.getProcessFlowTab());
		objRCP.getProcessFlowTab().click();
		Utilities.highlight(objRCP.getProcessFlowAllCheckbox());
		objRCP.getProcessFlowAllCheckbox().click();
		Thread.sleep(5000);
		Utilities.highlight(objRCP.getReloadCacheBtn());
		objRCP.getReloadCacheBtn().click();
		Utilities.highlight(objRCP.getProceedBtn());
		objRCP.getProceedBtn().click();
		Thread.sleep(10000);
		Utilities.highlight(objRCP.getOKBtn());
		objRCP.getOKBtn().click();

		return driver;

	}

}
