package E2ETestCases.dSP;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.excel.utility.Xls_Reader;
import com.navigation.ConfigurationNav;
import com.navigation.ExecutionNav;
import com.navigation.HomepageNav;
import com.navigation.NBReqTrackDetails;
import com.navigation.ReportsNav;
import com.resources.base;
import com.reusableComponents.CommandListMethods;

import com.reusableComponents.NBResponseDetailsMethods;
import com.reusableComponents.NBSimulatorAddRequestMethods;
import com.reusableComponents.ProRequestMethods;
import com.reusableComponents.ReloadCacheMethods;
import com.reusableComponents.SearchNBOrderMethods;
import com.reusableComponents.ServiceOrderMethods;
import com.reusableComponents.ServiceOrderPageMethods;
import com.reusableComponents.UpdateCommandMethods;
import com.reusableComponents.UpdateSBDeviceMethods;
import com.reusableComponents.nbReqTrackDetailsMethods;
import com.reusableComponents.searchSBDeviceMethods;
import com.reusableComponents.singleCommandExecutionMethods;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import reusableMethods.CustomeListeners;
import reusableMethods.Utilities;

@Listeners(CustomeListeners.class)
public class regression_One extends base {

	Logger log = Logger.getLogger(Utilities.class);

	Xls_Reader TCName = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestCaseName.xlsx");

	Xls_Reader objTestData = new Xls_Reader(".\\src\\main\\java\\com\\testdata\\TestDataForExecution.xlsx");
	
	
	
	
	
