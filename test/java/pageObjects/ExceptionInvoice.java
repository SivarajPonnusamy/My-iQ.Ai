package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ExceptionInvoice {
	public WebDriver ldriver;
	public WebDriverWait wait;
	public ExceptionInvoice(WebDriver rdriver) {
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
		WebElement exceptionclick = ldriver.findElement(By.xpath("//a[normalize-space()='Exception']"));
		Actions act = new Actions(ldriver);
		act.moveToElement(navigationhover).moveToElement(exceptionclick).click().perform();
		
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
		
		/*for (int ap = 0; ap < total_pages; ap++) {
			System.out.println(finding_ap.get(ap).getText());
			// total no.of id's -current page
			System.out.println("Total vendor IDs :" + " " + vendor_id.size());
		}*/
			
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
				/*String id = ldriver.findElement(By.xpath("(//a[normalize-space()=" + ids + "])[1]")).getText();
				System.out.println("current id: "+" "+ id);
				if (id.contains("2")) {
					Thread.sleep(4000);
					
					Thread.sleep(4000);
					break;
				}
				else {
					System.out.println("No invoice in exception pages");
				}*/
			
		}
	}
		
	//}

