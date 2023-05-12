package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Signup;

public class Sign_up  {
	@Test
	public void signUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://qa.myiq.ai/");
		Signup signup = new Signup(driver);
		signup.signupHyperlink();
		signup.firstName();
		signup.lastName();
		signup.businessEmail();
		signup.termsPrivacy();
		signup.signUpBt();
	    //signup.failMess();
	    signup.alertMess();
		}

}
