package E2ETestCases.dSP;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;
import com.navigation.ExecutionNav;
import com.navigation.HomepageNav;
import com.navigation.NBReqTrackDetails;
import com.navigation.ReportsNav;
import com.resources.base;
import com.reusableComponents.NBResponseDetails;
import com.reusableComponents.ProRequestMethods;
import com.reusableComponents.SearchNBOrderMethods;
import com.reusableComponents.ServiceOrderMethods;
import com.reusableComponents.ServiceOrderPageMethods;
import com.reusableComponents.nbReqTrackDetailsMethods;
import com.reusableComponents.singleCommandExecutionMethods;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import reusableMethods.Utilities;

public class regression extends base {
	Logger log = Logger.getLogger(Utilities.class);
	@Test(enabled = false)
	public void Test1() throws IOException, InterruptedException {
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToReports(driver);
		ReportsNav rn = new ReportsNav();
		rn.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNBReqResponseTrackDetails = new nbReqTrackDetailsMethods();
		objNBReqResponseTrackDetails.clearTime(driver);
		objNBReqResponseTrackDetails.searchWithServiceOrderID(driver);
		// driver = objNBReqResponseTrackDetails.searchWithNBOrderID(driver);
		objNBReqResponseTrackDetails.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBReqTrackDetails = new NBReqTrackDetails();
		objNBReqTrackDetails.navigateToProReq(driver);
		ProRequestMethods objProReq = new ProRequestMethods();
		objProReq.verifyProReqRespStatusAsProcessedWithLoopback(driver);
		// Thread.sleep(5000);
		driver.close();

	}

	@Test(enabled = false)
	public void Test2() throws IOException, InterruptedException {

		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ReportsNav rn = new ReportsNav();
		driver = rn.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNBReqResponseTrackDetails = new nbReqTrackDetailsMethods();
		driver = objNBReqResponseTrackDetails.clearTime(driver);
		driver = objNBReqResponseTrackDetails.searchWithServiceOrderID(driver);
		NBReqTrackDetails objNBReqTrackDetails = new NBReqTrackDetails();
		driver = objNBReqTrackDetails.navigateToNBResponseDetails(driver);
		NBResponseDetails objNBResponseDetails = new NBResponseDetails();
		String responseXML = objNBResponseDetails.getResponseXML(driver);
		// driver = objNBReqResponseTrackDetails.searchWithNBOrderID(driver);
		System.out.println(responseXML);
		// Thread.sleep(5000);
		// Assert.assertTrue(responseXML.contains("<STATUS_FLAG>0")); driver.close();
	}

	Xls_Reader TCName = new Xls_Reader(
			".\\src\\main\\java\\com\\testdata\\TestCaseName.xlsx");

	
	@Test(enabled = true, priority = 1, description="TestOne_TestNGProject")
	@Severity(SeverityLevel.NORMAL)
	@Description("TestOne_AllureProject : First Test Case")
	@Story("Story Name : To check the Single Command Execution")
	public void SuccessfulOrderexecutionSingleCommand_XMLRequest() throws IOException, InterruptedException {
		log.info("Successful Order execution_Single Command_XML Request");
		String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 2).trim();
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, TestCaseName);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusCompleted(driver);
		SearchNBOrderMethods objSNBOM = new SearchNBOrderMethods();
		objSNBOM.openServiceOrderWithNBOrderID(driver);
		ServiceOrderMethods objSOM = new ServiceOrderMethods();
		objSOM.verifyProvisioninggResponseCodeAs0(driver, TestCaseName);
		//objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	@Severity(SeverityLevel.BLOCKER)
	@Description("TestOne_AllureProject : Second Test Case")
	@Story("Story Name : To check the Single Command Execution_2")
	@Test(enabled = false, priority = 2)
	public void SuccessfulOrderexecutionSingleCommand_JSONRequest() throws IOException, InterruptedException {
		log.info("Successful Order execution_Single Command_JSON Request");
		String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 3);
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, TestCaseName);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusCompleted(driver);
//		SearchNBOrderMethods objSNBOM = new SearchNBOrderMethods();
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	@Severity(SeverityLevel.CRITICAL)
	@Description("TestOne_AllureProject : Third Test Case")
	@Story("Story Name : To check the Single Command Execution_3")
	@Test(enabled = false, priority = 3)
	public void FailedOrderexecutionSingleCommand_InvalidInput_XMLDevice() throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Input_XML Device");
		String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 4);
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, TestCaseName);
		objSCEM.verifyFailedServiceOrderMessage(driver);
		driver.close();
		log.info("Successfully Tested");
	}

	
	@Severity(SeverityLevel.CRITICAL)
	@Description("TestOne_AllureProject : Fourth Test Case")
	@Story("Story Name : To check the Single Command Execution_4")
	@Test(enabled = false, priority = 4)
	public void FailedOrderexecutionSingleCommand_InvalidInput_JSONDevice() throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Input_JSON Device");
		String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 5);
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, TestCaseName);
		objSCEM.verifyFailedServiceOrderMessage(driver);
		driver.close();
		log.info("Successfully Tested");
	}

	@Test(enabled = false, priority = 5)
	public void FailedOrderexecutionSingleCommand_InvalidProvisioningURL_XMLDevice() throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Provisioning URL_XML Device");
		String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 6);
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, TestCaseName);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusFailed(driver);
//		SearchNBOrderMethods objSNBOM = new SearchNBOrderMethods();
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	@Test(enabled = false, priority = 6)
	public void FailedOrderexecutionSingleCommand_InvalidProvisioningURL_JSONDevice() throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Provisioning URL_JSON Device");
		String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 7);
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, TestCaseName);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusFailed(driver);
//		SearchNBOrderMethods objSNBOM = new SearchNBOrderMethods();
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	@Test(enabled = false, priority = 7)
	public void FailedOrderexecutionSingleCommand_InvalidCommandURL_XMLDevice() throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Command URL_XML Device");
		String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 8);
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, TestCaseName);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusFailed(driver);
//		SearchNBOrderMethods objSNBOM = new SearchNBOrderMethods();
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	@Test(enabled = false, priority = 8)
	public void FailedOrderexecutionSingleCommand_InvalidCommandURL_JSONDevice() throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Command URL_JSON Device");
		String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 9);
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, TestCaseName);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusFailed(driver);
//		SearchNBOrderMethods objSNBOM = new SearchNBOrderMethods();
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
//		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}

}
