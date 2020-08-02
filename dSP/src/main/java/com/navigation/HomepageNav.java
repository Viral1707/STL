package com.navigation;

import org.openqa.selenium.WebDriver;

import com.pageobjects.HomePage;
import com.resources.base;

import io.qameta.allure.Step;
import reusableMethods.Utilities;

public class HomepageNav extends base {

	
	@Step("Navigation to Reports")
	public WebDriver navigateToReports(WebDriver driver) {

		HomePage hp = new HomePage(driver);
		Utilities.highlight(hp.getReports());
		hp.getReports().click();
		return driver;

	}

	@Step("Navigation to Configuration")
	public WebDriver navigateToConfiguration(WebDriver driver) {

		HomePage hp = new HomePage(driver);
		Utilities.highlight(hp.getConfiguration());
		hp.getConfiguration().click();
		return driver;

	}

	
	@Step("Navigate to Execution")
	public WebDriver navigateToExecution(WebDriver driver) throws InterruptedException {

		HomePage hp = new HomePage(driver);
		Utilities.highlight(hp.getExecution());
		hp.getExecution().click();
		Thread.sleep(3000);
		return driver;

	}

}