	//Pass
	@Test(enabled = true, priority = 1, description = "TestOne_TestNGProject")
	@Severity(SeverityLevel.NORMAL)
	@Description("TestOne_AllureProject : First Test Case")
	@Story("Story Name : To check the Single Command Execution")
	@Epic("Epic 1")
	@Feature("Feature 1")
	public void SuccessfulOrderexecutionSingleCommand_XMLRequest() throws IOException, InterruptedException {
		log.info("Successful Order execution_Single Command_XML Request");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 2).trim();
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		System.out.println("Row"+row);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, row);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusCompleted(driver);
		SearchNBOrderMethods objSNBOM = new SearchNBOrderMethods();
		objSNBOM.openServiceOrderWithNBOrderID(driver);
		ServiceOrderMethods objSOM = new ServiceOrderMethods();
		objSOM.verifyProvisioninggResponseCodeAs0(driver, row);
		// objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Mostly Pass
	@Severity(SeverityLevel.BLOCKER)
	@Description("TestOne_AllureProject : Second Test Case")
	@Story("Story Name : To check the Single Command Execution_2")
	@Test(enabled = false, priority = 2)
	public void SuccessfulOrderexecutionSingleCommand_JSONRequest() throws IOException, InterruptedException {
		log.info("Successful Order execution_Single Command_JSON Request");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 3);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, row);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusCompleted(driver);
		SearchNBOrderMethods objSNBOM = new SearchNBOrderMethods();
		objSNBOM.openServiceOrderWithNBOrderID(driver);
		ServiceOrderMethods objSOM = new ServiceOrderMethods();
		objSOM.verifyProvisioninggResponseCodeAs0(driver, row);
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	//Pass
	@Severity(SeverityLevel.CRITICAL)
	@Description("TestOne_AllureProject : Third Test Case")
	@Story("Story Name : To check the Single Command Execution_3")
	@Test(enabled = false, priority = 3)
	public void FailedOrderexecutionSingleCommand_InvalidInput_XMLDevice() throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Input_XML Device");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 4);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, row);
		objSCEM.verifyFailedServiceOrderMessage(driver);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Severity(SeverityLevel.CRITICAL)
	@Description("TestOne_AllureProject : Fourth Test Case")
	@Story("Story Name : To check the Single Command Execution_4")
	@Test(enabled = false, priority = 4)
	public void FailedOrderexecutionSingleCommand_InvalidInput_JSONDevice() throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Input_JSON Device");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 5);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); 
		// Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, row);
		objSCEM.verifyFailedServiceOrderMessage(driver);
		driver.close();
		log.info("Successfully Tested");
	}

	//Pass
	@Test(enabled = false, priority = 5)
	public void FailedOrderexecutionSingleCommand_InvalidProvisioningURL_XMLDevice()
			throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Provisioning URL_XML Device");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 6);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToConfiguration(driver);
		ConfigurationNav objCN = new ConfigurationNav();
		objCN.navigateToSearchSBDevie(driver);
		searchSBDeviceMethods objSSBDM = new searchSBDeviceMethods();
		objSSBDM.searchAndOpenSBDevice(driver, row);
		UpdateSBDeviceMethods objUSBDM = new UpdateSBDeviceMethods();
		objUSBDM.updateProvisioningURL(driver, row);
		objCN.navigateToReloadCache(driver);
		ReloadCacheMethods objRCM = new ReloadCacheMethods();
		objRCM.reloadGeneralCache(driver);
		objRCM.reloadProcessFlowCache(driver);
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, row);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusFailed(driver);
		hpn.navigateToConfiguration(driver);
		objCN.navigateToSearchSBDevie(driver);
		objSSBDM.searchAndOpenSBDevice(driver, row);
		objUSBDM.setBackProvisioningURL(driver, row);
		objCN.navigateToReloadCache(driver);
		objRCM.reloadGeneralCache(driver);
		objRCM.reloadProcessFlowCache(driver);
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Mostly Pass
	@Test(enabled = false, priority = 6)
	public void FailedOrderexecutionSingleCommand_InvalidProvisioningURL_JSONDevice()
			throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Provisioning URL_JSON Device");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 7);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToConfiguration(driver);
		ConfigurationNav objCN = new ConfigurationNav();
		objCN.navigateToSearchSBDevie(driver);
		searchSBDeviceMethods objSSBDM = new searchSBDeviceMethods();
		objSSBDM.searchAndOpenSBDevice(driver, row);
		UpdateSBDeviceMethods objUSBDM = new UpdateSBDeviceMethods();
		objUSBDM.updateProvisioningURL(driver, row);
		objCN.navigateToReloadCache(driver);
		ReloadCacheMethods objRCM = new ReloadCacheMethods();
		objRCM.reloadGeneralCache(driver);
		objRCM.reloadProcessFlowCache(driver);
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, row);
		
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusFailed(driver);
		hpn.navigateToConfiguration(driver);
		objCN.navigateToSearchSBDevie(driver);
		objSSBDM.searchAndOpenSBDevice(driver, row);
		objUSBDM.setBackProvisioningURL(driver, row);
		objCN.navigateToReloadCache(driver);
		objRCM.reloadGeneralCache(driver);
		objRCM.reloadProcessFlowCache(driver);
	
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	
	
	//In progress
	//Activate-Reactivate is needs to be modified
	@Test(enabled = false, priority = 7)
	public void FailedOrderexecutionSingleCommand_InvalidCommandURL_XMLDevice()
			throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Command URL_XML Device");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 8);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		Thread.sleep(30000);
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToConfiguration(driver);
		ConfigurationNav objCN = new ConfigurationNav();
		objCN.navigateToSearchSBDevie(driver);
		searchSBDeviceMethods objSSBDM = new searchSBDeviceMethods();
		objSSBDM.searchAndOpenCommandList(driver, row);
		CommandListMethods objCLM = new CommandListMethods();
		objCLM.searchAndOpenCommand(driver, row);
		UpdateCommandMethods objUCM = new UpdateCommandMethods();
		objUCM.updateCommandURL(driver, row);
		Thread.sleep(3000);
		objCLM.searchCommand(driver, row);
		objCLM.activateReactivateCommandDBLookupYes(driver, row);
		objCN.navigateToReloadCache(driver);
		ReloadCacheMethods objRCM = new ReloadCacheMethods();
		objRCM.reloadGeneralCache(driver);
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, row);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusFailed(driver);
		hpn.navigateToConfiguration(driver);
		objCN.navigateToSearchSBDevie(driver);
		objSSBDM.searchAndOpenCommandList(driver, row);
		objCLM.searchAndOpenCommand(driver, row);
		objUCM.setBackCommandURL(driver, row);
		Thread.sleep(3000);
		objCLM.searchCommand(driver, row);
		//objCLM.activateReactivateCommand(driver, row);
		objCN.navigateToReloadCache(driver);
		objRCM.reloadGeneralCache(driver);
		
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Same as TC7
	@Test(enabled = false, priority = 8)
	public void FailedOrderexecutionSingleCommand_InvalidCommandURL_JSONDevice()
			throws IOException, InterruptedException {
		log.info("Failed Order execution_Single Command_Invalid Command URL_JSON Device");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 9);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToConfiguration(driver);
		ConfigurationNav objCN = new ConfigurationNav();
		objCN.navigateToSearchSBDevie(driver);
		searchSBDeviceMethods objSSBDM = new searchSBDeviceMethods();
		objSSBDM.searchAndOpenCommandList(driver, row);
		CommandListMethods objCLM = new CommandListMethods();
		objCLM.searchAndOpenCommand(driver, row);
		UpdateCommandMethods objUCM = new UpdateCommandMethods();
		objUCM.updateCommandURL(driver, row);
		objCLM.activateReactivateCommandDBLookupYes(driver, row);
		objCN.navigateToReloadCache(driver);
		ReloadCacheMethods objRCM = new ReloadCacheMethods();
		objRCM.reloadGeneralCache(driver);
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		driver = objSCEM.invokeSingleCommand(driver, row);
		driver = objSCEM.clickOK(driver);
		ServiceOrderPageMethods objSOPM = new ServiceOrderPageMethods();
		objSOPM.getExternalRefrenceID(driver);
		objSOPM.verifyServiceOrderStatusFailed(driver);
		hpn.navigateToConfiguration(driver);
		objCN.navigateToSearchSBDevie(driver);
		objSSBDM.searchAndOpenCommandList(driver, row);
		objCLM.searchAndOpenCommand(driver, row);
		objUCM.setBackCommandURL(driver, row);
		objCLM.activateReactivateCommandDBLookupYes(driver, row);
		objCN.navigateToReloadCache(driver);
		objRCM.reloadGeneralCache(driver);
