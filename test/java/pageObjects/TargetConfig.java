package pageObjects;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class TargetConfig {
	public WebDriver ldriver;
	public TargetConfig(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		}
	@FindBy(xpath="//a[normalize-space()='Organisation']")
	WebElement navigation_org;
	
	@FindBy(xpath="//select[@name='orgInt']")
	WebElement target;
	
	@FindBy(xpath="//h4[normalize-space()='Target']")
	WebElement erp;
	@FindBy(xpath="//input[@placeholder='https://www.example.com']") 
	WebElement url;
	@FindBy(xpath="//input[@placeholder='Enter the Username']")
	WebElement username;
	@FindBy(xpath="//input[@placeholder='• • • • • •']")
	WebElement pwd;
	@FindBy(xpath="//button[@title='Save']")
	WebElement saveerp;
	
	public void sidebarOrg() {
		navigation_org.click();
	}
	
	
	public void orgList() {
		List<WebElement> orglist = ldriver.findElements(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div"));
		int orgcount = orglist.size();
		System.out.println(orgcount);
		for(WebElement orglisting:orglist) {
			System.out.println(orglisting.getText());
			if(orglisting.getText().equalsIgnoreCase("ZZDaikin pvt ltd \n"
					+ "www.zzdaikin.com\n"+ "United Kingdom")) {
				orglisting.click();
				break;
			}
			
		}

	}
	
	

	
	public void targetConfig() {
		target.click();
		Select dropdown = new Select(target);
		dropdown.selectByVisibleText("SAP");
		}
	
		public void erpConfig() {
			erp.click();
		}
		public void urL() {
			url.clear();
			url.sendKeys("http://49.206.196.104:8080?sap-client=001");
		}
		public void erpUsername() {
			username.clear();
			username.sendKeys("odatatest");
		}
		public void erpPwd() {
			pwd.clear();
			pwd.sendKeys("Test@123");
		}
		public void erpSave() {
			saveerp.click();
		}
		

}
