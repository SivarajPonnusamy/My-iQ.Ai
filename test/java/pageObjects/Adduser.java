package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM class
public class Adduser {
	public WebDriver ldriver;
	public WebDriverWait wait;
	public By navigation_users;
	public By adduser_bt;
	public By userfirstname;
	public By userlastname;
	public By userbusinessemail;
	public By usercountry_region;
	public By btnAddnew;

	public Adduser(WebDriver rdriver) throws InterruptedException {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(rdriver,30);

	}
	// PageFactory.initElements(ldriver, Adduser.class);
	// WebDriverWait wait = new WebDriverWait(ldriver, 30);

	// By navigation_users = By.xpath("//a[normalize-space()='Users']");
	// wait.until(ExpectedConditions.visibilityOfElementLocated(navigation_users));

	@FindBy(xpath = "//a[normalize-space()='Users']")
	WebElement navigation_users1;

	@FindBy(xpath = "//button[normalize-space()='Add User']")
	WebElement adduser_bt1;
	@FindBy(xpath = "//body//div//div//div//form//div//div//div//input[@placeholder='Enter the first name']")
	WebElement userfirstname1;
	@FindBy(xpath = "//body//div//div//div//form//div//div//div//input[contains(@placeholder,'Enter the last name')]")
	WebElement userlastname1;
	@FindBy(xpath = "//body//div//div//div//form//div//div//div//input[contains(@placeholder,'patrick@email.com')]")
	WebElement userbusinessemail1;
	@FindBy(xpath = "//body//div//div//div//form//div//div//div//div//div[@role='button'][normalize-space()='Select']")
	WebElement usercountry_region1;
	@FindBy(xpath = "//button[@title='To Create the User']")
	WebElement btnAddnew1;
	
	@FindBy(xpath="//div[@role='presentation']")
	WebElement successalert;
	
	@FindBy(xpath="(//div[@role='alert'])[2]")
	WebElement alert;
	
	@FindBy(xpath="//button[@title='To Cancel']")
	WebElement cancel_bt;
	/*
	 * By userfirstname = By.xpath(
	 * "/html[1]/body[1]/div[3]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"
	 * ); wait.until(ExpectedConditions.presenceOfElementLocated(userfirstname));
	 * 
	 * By userlastname = By.xpath(
	 * "//div[@id='user-modal-root']//div//div//form//div//div//div//input[contains(@placeholder,'Enter the last name')]"
	 * ); wait.until(ExpectedConditions.presenceOfElementLocated(userlastname));
	 * 
	 * By userbusinessemail = By.xpath(
	 * "//div[@id='user-modal-root']//div//div//form//div//div//div//input[contains(@placeholder,'patrick@email.com')]"
	 * );
	 * wait.until(ExpectedConditions.presenceOfElementLocated(userbusinessemail));
	 * 
	 * By usercountry_region = By.xpath(
	 * "//div[@id='user-modal-root']//div//div//form//div//div//div//div//div[@id='mui-component-select-country']"
	 * );
	 * 
	 * By btnAddnew = By.xpath("//button[contains(@title,'To Create the User')]");
	 * wait.until(ExpectedConditions.presenceOfElementLocated(btnAddnew));
	 * 
	 * } // return wait.until(ExpectedConditions.presenceOfElementLocated(by));
	 */

	public void sidebarUsers() {
		navigation_users1.click();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(navigation_users));
		// ldriver.findElement(navigation_users).click();

		// return navigation_users;

	}

	public void adduserBt() {
		adduser_bt1.click();
		// ldriver.findElement(adduser_bt).click();

	}

	public void firstName(String firstname) {
		//userfirstname1.clear();
		userfirstname1.sendKeys(firstname);
		// ldriver.findElement(userfirstname).sendKeys(firstname);

	}

	public void lastName(String lastname) {
		//userlastname1.clear();
		userlastname1.sendKeys(lastname);
		// ldriver.findElement(userlastname).sendKeys(lastname);
	}

	public void businessEmail(String businessEmail) {
		//userbusinessemail1.clear();
		userbusinessemail1.sendKeys(businessEmail);
		// ldriver.findElement(userbusinessemail).sendKeys(businessEmail);
	}

	public void countryRegiondrpdown() {
		usercountry_region1.click();
		// ldriver.findElement(usercountry_region).click();
		List<WebElement> userscountries = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		System.out.println("Total no.of countries :" + userscountries.size());
		for (WebElement countries_list : userscountries) {

			if (countries_list.getText().equals("Australia")) {
				countries_list.click();
				break;
			}

		}

	}

	public void createnewUser() throws InterruptedException {
		btnAddnew1.click();
		// ldriver.findElement(btnAddnew).click();
		String alert_mess1 =successalert.getText();
		if (successalert.getText().contains("User added successfully")) {
			System.out.println(alert_mess1);
			Thread.sleep(3000);
		}
		else {//Email address already exists..
			String alert_mess2=alert.getText();
			System.out.println(alert_mess2);
			cancel_bt.click();
		}
	}


}
