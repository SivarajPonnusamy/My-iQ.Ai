package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

// POM
public class AdminSettings {
	
	public WebDriver ldriver;
	public WebDriverWait wait;
	
	public  AdminSettings(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(css="div[id='root'] header div span span")
	WebElement adminsettings;
	
	@FindBy(xpath="//a[normalize-space()='Settings']")
	WebElement settings;
	
	@FindBy(xpath ="//a[@href='/role-master']")
	WebElement rolemaster;
	
	@FindBy(xpath = "//button[normalize-space()='Add Role']")
	WebElement addrole;
	
	@FindBy(xpath = "//input[@placeholder='Role Name']")
	WebElement rolename;
	
	@FindBy(xpath="//textarea[@placeholder='Max. 250 characters']")
	WebElement roledescription;
	
	@FindBy(xpath="//div[3]//table[1]//thead[1]//tr[1]//th[8]//label[1]//span[1]//input[1]")
	WebElement roleinvoice;
	
	@FindBy(xpath="(//label)[3]")
	WebElement roleorgmanag;
	
	@FindBy(xpath="(//label)[4]")
	WebElement roleuser;
	
	@FindBy(xpath="(//label)[6]")
	WebElement rolereports;
	
	@FindBy(xpath="(//label)[11]")
	WebElement rolemanualupload;
	
	@FindBy(xpath="(//label)[12]")
	WebElement roledashboard;
	
	@FindBy(xpath="//button[normalize-space()='Create']")
	WebElement rolecreation;
	
	
	public void adminSettings() {
		adminsettings.click();

	}

	public void settingS() {
		settings.click();

	}

	public void roleMaster() {
		rolemaster.click();
	}

	public void addRole() {
		addrole.click();
	}
	public void roleName(String role_name) {
		rolename.sendKeys(role_name);
		
	}
	public void alertMess() {
		wait=new WebDriverWait(ldriver, 30);
		By alert_mess = By.xpath("//div[@role='alert'])[2]/ancestor::div[@role='presentation']");
		wait.until(ExpectedConditions.presenceOfElementLocated(alert_mess));
		String confirm_mess=ldriver.findElement(alert_mess).getText();
		
		System.out.println("alert_mess"+" "+confirm_mess);
		if (confirm_mess.contains("Role Name Already Exists")) {
			ldriver.navigate().refresh();
			//ldriver.findElement(By.xpath("(//a[normalize-space()='Cancel'])[1]")).click();
		}
		else {
			System.out.println("alert_mess"+" "+alert_mess);
		}
	}
	public void roleDescription(String role_des) throws InterruptedException {
		roledescription.sendKeys(role_des);
		
		if(role_des.equalsIgnoreCase("View, add,assign and approval")) {
			roleinvoice.click();
			alertMess();
		
			}
		else if(role_des.equalsIgnoreCase("User- Add, view")) {
			roleuser.click();
			alertMess();
		}
		else if(role_des.contains("View reports page")){
			rolereports.click();
			alertMess();
		}
		else if(role_des.contains("Organisation -Add, view, email and target")) {
			roleorgmanag.click();
			alertMess();
		}
		else if(role_des.contains("Manual upload and invoice view ")){
			rolemanualupload.click();
			alertMess();
		}
	}
	
	
	/*public void roleInvoice() {
		
		roleinvoice.click();
	}*/
	
	public void roleCreation() {
		rolecreation.click();
	}
	
}
