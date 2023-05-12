package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//POM class
public class Loginpage {

	public WebDriver ldriver;
	public WebDriverWait wait;

	public Loginpage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver,30);
		rdriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@FindBy(name = "login_email")
	WebElement login;

	@FindBy(name = "login_password")
	WebElement pwd;

	@FindBy(xpath = "//button[@title='login']")
	WebElement loginbt;

	public void setBusiness_email(String business_email) {
		wait.until(ExpectedConditions.visibilityOf(login));
		login.clear();
		login.sendKeys(business_email);

	}

	public void setPwd(String password) {
		wait.until(ExpectedConditions.visibilityOf(pwd));
		pwd.clear();
		pwd.sendKeys(password);

	}

	public void login_bt() {
		wait.until(ExpectedConditions.visibilityOf(loginbt));
		loginbt.click();

	}

}
