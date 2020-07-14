package reusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.excel.utility.Xls_Reader;
import com.pageobjects.LoginPage;
import com.resources.base;

import io.qameta.allure.Step;

public class Utilities extends base {
	
	
	Logger log = Logger.getLogger(Utilities.class);
	

	@Step("Login to dSP system...")
	public WebDriver loginMethod() throws IOException, InterruptedException {
		Xls_Reader inputValues = new Xls_Reader(
				".\\src\\main\\java\\com\\testdata\\InputValuesForDSP.xlsx");
		initializer();
		
		LoginPage lp = new LoginPage(driver);
		Utilities.highlight(lp.getUsername());
		lp.getUsername().clear();
		lp.getUsername().sendKeys(inputValues.getCellData("loginPage", "detail", 2));
		Utilities.highlight(lp.getPassword());
		lp.getPassword().clear();
		lp.getPassword().sendKeys(inputValues.getCellData("loginPage", "detail", 3));
		Utilities.highlight(lp.getLoginBtn());
		lp.getLoginBtn().click();
		log.info("Login successfully");
		//log.warn("This is just a warning");
		//log.fatal("This is just a fatal message");
		//log.error("This is just a error message");
		//log.debug("This is just a debug message");
		return driver;

	}

	public static void highlight(WebElement element) {
        String style = element.getAttribute("style");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style','background:yellow; border: 1px solid red;');", element);
        pause(250);
        js.executeScript("arguments[0].setAttribute('style','" + style + "');", element);

    }
	
	public static void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	
	
	/*
	public ArrayList<String> getDataFromExcel(String abc) throws IOException {

		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream(
				".\\src\\main\\java\\E2ETestCases\\dSP\\data1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheetCount = workbook.getNumberOfSheets();
		// System.out.println(sheetCount);
		for (int i = 0; i < sheetCount; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();

				Iterator<Cell> cells = firstRow.cellIterator();

				int k = 0;
				int column = 0;
				while (cells.hasNext()) {
					Cell value = cells.next();
					if (value.getStringCellValue().equalsIgnoreCase("entity")) {
						column = k;

					}
					k++;
				}
				// System.out.println(column);

				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("browser")) {

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {

							a.add(cv.next().getStringCellValue());

						}
					}

				}

			}

		}
		return a;

	}
	*/

}
