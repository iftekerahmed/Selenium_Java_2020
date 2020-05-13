package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilities.BrowserFactory;
import Utilities.ConfigDataProvider;
import Utilities.ExcelDataProvider;
import Utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports reports;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() throws Exception {
		Reporter.log("Setting Up reports and test started ", true);

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Report/FreeCRM"+Helper.getCurrentDateTime()+".html"));
		reports = new ExtentReports() ;
		reports.attachReporter(extent);
		Reporter.log("Setting done - test can be start ", true);

	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getqaUrl());
		System.out.println(driver.getTitle());
	}

	@AfterClass
	public void tearDown() {

		BrowserFactory.quitBrowser(driver);

	}

	@AfterMethod
	public void  tearDownMethod(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenShot(driver);
			logger.fail("Testcase fail", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			//logger.fail("TestCase Fail", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.captureScreenShot(driver)).build());
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			
		}
		reports.flush();
	
	}
}
