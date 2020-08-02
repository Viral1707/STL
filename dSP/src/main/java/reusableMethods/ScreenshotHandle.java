package reusableMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHandle {

	public void failed(WebDriver driver) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("C:\\Users\\Viral\\git\\STL\\dSP" + "\\screenshots\\testFailure.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
