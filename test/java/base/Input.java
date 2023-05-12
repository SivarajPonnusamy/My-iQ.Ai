package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Adduser;
import pageObjects.Loginpage;
import utilities.XLUtils;

public class Input {

	@Test
	public void login() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		Loginpage login = new Loginpage(driver);

		String newuserbusinessemail1 = "admin@iquantm.online";
		login.setBusiness_email(newuserbusinessemail1);
		String userPassword1 = "Rajsiva@123";
		login.setPwd(userPassword1);

		login.login_bt();
		Thread.sleep(3000);

	}
}

/*
 * @Test(dataProvider = "adduserManagement") public void addNewUser(String
 * firstname, String lastname, String businessemail) throws InterruptedException
 * 
 * { WebDriverManager.chromedriver().setup(); WebDriver driver = new
 * ChromeDriver();
 * 
 * Adduser adduser = new Adduser(driver);
 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 * 
 * adduser.sidebarUsers();
 * 
 * adduser.adduserBt(); adduser.firstName(firstname);
 * adduser.lastName(lastname); adduser.businessEmail(businessemail);
 * adduser.countryRegiondrpdown(); adduser.createnewUser();
 * 
 * 
 * }
 * 
 * 
 * 
 * @DataProvider(name = "adduserManagement") public String[][] getUserData()
 * throws IOException { String path = System.getProperty("user.dir") +
 * "/src/test/resources/testData/adduser_data.xlsx"; int rownum =
 * XLUtils.getRowCount(path, "adduser"); int cellnum =
 * XLUtils.getCellCount(path, "adduser", 1); System.out.println("rownum" + " " +
 * rownum); System.out.println("cellnum" + " " + cellnum); //DataFormatter
 * format = new DataFormatter();
 * 
 * String userdata[][] = new String[rownum][cellnum]; for (int i = 1; i <=
 * rownum; i++) { System.out.println(i); for (int j = 0; j < cellnum; j++) {
 * System.out.println(j);
 * 
 * userdata[i - 1][j] = XLUtils.getCellData(path, "adduser", i, j);// 1,0 //
 * i=1, thus i-1=0 means 0th row 0th cell, next--> 0th row, 1stcell
 * 
 * System.out.println(userdata); } }
 * 
 * return userdata;
 * 
 * } }
 */