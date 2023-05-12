package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AssignRole {

	public WebDriver ldriver;

	public AssignRole(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath="//a[normalize-space()='Users']")
	WebElement navigation_users;
	
	@FindBy(xpath="//button[@class='px-2 userMore-step']")
	WebElement kebabicon;
	
	@FindBy(xpath = "//button[normalize-space()='Add Organisation']")
	WebElement addorganisation;
	
	@FindBy(xpath="//input[@placeholder='Select Organisations']")
	
	//body[1]/div[3]/div[14]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]
	//body/div[@id='user-modal-root']/div[6]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]
	//body/div[@id='user-modal-root']/div[14]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]
	WebElement selectorg;
	
	@FindBy(xpath="//button[@title='Create']")
	
	WebElement createbt;
	
	@FindBy(xpath="(//select[@name='role_id'])[2]")
	
	WebElement addrole;
	
	//@FindBy(xpath="//ul[@role='listbox']//li")
	//WebElement orgdropdown;
	
	@FindBy(xpath="//li[contains(text(),'Super Admin')]")
	WebElement defaultsuperadmin;
	
	public void navigationUsers() {
		navigation_users.click();
	}
	
	public void usersList(String username,String org_name_dropdown,String roles_dropdown) throws InterruptedException {
		List<WebElement> userslist = ldriver.findElements(By.xpath("//h5[@class='text-[#028C78] break-words font-interSb text-center text-base']"));//body[1]/div[1]/div[2]/div[1]/div[2]
		int userscount = userslist.size();
		System.out.println("USERSCOUNT :"+" "+userscount);
		for (WebElement userslisting : userslist) {
			String onebyoneuser = userslisting.getText();
			System.out.println("USERS :"+" "+onebyoneuser);
			
			if(userslisting.getText().contains(username)) {
				ldriver.findElement(By.xpath("//input[@name='search']")).sendKeys(username);
				Thread.sleep(3000);
				
				//String TAG_value =userslisting.getTagName();
				//System.out.println("TAG value :"+" "+TAG_value);
				selectOrg( org_name_dropdown, roles_dropdown);
			}
			//else if() {
				
		//	}
			
			else {
				
				ddefault();
			}
		}
	}
	
	public void kebabIcon() {
		kebabicon.click();
		
	}
	
	public void addOrganisation() {
		addorganisation.click();
	}
	

	public void selectOrg(String org_name_dropdown,String roles_dropdown) {
		kebabicon.click();
		addorganisation.click();
		selectorg.click();
		List<WebElement> orgdropdown = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		int totalorg = orgdropdown.size();
		System.out.println("total org in dropdown :" + " " + totalorg);
		for (int i=0;i<=totalorg;i++) {
		String orgnames_onebyone  = orgdropdown.get(i).getText();
			System.out.println(orgnames_onebyone);
			if (orgnames_onebyone.contains(org_name_dropdown)) {
				orgdropdown.get(i).click();
			break;
			}
			else if(orgnames_onebyone.contains(org_name_dropdown)) {
				orgdropdown.get(i).click();
				break;
			}
		}
		createBt();
		addRole(roles_dropdown);
		createBt();
	}
		
	public void ddefault() {
		System.out.println(defaultsuperadmin.getText());
		

	}
	public void createBt() {
		createbt.click();
	}

	public void addRole(String roles_dropdown) {
		addrole.click();
		Select roledropdown = new Select(addrole);
		List<WebElement> allroles = roledropdown.getOptions();
		System.out.println("all roles in dropdown :" +" "+ allroles);
		roledropdown.selectByVisibleText(roles_dropdown);

	}

}
