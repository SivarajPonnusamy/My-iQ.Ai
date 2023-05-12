package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProcessedInvoice {
	public WebDriver ldriver;
	public WebDriverWait wait;
	public ProcessedInvoice(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath = "(//a[contains(@href,'/dashboard')])[3]")
	WebElement invoice_navigation;
	
	@FindBy(xpath="//div[@id='mui-component-select-orgName']")
	WebElement orglayout;
	
	@FindBy(xpath = "(//select)[2]")
	WebElement total_pages;
	
	public void invoiceNavigation() {
		wait = new WebDriverWait(ldriver, 30);
		invoice_navigation.click();
		WebElement navigationhover = ldriver.findElement(By.xpath("(//a[contains(@href,'/dashboard')])[3]"));
		WebElement processedclick = ldriver.findElement(By.xpath("(//a[normalize-space()='Processed'])[1]"));
		Actions act = new Actions(ldriver);
		act.moveToElement(navigationhover).moveToElement(processedclick).click().perform();
		
	}
	
	public void layoutSelection() {
		orglayout.click();
		List<WebElement> org_layout = ldriver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for (WebElement organisation : org_layout) {
			if (organisation.getText().equalsIgnoreCase("ZZDaikin pvt ltd"))

			{
				organisation.click();

			}
		}
	}
	public void totalPages() throws InterruptedException {
		List<WebElement> finding_ap = ldriver.findElements(By.xpath("//select[@id]//option"));
		int total_pages = finding_ap.size();
		System.out.println("total_pages:" + " " + total_pages);
		// total no.of pages
		List<WebElement> vendor_id = ldriver.findElements(By.xpath("//tr//td[3]"));
		
		
		for (int ids = 0; ids < vendor_id.size(); ids++) {
			ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement a = vendor_id.get(ids);
	        String id_name	=	a.getText();
			System.out.println("one by one id :" + " " + id_name);
			ldriver.findElement(By.xpath("(//a[normalize-space()=" + id_name + "])[1]")).click();
			Thread.sleep(3000);
			ldriver.findElement(By.xpath("(//img[@alt='tickW'])[1]")).click();
			ldriver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();
			Thread.sleep(4000);
			ldriver.findElement(By.xpath("(//button[normalize-space()='Ok'])[1]")).click();
			ldriver.findElement(By.xpath("//img[@title='Close']")).click();
			Thread.sleep(4000);
			break;
			
			
		}
		
	}
	
	

}