//		objSNBOM.openServiceOrderWithNBOrderID(driver);
//		objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName);
//		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Mostly Pass
	@Test(enabled = false, priority = 9)
	public void SuccessfulNBOrderRequest_JMSXML() throws IOException, InterruptedException {
		log.info("Successful NB Order Request_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 10);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);

		/*
		 * String TestCaseName = TCName.getCellData("TestCases", "TestCaseName", 9);
		 * driver = util.loginMethod(); driver = hpn.navigateToExecution(driver);
		 * driver = objEN.navigateToSingleCommandExecution(driver); // Thread.sleep(3000);
		 * singleCommandExecutionMethods objSCEM = new singleCommandExecutionMethods();
		 * 
		 * driver = objSCEM.invokeSingleCommand(driver, TestCaseName); driver =
		 * objSCEM.clickOK(driver);  objSOPM.getExternalRefrenceID(driver);
		 * objSOPM.verifyServiceOrderStatusFailed(driver);  //
		 * objSNBOM.openServiceOrderWithNBOrderID(driver); //
		 * objSNBOM.verifyProvisioningResponseCode(driver, TestCaseName); //
		 * Thread.sleep(10000);
		 * 
		 * 
		 */
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Mostly Pass
	@Test(enabled = false, priority = 10)
	public void FailedNBOrderRequest_InvalidRequest_JMSXML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Request_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 11);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));

		driver.close();
		log.info("Successfully Tested");
	}
	
	//Mostly Pass
	@Test(enabled = false, priority = 11)
	public void SuccessfulNBOrderRequest_JMSJSON() throws IOException, InterruptedException {
		log.info("Successful NB Order Request_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 12);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		
		
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);
		
		
		
		driver.close();
		log.info("Successfully Tested");
	}


	//Mostly Pass
	@Test(enabled = true, priority = 12)
	public void FailedNBOrderRequest_InvalidRequest_JMSJSON() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Request_JMS JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 13);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		System.out.println("Row Number" + row);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));

		driver.close();
		log.info("Successfully Tested");
	}

	
	//Mostly Pass
	@Test(enabled = false, priority = 13)
	public void SuccessfulNBOrderRequest_RESTASYNCXML() throws IOException, InterruptedException {
		log.info("Successful NB Order Request_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 14);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		
		
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);
		
		
		
		driver.close();
		log.info("Successfully Tested");
	}


	//Mostly Pass
	@Test(enabled = false, priority = 14)
	public void FailedNBOrderRequest_InvalidRequest_RestAsync_XML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Request_Rest Async_XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 15);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));

		driver.close();
		log.info("Successfully Tested");
	}
	
	
	//Mostly Pass
	@Test(enabled = false, priority = 15)
	public void SuccessfulNBOrderRequest_RESTASYNCJSON() throws IOException, InterruptedException {
		log.info("Successful NB Order Request_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 16);
		
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);

		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);
		
		driver.close();
		log.info("Successfully Tested");
	}

	


	//Mostly Pass
	@Test(enabled = false, priority = 16)
	public void FailedNBOrderRequest_InvalidRequest_RestAsync_JSON() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Request_Rest Async_JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 17);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));

		driver.close();
		log.info("Successfully Tested");
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////// ********************************/////////////////////////////////////////////////////////////////

	//////////////////////////////////////// 22/07/2020
	//////////////////////////////////////// /////////////////////////////////////////////////////////////

	
	//Pass
	@Test(enabled = false, priority = 17)
	public void SuccessfulNBOrderRequest_JMSXML_SBDevice_SOAP() throws IOException, InterruptedException {
		log.info("Successful NB Order Request_JMS XML_SBDevice_SOAP");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 18);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);
		
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}

	//Pass
	@Test(enabled = false, priority = 18)
	public void FailedNBOrderRequest_InvalidRequest_JMSXML_SBDevice_SOAP() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Request_JMS XML_SBDevice_SOAP");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 19);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));

		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Test(enabled = false, priority = 19)
	public void SuccessfulNBOrderRequest_JMSJSON_SBDevice_SOAP() throws IOException, InterruptedException {
		log.info("Successful NB Order Request_JMS JSON_SBDevice_SOAP");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 20);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);
		Thread.sleep(10000);

		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Test(enabled = false, priority = 20)
	public void FailedNBOrderRequest_InvalidRequest_JMSJSON_SBDevice_SOAP() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Request_JMS JSON_SBDevice_SOAP");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 21);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		System.out.println("Row Number" + row);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));

		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Test(enabled = false, priority = 21)
	public void SuccessfulNBOrderRequest_RESTASYNCXML_SBDevice_SOAP() throws IOException, InterruptedException {
		log.info("Successful NB Order Request_JMS XML_SBDevice_SOAP");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 22);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Test(enabled = false, priority = 22)
	public void FailedNBOrderRequest_InvalidRequest_RestAsync_XML_SBDevice_SOAP()
			throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Request_Rest Async_XML_SBDevice_SOAP");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 23);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Test(enabled = false, priority = 23)
	public void SuccessfulNBOrderRequest_RESTASYNCJSON_SBDevice_SOAP() throws IOException, InterruptedException {
		log.info("Successful NB Order Request_REST ASYNC_JSON_SBDevice_SOAP");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 24);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Test(enabled = false, priority = 24)
	public void FailedNBOrderRequest_InvalidRequest_RestAsync_JSON_SBDevice_SOAP()
			throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Request_Rest Async_JSON_SBDevice_SOAP");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 25);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		driver.close();
		log.info("Successfully Tested");
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	///////////////////////// ********************************/////////////////////////////////////////////////////////////////

	//////////////////////////////////////// 23/07/2020
	//////////////////////////////////////// /////////////////////////////////////////////////////////////
	
	//Mostly pass - Couldn't able to test as xml request was not getting processed
	@Test(enabled = false, priority = 25)
	public void FailedNBOrderRequest_DuplicateOrderID_JMSXML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Duplicate OrderID_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 26);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		driver = hpn.navigateToExecution(driver);
		objEN.navigateToNBSimulators(driver);
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		driver = objRN.navigateToNbReqResponseTracking(driver);
		objNRTDM.searchWithNBOrderID(driver, row);
		List<WebElement> count = driver.findElements(By.xpath("//*[text()='Completed']"));
		Assert.assertEquals(count.size(), 1);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Test(enabled = false, priority = 26)
	public void FailedNBOrderRequest_DuplicateOrderID_RestAsync_JSON() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Duplicate OrderID_Rest Async_JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 27);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		driver = hpn.navigateToExecution(driver);
		objEN.navigateToNBSimulators(driver);
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		driver = objRN.navigateToNbReqResponseTracking(driver);
		objNRTDM.searchWithNBOrderID(driver, row);
		List<WebElement> count = driver.findElements(By.xpath("//*[text()='Completed']"));
		Assert.assertEquals(count.size(), 2);
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Mostly Pass - Couldn't able to test as xml request was not getting processed
	@Test(enabled = false, priority = 27)
	public void FailedNBOrderRequest_IncorrectProvisioningURL_JMSXML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Incorrect Provisioning URL_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 28);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToConfiguration(driver);
		ConfigurationNav objCN = new ConfigurationNav();
		objCN.navigateToSearchSBDevie(driver);
		searchSBDeviceMethods objSSBDM = new searchSBDeviceMethods();
		objSSBDM.searchAndOpenSBDevice(driver, row);
		UpdateSBDeviceMethods objUSBDM = new UpdateSBDeviceMethods();
		objUSBDM.updateProvisioningURL(driver, row);
		objCN.navigateToReloadCache(driver);
		ReloadCacheMethods objRCM = new ReloadCacheMethods();
		objRCM.reloadGeneralCache(driver);
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsFailed(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		
		
		hpn.navigateToConfiguration(driver);
		objCN.navigateToSearchSBDevie(driver);
		objSSBDM.searchAndOpenSBDevice(driver, row);
		objUSBDM.setBackProvisioningURL(driver, row);
		objCN.navigateToReloadCache(driver);
		objRCM.reloadGeneralCache(driver);
		
		
		driver.close();
		log.info("Successfully Tested");
	}

	//Pass
	@Test(enabled = false, priority = 28)
	public void FailedNBOrderRequest_IncorrectProvisioningURL_RestAsync_JSON()
			throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Incorrect Provisioning URL_Rest Async_JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 29);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToConfiguration(driver);
		ConfigurationNav objCN = new ConfigurationNav();
		objCN.navigateToSearchSBDevie(driver);
		searchSBDeviceMethods objSSBDM = new searchSBDeviceMethods();
		objSSBDM.searchAndOpenSBDevice(driver, row);
		UpdateSBDeviceMethods objUSBDM = new UpdateSBDeviceMethods();
		objUSBDM.updateProvisioningURL(driver, row);
		objCN.navigateToReloadCache(driver);
		ReloadCacheMethods objRCM = new ReloadCacheMethods();
		objRCM.reloadGeneralCache(driver);
		
		
		
		
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsFailed(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		
		
		hpn.navigateToConfiguration(driver);
		objCN.navigateToSearchSBDevie(driver);
		objSSBDM.searchAndOpenSBDevice(driver, row);
		objUSBDM.setBackProvisioningURL(driver, row);
		objCN.navigateToReloadCache(driver);
		objRCM.reloadGeneralCache(driver);
		
		driver.close();
		log.info("Successfully Tested");
	}

	//Mostly Pass - Couldn't able to test as xml request was not getting processed
	@Test(enabled = false, priority = 29)
	public void FailedNBOrderRequest_IncorrectCommandURL_JMSXML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Incorrect Command URL_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 30);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToConfiguration(driver);
		ConfigurationNav objCN = new ConfigurationNav();
		objCN.navigateToSearchSBDevie(driver);
		searchSBDeviceMethods objSSBDM = new searchSBDeviceMethods();
		objSSBDM.searchAndOpenCommandList(driver, row);
		CommandListMethods objCLM = new CommandListMethods();
		objCLM.searchAndOpenCommand(driver, row);
		UpdateCommandMethods objUCM = new UpdateCommandMethods();
		objUCM.updateCommandURL(driver, row);
		Thread.sleep(3000);
		objCLM.searchCommand(driver, row);
		objCLM.activateReactivateCommandDBLookupYes(driver, row);
		objCN.navigateToReloadCache(driver);
		ReloadCacheMethods objRCM = new ReloadCacheMethods();
		objRCM.reloadGeneralCache(driver);
		
		
		
		
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsFailed(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		objRN.navigateToNbReqTrackingDetails(driver);
		objNBRTD.navigateToProReq(driver);
		Thread.sleep(3000);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsDeviceCommunicationfailure(driver, row);
		
		
		hpn.navigateToConfiguration(driver);
		objCN.navigateToSearchSBDevie(driver);
		objSSBDM.searchAndOpenCommandList(driver, row);
		objCLM.searchAndOpenCommand(driver, row);
		objUCM.setBackCommandURL(driver, row);
		Thread.sleep(3000);
		objCLM.searchCommand(driver, row);
		objCLM.activateReactivateCommandDBLookupYes(driver, row);
		objCN.navigateToReloadCache(driver);
		objRCM.reloadGeneralCache(driver);
		
		
		driver.close();
		log.info("Successfully Tested");
	}

	
	//Pass
	@Test(enabled = false, priority = 30)
	public void FailedNBOrderRequest_IncorrectCommandURL_RestAsync_JSON()
			throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Incorrect Command URL_Rest Async_JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 31);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToConfiguration(driver);
		ConfigurationNav objCN = new ConfigurationNav();
		objCN.navigateToSearchSBDevie(driver);
		searchSBDeviceMethods objSSBDM = new searchSBDeviceMethods();
		objSSBDM.searchAndOpenCommandList(driver, row);
		CommandListMethods objCLM = new CommandListMethods();
		objCLM.searchAndOpenCommand(driver, row);
		UpdateCommandMethods objUCM = new UpdateCommandMethods();
		objUCM.updateCommandURL(driver, row);
		Thread.sleep(3000);
		objCLM.searchCommand(driver, row);
		objCLM.activateReactivateCommandDBLookupYes(driver, row);
		objCN.navigateToReloadCache(driver);
		ReloadCacheMethods objRCM = new ReloadCacheMethods();
		objRCM.reloadGeneralCache(driver);
		
		
		
		
		
		
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsFailed(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		objRN.navigateToNbReqTrackingDetails(driver);
		objNBRTD.navigateToProReq(driver);
		Thread.sleep(3000);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsDeviceCommunicationfailure(driver, row);
		

		hpn.navigateToConfiguration(driver);
		objCN.navigateToSearchSBDevie(driver);
		objSSBDM.searchAndOpenCommandList(driver, row);
		objCLM.searchAndOpenCommand(driver, row);
		objUCM.setBackCommandURL(driver, row);
		Thread.sleep(3000);
		objCLM.searchCommand(driver, row);
		objCLM.activateReactivateCommandDBLookupYes(driver, row);
		objCN.navigateToReloadCache(driver);
		objRCM.reloadGeneralCache(driver);
		
		
		
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////--------------------------------///////////////////////////////////////
	///////////////////////////////////                  07/28/2020            ////////////////////////////////////////////////////
	////////////////////////////////////////////////////////--------------------------------///////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	

	
	
	
	
	//Mostly Pass
	@Test(enabled = false, priority = 31)
	public void FailedNBOrderRequest_WithoutOrderID_JMSXML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Without OrderID_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 32);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithSBIMSI(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	//Pass
	@Test(enabled = false, priority = 32)
	public void FailedNBOrderRequest_WithoutOrderID_RestAsync_JSON() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Without OrderID_Rest Async_JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 33);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithSBIMSI(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	
	//Pass
	@Test(enabled = false, priority = 33)
	public void FailedNBOrderRequest_SyntacticalErrors_JMSXML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Syntactical Errors_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 34);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		objNBSARM.checkSyntaticalError(driver);
		
		driver.close();
		log.info("Successfully Tested");
	}
	
	//Pass
	@Test(enabled = false, priority = 34)
	public void FailedNBOrderRequest_SyntaticalErrors_JMSJSON() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Syntatical Errors_JMS JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 35);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		objNBSARM.checkSyntaticalError(driver);
		
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	//Pass
	@Test(enabled = false, priority = 35)
	public void FailedNBOrderRequest_SyntaticalErrors_RestAsync_XML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Syntatical Errors_Rest Async_XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 36);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		objNBSARM.checkSyntaticalError(driver);
		
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	//Pass
	@Test(enabled = false, priority = 36)
	public void FailedNBOrderRequest_SyntaticalErrors_RestAsync_JSON() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Syntatical Errors_Rest Async_JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 37);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		objNBSARM.checkSyntaticalError(driver);
		
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	//Mostly Pass
	@Test(enabled = false, priority = 37)
	public void FailedNBOrderRequest_InvalidData_JMSXML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Data_JMS XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 38);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	//Pass
	@Test(enabled = false, priority = 38)
	public void FailedNBOrderRequest_InvalidData_JMSJSON() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Data_JMS JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 39);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}
	
	//Mostly pass
	@Test(enabled = false, priority = 39)
	public void FailedNBOrderRequest_InvalidData_RestAsync_XML() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Data_Rest Async_XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 40);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	//Pass
	@Test(enabled = false, priority = 40)
	public void FailedNBOrderRequest_InvalidData_RestAsync_JSON() throws IOException, InterruptedException {
		log.info("Failed NB Order Request_Invalid Data_Rest Async_JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 41);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsRejected(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToNBResponseDetails(driver);
		NBResponseDetailsMethods objNBRD = new NBResponseDetailsMethods();
		String nbResponse = objNBRD.getResponseXML(driver);
		assertTrue(nbResponse.contains(objTestData.getCellData("TestCaseData", "NBResponseContains", row)));
		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	
	//Mostly Pass
	@Test(enabled = false, priority = 55)
	public void PastScheduledproperty_NBOrderRequest_RestAsync_XML() throws IOException, InterruptedException {
		log.info("Past Scheduled property_NB Order Request_Rest Async_XML");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 56);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);
		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);

		Thread.sleep(10000);
		driver.close();
		log.info("Successfully Tested");
	}

	//Pass
	@Test(enabled = false, priority = 56)
	public void PastScheduledproperty_NBOrderRequest_RestAsync_JSON() throws IOException, InterruptedException {
		log.info("Past Scheduled property_NB Order Request_Rest Async_JSON");
		String TestCaseName = objTestData.getCellData("TestCaseData", "TestCaseName", 42);
		System.out.println(TestCaseName);
		Utilities util = new Utilities();
		int row = util.findRowForTestData(driver, TestCaseName);
		
		System.out.println("Row:"+row);
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		driver = hpn.navigateToExecution(driver);
		ExecutionNav objEN = new ExecutionNav();
		objEN.navigateToNBSimulators(driver);
		NBSimulatorAddRequestMethods objNBSARM = new NBSimulatorAddRequestMethods();
		objNBSARM.addNBRequestInSystem(driver, row);

		driver = hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNRTDM = new nbReqTrackDetailsMethods();
		objNRTDM.searchWithNBOrderID(driver, row);
		objNRTDM.verifyStatusAsCompleted(driver);
		NBReqTrackDetails objNBRTD = new NBReqTrackDetails();
		objNBRTD.navigateToProReq(driver);
		ProRequestMethods objPRM = new ProRequestMethods();
		objPRM.verifyProReqRespStatusAsProcessed(driver);
		
		driver.close();
		log.info("Successfully Tested");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test(enabled = false)
	public void Test1() throws IOException, InterruptedException {
		Utilities util = new Utilities();
		driver = util.loginMethod();
		HomepageNav hpn = new HomepageNav();
		hpn.navigateToReports(driver);
		ReportsNav objRN = new ReportsNav();
		objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNBRTD = new nbReqTrackDetailsMethods();
		objNBRTD.clearTime(driver);
		objNBRTD.searchWithServiceOrderID(driver);
		// driver = objNBReqResponseTrackDetails.searchWithNBOrderID(driver);
		objNBRTD.verifyStatusAsCompleted(driver);
		
		//objNBRTD.navigateToProReq(driver);
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
		ReportsNav objRN = new ReportsNav();
		driver = objRN.navigateToNbReqResponseTracking(driver);
		nbReqTrackDetailsMethods objNBRTD = new nbReqTrackDetailsMethods();
		driver = objNBRTD.clearTime(driver);
		driver = objNBRTD.searchWithServiceOrderID(driver);
		//driver = objNBRTD.navigateToNBResponseDetails(driver);
		
		//String responseXML = objNBResponseDetails.getResponseXML(driver);
		// driver = objNBReqResponseTrackDetails.searchWithNBOrderID(driver);
		//System.out.println(responseXML);
		// Thread.sleep(5000);
		// Assert.assertTrue(responseXML.contains("<STATUS_FLAG>0")); driver.close();
	}

}
