package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM 
public class Signup {
	public WebDriver ldriver;
	public WebDriverWait wait;
	public Signup(WebDriver driver) {
		ldriver=driver;
		wait = new WebDriverWait(ldriver,30);
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//a[normalize-space()='Sign up']")
	WebElement signuphyperlink;
	
	@FindBy(xpath="//input[@placeholder='First name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@placeholder='email@address.com']")
	WebElement businessemail;
	
	@FindBy(xpath="//input[@name='signup_acceptTerms']")
	WebElement termsprivacy;
	
	@FindBy(xpath="//button[normalize-space()='Sign up']")
	WebElement signupbt;
	
	@FindBy(xpath="(//div[@role='alert'])[1]")
	WebElement failurealert;
	
	@FindBy(xpath="(//h3[normalize-space()='Thanks for signing up!'])[1]")
	WebElement successmess;
	
	public void signupHyperlink() {
		signuphyperlink.click();
		}
	public void firstName() {
		firstname.sendKeys("CFO");
	}
	
	public void lastName() {
		lastname.sendKeys("admin");
	}
	
	public void businessEmail() {
		businessemail.sendKeys("admin@iquantm.online");
		}	
	
	public void termsPrivacy(){
		termsprivacy.click();
	}
	
	public void signUpBt() throws InterruptedException {
		signupbt.click();
		Thread.sleep(4000);
		}
	public void failMess() {
		
		System.out.println(failurealert.getText());
	}
		public void alertMess() throws InterruptedException {
			String successalert = successmess.getText();
			System.out.println(successalert);
			

			if (successalert.equalsIgnoreCase("Thanks for signing up!")) {
				System.out.println("success mess : " + " " + successalert);
				ldriver.close();
				
			} 
			else {
				WebElement failuremess = ldriver.findElement(By.xpath("(//div[@role='alert'])[1]"));
				Thread.sleep(3000);
				System.out.println("failure mess : " + " " + failuremess.getText());
				businessemail.clear();
				businessemail.sendKeys("admin@iquantm.com");
				signupbt.click();
				ldriver.close();

			}

		}
		
	

}