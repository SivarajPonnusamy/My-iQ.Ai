package testcase;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Base_test;
import pageObjects.Adduser;
import pageObjects.Loginpage;
import utilities.XLUtils;

// test cases class
public class Add_users extends Base_test {
	
	
	int rownum;

	@Test(dataProvider = "adduserManagement")
	public void addNewUser(String firstname, String lastname, String businessemail) throws InterruptedException

	{
	//Loginpage login = new Loginpage(driver);
	//	login.setBusiness_email(newuserbusinessemail1);
	//	login.setPwd(userPassword1);
	//	login.login_bt();
	//	Thread.sleep(6000);

		Adduser adduser = new Adduser(driver);

		adduser.sidebarUsers();
		
		System.out.println("Add users "+rownum);
		for (int i = 1; i<=rownum;) {
			System.out.println("poda" + " " + i);
			System.out.println(businessemail);

			// Iterator<Object[]> itr = obj.iterator();
			adduser.adduserBt();
			Thread.sleep(3000);
			adduser.firstName(firstname);
			adduser.lastName(lastname);
			adduser.businessEmail(businessemail);
			Thread.sleep(3000);

			adduser.countryRegiondrpdown();
			adduser.createnewUser();
			Thread.sleep(3000);
			//adduser.alertMess();
			//Thread.sleep(6000);
			break;
			
		}
		
	}

//	@DataProvider(name = "adduserManagement")
//	public Object[][] logintest() {
//		return new Object[][]
//
//		{ { "Financial", "Executive", "sivagoogle@iqai.shop" }
//
//		};
//
//	}

	
	@DataProvider(name = "adduserManagement")
	public String[][] getUserData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/adduser_data.xlsx";

		rownum = XLUtils.getRowCount(path, "adduser");
		int cellnum = XLUtils.getCellCount(path, "adduser", 1);
		System.out.println("rownum" + " " + rownum);
		System.out.println("cellnum" + " " + cellnum);
		//DataFormatter format = new DataFormatter();

		String userdata[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {

			for (int j = 0; j < cellnum; j++) {
				System.out.println(i);
				System.out.println(j);

				System.out.println(userdata[i - 1][j] = XLUtils.getCellData(path, "adduser", i, j));// 1,0 // i=1, thus i-1=0 means 0th row 0th cell,
				//next--> 0th row,1stcell
																									
				// System.out.println(userdata);

			}
		}

		return userdata;
	}

}
	 
