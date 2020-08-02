package com.reusableComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.excel.utility.Xls_Reader;
import com.pageobjects.SearchSBDevicePage;
import com.pageobjects.nbReqTrackDetails;
import com.resources.base;

import reusableMethods.Utilities;

public class searchSBDeviceMethods extends base {

	nbReqTrackDetails nbReqTrackObj = new nbReqTrackDetails(driver);

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");

	public WebDriver searchAndOpenSBDevice(WebDriver driver, int row) {

		SearchSBDevicePage objSSBD = new SearchSBDevicePage(driver);
		Utilities.highlight(objSSBD.getSBDeviceName());
		objSSBD.getSBDeviceName().sendKeys(objTestData.getCellData("TestCaseData", "searchDeviceName", row));
		Utilities.highlight(objSSBD.getProtocolDropdown());
		objSSBD.getProtocolDropdown().click();

		List<WebElement> protocolList = objSSBD.getProtocolDropdownOption();
		System.out.println("Protocol Names List Size" + protocolList.size());
		int z;
		for (z = 0; z < protocolList.size(); z++) {
			Utilities.highlight(protocolList.get(z));
			System.out.println(protocolList.get(z));
			String Value_protocolList = protocolList.get(z).getText().trim();
			System.out.println(Value_protocolList);
			System.out.println("Excel Data : " + objTestData.getCellData("TestCaseData", "Protocol", row));
			if (Value_protocolList.equals(objTestData.getCellData("TestCaseData", "Protocol", row))) {
				System.out.println(protocolList.get(z));
				Utilities.highlight(protocolList.get(z));
				protocolList.get(z).click();
				break;
			}
		}

		Utilities.highlight(objSSBD.getSearchBtn());
		objSSBD.getSearchBtn().click();
		Utilities.highlight(objSSBD.getEditFirstSBDevice());
		objSSBD.getEditFirstSBDevice().click();
		return driver;

	}
	
	
	public WebDriver searchAndOpenCommandList(WebDriver driver, int row) {

		SearchSBDevicePage objSSBD = new SearchSBDevicePage(driver);
		Utilities.highlight(objSSBD.getSBDeviceName());
		objSSBD.getSBDeviceName().sendKeys(objTestData.getCellData("TestCaseData", "searchDeviceName", row));
		Utilities.highlight(objSSBD.getProtocolDropdown());
		objSSBD.getProtocolDropdown().click();

		List<WebElement> protocolList = objSSBD.getProtocolDropdownOption();
		System.out.println("Protocol Names List Size" + protocolList.size());
		int z;
		for (z = 0; z < protocolList.size(); z++) {
			Utilities.highlight(protocolList.get(z));
			System.out.println(protocolList.get(z));
			String Value_protocolList = protocolList.get(z).getText().trim();
			System.out.println(Value_protocolList);
			System.out.println("Excel Data : " + objTestData.getCellData("TestCaseData", "Protocol", row));
			if (Value_protocolList.equals(objTestData.getCellData("TestCaseData", "Protocol", row))) {
				System.out.println(protocolList.get(z));
				Utilities.highlight(protocolList.get(z));
				protocolList.get(z).click();
				break;
			}
		}

		Utilities.highlight(objSSBD.getSearchBtn());
		objSSBD.getSearchBtn().click();
		Utilities.highlight(objSSBD.getopenCommandList());
		objSSBD.getopenCommandList().click();
		return driver;

	}

}
