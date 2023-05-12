package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM
public class Addorganisation {

	public WebDriver ldriver;
	public WebDriverWait wait;

	public Addorganisation(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Organisation']")
	WebElement navigation_org;

	@FindBy(xpath = "//button[normalize-space()='Add Organisation']")
	WebElement addorg_bt;

	@FindBy(xpath = "//input[@placeholder='www.domainname.com']")
	WebElement org_domain_name;

	@FindBy(xpath = "//input[@placeholder='Enter your Organisation Name']")
	WebElement org_name;

	@FindBy(xpath = "//input[@placeholder='Enter the register number']")
	WebElement reg_no;

	@FindBy(xpath = "//input[@placeholder='Enter the Address']")
	WebElement address;

	@FindBy(xpath = "//div[normalize-space()='Select']")
	WebElement org_country;

	@FindBy(xpath = "(//button[@title='To Create the Organisation'])[1]")
	WebElement btnaddneworg;
	
	@FindBy(xpath = "(//div[@role='alert'])[1]")
	WebElement alert;
	
	//@FindBy(xpath="(//div[@role='alert'])[1]")
	//WebElement failurealert;
	
	@FindBy(xpath="//body/div/div[4]/span[1]/img[@alt='whiteClose']")
	WebElement close_bt;
	
	@FindBy(xpath="(//u[normalize-space()='Click to add'])[1]")
	WebElement addorglink;

	public void sidebarOrg() {
		navigation_org.click();

	}

	public void addorgBt() {
		addorg_bt.click();

	}

	public void orgDomainName(String orgdomainname) {
		org_domain_name.sendKeys(orgdomainname);
	}

	public void orgName(String orgname) {
		org_name.sendKeys(orgname);
	}

	public void regNo(String regno) {
		reg_no.sendKeys(regno);
	}

	public void Address(String address1) {
		address.sendKeys(address1);
	}

	public void orgCountry() {
		org_country.click();
		List<WebElement> orgcountries = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for (WebElement orgcountries_list : orgcountries) {

			if (orgcountries_list.getText().equalsIgnoreCase("United Kingdom")) {
				orgcountries_list.click();
				break;
			}

		}

	}

	public void btncreatenewOrg() throws InterruptedException {
		/*wait=new WebDriverWait(ldriver,40);
	    WebElement createbutton	=ldriver.findElement(By.xpath("(//button[@title='To Create the Organisation'])[1]"));
		wait.until(ExpectedConditions.elementToBeSelected(createbutton));
		createbutton.click();*/
		
		WebElement createbutton	=ldriver.findElement(By.xpath("(//button[@title='To Create the Organisation'])[1]"));
		JavascriptExecutor executor=(JavascriptExecutor)ldriver;
		executor.executeScript("arguments[0].click();",createbutton);
		
		alertMess();
		Thread.sleep(3000);

	}
	public void addorgBts() {
		addorg_bt.click();
		
	}
	public void addorgLink() {
		addorglink.click();
	}
	public void refresH() {
		ldriver.navigate().refresh();
	}
	
	public void alertMess() throws InterruptedException {
		wait=new WebDriverWait(ldriver,40);
		By alertmess=By.xpath("//div[@role='alert']/ancestor::div[@role='presentation']");
		wait.until(ExpectedConditions.presenceOfElementLocated(alertmess));
		String alert_mess 	=ldriver.findElement(alertmess).getText();
		//String alert_mess = alert.getText();
		Thread.sleep(3000);
		System.out.println("poda itha mess"+" "+alert_mess);
		if (alert_mess.equalsIgnoreCase("New organisation has been created successfully.")) 
		{
			System.out.println(alert_mess);
			//addorgBts();
			Thread.sleep(4000);
		} else {
			System.out.println(alert_mess);
			close_bt.click();
			Thread.sleep(3000);
			refresH();
			//addorgBts();
			//addorgLink();
			Thread.sleep(3000);

		}

	}

}
