package com.resources;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.excel.utility.Xls_Reader;


public class base {

	protected static WebDriver driver;
	
	public void failed(WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(".\\screenshots"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public WebDriver initializer() throws IOException, InterruptedException {

		Xls_Reader readerLaunch = new Xls_Reader(
				".\\src\\main\\java\\com\\testdata\\dataForDspNGT.xlsx");

		if (readerLaunch.getCellData("launchBrowser", "detail", 2).equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Vir@l's Data\\Study\\ChromeDriver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", ".\\src\\main\\java\\com\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(readerLaunch.getCellData("launchBrowser", "detail", 3));
		}

		/*
		 * Utilities objUtil = new Utilities(); ArrayList data =
		 * objUtil.getDataFromExcel("url"); System.out.println("ABC" + data.get(0));
		 * System.out.println("DEF" + data.get(1));
		 */

		/*
		 * if(data.get(1).equals("chrome")) {
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Vir@l's Data\\Study\\ChromeDriver\\chromedriver.exe"); driver = new
		 * ChromeDriver(); driver.get("http://10.151.32.200:30580/dsp/"); String Title =
		 * driver.getTitle(); System.out.println(Title); driver.close(); }
		 */

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	

}
