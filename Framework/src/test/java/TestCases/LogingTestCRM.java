package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.LoginPage;
import Utilities.BrowserFactory;
import Utilities.ExcelDataProvider;
import Utilities.Helper;

public class LogingTestCRM extends BaseClass {
	ExcelDataProvider excel;

	@Test
	public void loginApps() throws Exception {
		logger = reports.createTest("Login to CRM ");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Start Application ");
		loginPage.logingToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		Helper.captureScreenShot(driver);

		logger.pass("Login success");
		
		
		
	}

}
