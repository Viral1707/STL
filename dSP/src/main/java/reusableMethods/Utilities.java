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
	
	
	
	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");
	
public int findRowForTestData(WebDriver driver, String TestCaseName) {
		
		int rowTestData = 1;

		if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 2))) {
			rowTestData = 2;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 3))) {
			rowTestData = 3;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 4))) {
			rowTestData = 4;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 5))) {
			rowTestData = 5;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 6))) {
			rowTestData = 6;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 7))) {
			rowTestData = 7;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 8))) {
			rowTestData = 8;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 9))) {
			rowTestData = 9;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 10))) {
			rowTestData = 10;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 11))) {
			rowTestData = 11;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 12))) {
			rowTestData = 12;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 13))) {
			rowTestData = 13;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 14))) {
			rowTestData = 14;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 15))) {
			rowTestData = 15;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 16))) {
			rowTestData = 16;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 17))) {
			rowTestData = 17;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 18))) {
			rowTestData = 18;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 19))) {
			rowTestData = 19;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 20))) {
			rowTestData = 20;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 21))) {
			rowTestData = 21;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 22))) {
			rowTestData = 22;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 23))) {
			rowTestData = 23;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 24))) {
			rowTestData = 24;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 25))) {
			rowTestData = 25;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 26))) {
			rowTestData = 26;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 27))) {
			rowTestData = 27;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 28))) {
			rowTestData = 28;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 29))) {
			rowTestData = 29;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 30))) {
			rowTestData = 30;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 31))) {
			rowTestData = 31;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 32))) {
			rowTestData = 32;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 33))) {
			rowTestData = 33;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 34))) {
			rowTestData = 34;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 35))) {
			rowTestData = 35;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 36))) {
			rowTestData = 36;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 37))) {
			rowTestData = 37;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 38))) {
			rowTestData = 38;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 39))) {
			rowTestData = 39;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 40))) {
			rowTestData = 40;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 41))) {
			rowTestData = 41;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 42))) {
			rowTestData = 42;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 43))) {
			rowTestData = 43;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 44))) {
			rowTestData = 44;
		} else if (TestCaseName.equalsIgnoreCase(objTestData.getCellData("TestCaseData", "TestCaseName", 45))) {
			rowTestData = 45;
		}
		
		return rowTestData;
		
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
