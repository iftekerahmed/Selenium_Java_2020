package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(name = "username")
	WebElement uname;
	@FindBy(name = "password")
	WebElement pass;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginButton;

	public void logingToCRM(String usernameApplication, String passwordApplication) throws Exception {
		Thread.sleep(2000);
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginButton.click();

	}

}
