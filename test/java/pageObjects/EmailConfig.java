package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmailConfig {
	WebDriver ldriver;
	
	public  EmailConfig(WebDriver rdriver) {
	ldriver	=rdriver;
	PageFactory.initElements(rdriver, this);
		}
	@FindBy(xpath="//a[normalize-space()='Organisation']")
	WebElement navigation_org;
	
	
	public void sideBarOrg() {
		navigation_org.click();
	}
	
	public void orgList() {
		List<WebElement> orglist = ldriver.findElements(By.xpath("//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div"));
		int orgcount = orglist.size();
		System.out.println(orgcount);
		for(WebElement orglisting:orglist) {
			System.out.println(orglisting.getText());
			if(orglisting.getText().equalsIgnoreCase("ZZDaikin pvt ltd\n"
					+ "www.zzdaikin.com\n"+ "United Kingdom")) {
				orglisting.click();
				break;
			}
			
		}

	}
	
	public void emailConfig() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(ldriver, 40);
		WebElement mousehover = ldriver.findElement(By.xpath("//h4[normalize-space()='Email']"));
		WebElement moushoverclickadd = ldriver
				.findElement(By.xpath("//div[@data-testid='rf__wrapper']//div[5]//div[2]//div[2]//button[1]"));
		Actions act = new Actions(ldriver);
		act.moveToElement(mousehover).moveToElement(moushoverclickadd).click().perform();
		
		ldriver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Set<String> windowhandles =ldriver.getWindowHandles();
		System.out.println(windowhandles);
		Iterator<String> iterator = windowhandles.iterator();
		String parentwindow = iterator.next();
		String childwindow = iterator.next();
		ldriver.switchTo().window(childwindow);
		Thread.sleep(3000);

		By o365username = By.xpath("//input[@name='loginfmt']");
		wait.until(ExpectedConditions.presenceOfElementLocated(o365username));
		ldriver.findElement(o365username).sendKeys("admin@iquantm.online");
		ldriver.findElement(By.xpath("//input[@class='win-button button_primary button ext-button primary ext-primary']")).click();
		Thread.sleep(3000);
		By o365pwd =By.xpath("//input[@name='passwd']");
		wait.until(ExpectedConditions.presenceOfElementLocated(o365pwd));
		ldriver.findElement(o365pwd).sendKeys("iquantm@143");
		ldriver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		ldriver.findElement(By.xpath("//input[@type='button']")).click();
		Thread.sleep(3000);
		ldriver.switchTo().window(parentwindow);
		
		ldriver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		Thread.sleep(3000);
		}
	public void emailConfigList() {
		WebElement mousehover = ldriver.findElement(By.xpath("//h4[normalize-space()='Email']"));
	    WebElement view_email_list=	ldriver.findElement(By.xpath("(//button)[14]"));
	    Actions act = new Actions(ldriver);
	    act.moveToElement(mousehover).moveToElement(view_email_list).build().perform();
	    
		
	}
	
	public void successAlert() {
		String ActualTitle = ldriver.findElement(By.xpath("(//div[contains(text(),'Email configuration')])[1]")).getText();
		String ExpectedTitle="";
	
		
		Assert.assertEquals(ExpectedTitle, ActualTitle);
		
	}
	}
