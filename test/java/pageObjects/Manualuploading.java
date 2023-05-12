package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Manualuploading {
	public WebDriver ldriver;
	public WebDriverWait wait;

	public Manualuploading(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Upload']")
	WebElement navigation_manualuploading;
	
	@FindBy(xpath="//div[@id='mui-component-select-orgName']")
	WebElement orglayout;
	
	@FindBy(xpath="//input[@name='image']")
	WebElement uploadfiles;
	
	@FindBy(xpath = "//button[normalize-space()='Submit']")   //button[@title='To manually upload the Invoices']
	WebElement upload_bt;
	
	@FindBy(xpath ="//button[normalize-space()='Ok']")
	WebElement confirm_mess;

	public void sidebarManual() {
		navigation_manualuploading.click();
	}
	
	public void orgLayout() throws InterruptedException {
		orglayout.click();
		List<WebElement> org_layout = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));

		for (WebElement organisation : org_layout) {
			if (organisation.getText().equalsIgnoreCase("ZZDaikin pvt ltd"))

			{
				organisation.click();
				
				/*wait = new WebDriverWait(ldriver, 30);
				WebElement lay_org = wait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//li[@name='organisation_name'and @xpath='1']")));
				lay_org.click();*/
			
			} 
			
		}

	}
	
	public void uploadFiles() {
		uploadfiles.sendKeys("/Users/sivaraj/Downloads/pp/Consolidated_Company_wise_list/21_Century_Fleet_Systems/21st Centuary- 315911.pdf"+"\n"+
	"/Users/sivaraj/Downloads/pp/Consolidated_Company_wise_list/Abbey_Hose/Abbey Hose - 311826.pdf"+"\n"+""
			+ "/Users/sivaraj/Downloads/pp/Consolidated_Company_wise_list/4imprint/4 imprint - DM-1384086.pdf");
	}
	
	public void uploadBt() {
		upload_bt.click();
	}
	
	public void confirmationMess() {
		confirm_mess.click();
	}

}
