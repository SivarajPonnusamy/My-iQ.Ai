package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DesiredCapabilites {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		DesiredCapabilites caps = new DesiredCapabilites();

		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("caps");
		// options.setExperimentalOption("excludeSwitches",
		// Collections.singletonList("enable-automation"));

		// options.merge((Capabilities) caps);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://qa.myiq.ai/");
		// driver.manage().window().maximize();

		try {

			driver.findElement(By.name("login_email")).sendKeys("admin@iquantm.online");
			driver.findElement(By.name("login_password")).sendKeys("Rajsiva@123");
			driver.findElement(By.xpath("//button[@title='login']")).click();
			WebDriverWait wait2 = new WebDriverWait(driver, 40);

			By organization = By.xpath("//a[@href='/organisations']");
			wait2.until(ExpectedConditions.presenceOfElementLocated(organization));
			driver.findElement(organization).click();

			Thread.sleep(2000);

			// driver.findElement(By.xpath("//h4[normalize-space()='Email']"));

			// driver.findElement
			// (By.xpath("//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[2]/button[1]"));

			WebElement mousehover = wait2
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h4[normalize-space()='Email']")));
			WebElement moushoverClick = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"//body[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/div[2]/div[2]/button[1]")));

			Actions act = new Actions(driver);
			act.moveToElement(mousehover).moveToElement(moushoverClick).click().perform();
			Thread.sleep(3000);

			By google = By.xpath("//button[normalize-space()='Google']");
			wait2.until(ExpectedConditions.presenceOfElementLocated(google));

			driver.findElement(google).click();

			Thread.sleep(3000);
			// options.addArguments("--start-maximized");

			/*
			 * String id= driver.getWindowHandle(); System.out.println(id);
			 */

			Set<String> ids = driver.getWindowHandles(); // in set collection duplicate are not allowed, however in list
															// collection duplicates are allowed

			java.util.Iterator<String> it = ids.iterator();
			String parentid = it.next();
			String childid = it.next();
			System.out.println(parentid);
			System.out.println(childid);

//List <String> windowsids = new ArrayList(ids);// converting set into list

			/*
			 * driver.switchTo().window(parentid); System.out.println(driver.getTitle());
			 */

			driver.switchTo().window(childid);
			Thread.sleep(4000);

			System.out.println(driver.getTitle());

			By gmail = By.xpath("//input[@type='email']");
			wait2.until(ExpectedConditions.presenceOfElementLocated(gmail));

			driver.findElement(gmail).sendKeys("sivagoogle23@iqai.shop");

			// By pwd = By.xpath("//");

		} catch (Exception e) {
			System.out.println(e);

		}

		driver.quit();

	}

}
