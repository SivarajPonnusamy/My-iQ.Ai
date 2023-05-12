package testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class BearerTokenAuth {
	public WebDriver driver;
	public void authToken() {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver = new ChromeDriver(options);
	driver.get("https://qa.myiq.ai/");
	driver.manage().window().maximize();
	
	given()
	.header()
	.when()
	.get()
	.prettyPrint();
	

}
	private Object given() {
		// TODO Auto-generated method stub
		return null;
	}
}
