package testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Base_test;
import pageObjects.Loginpage;
import utilities.XLUtils;

public class Login_page extends Base_test {

	@Test(dataProvider = "logintest") // test case class
	public static void loginPage(String business_email, String password) throws InterruptedException {

		Loginpage login = new Loginpage(driver);
		login.setBusiness_email(business_email);
		login.setPwd(password);
		login.login_bt();
		
		Thread.sleep(3000);

		/*
		 * driver.findElement(By.name(loc.getProperty("business_email"))).sendKeys(
		 * business_email);
		 * driver.findElement(By.name(loc.getProperty("password"))).sendKeys(password);
		 * driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
		 * Thread.sleep(3000);
		 */

	}

	/*@DataProvider(name = "logintest")
	public Object[][] logintest() {
		return new Object[][]

		{ // {"admin@iquantm123.com","Rajsiva@12314"},
			// {"admin@iq.ai","Sivaraj123@"}, //{"admin@iquantm.com","Raj@123"},
				{ "psivaraj@iquantm.com", "Happy@1234" }

		};

	}*/

	
	 @DataProvider(name = "logintest") 
	 public String[][] getData() throws IOException { 
		 String path = System.getProperty("user.dir") + "/src/test/resources/testData/login_data.xlsx"; 
		 int rownum = XLUtils.getRowCount(path, "login"); 
		 int cellnum = XLUtils.getCellCount(path,"login", 1); 
		 System.out.println("rownum" + " " + rownum);
	     System.out.println("cellnum" + " " + cellnum); 
	     DataFormatter format = new DataFormatter();
	  
	  String logindata[][] = new String[rownum][cellnum]; 
	  for (int i = 1; i <=rownum; i++) { 
		  System.out.println(i); 
	  for (int j = 0; j < cellnum; j++) {
	  System.out.println(j);
	  
	  logindata[i - 1][j] = XLUtils.getCellData(path, "login", i, j);// 1,0 // i=1,thus i-1=0 means 0th row 0th cell, next--> 0th row, 1stcell
	  //System.out.println(logindata); 
	  } 
	  }
	  
	  return logindata;
	  
	  }
	 

}
