package testcase;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base_test;
import pageObjects.Addorganisation;
import pageObjects.Loginpage;
import utilities.XLUtils;

public class Add_organisation extends Base_test {

	 int rownum;
	
	@Test(dataProvider = "addorganisation")
	public  void add_organisation(String orgdomainname,String orgname, String regno, String address1) throws InterruptedException {
		Addorganisation addorg = new Addorganisation(driver);
		addorg.sidebarOrg();
		
		
		System.out.println("Add org "+rownum);
		for(int i = 1; i<=rownum;) {
		addorg.addorgBt();
		addorg.orgDomainName(orgdomainname);
		Thread.sleep(3000);
		addorg.orgName(orgname);
		addorg.regNo(regno);
		addorg.Address(address1);
		addorg.orgCountry();

		addorg.btncreatenewOrg();
		Thread.sleep(5000);
		break;
		
		}
}
	/*@DataProvider(name="addorganisation")
	public Object[][] logintest() {
	return new Object[][]
	{ { "www.zzdaikin.com", "ZZDaikin pvt ltd", "Dk-12345","LEEDS,Prince Sqaure,UK" }

		};
	}*/

	@DataProvider(name = "addorganisation")
	public String[][] getOrgData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/addorg_data1.xlsx";
		rownum = XLUtils.getRowCount(path, "addorg");
		int cellnum = XLUtils.getCellCount(path, "addorg", 1);
		String orgdata[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				orgdata[i - 1][j] = XLUtils.getCellData(path, "addorg", i, j);
				System.out.println(orgdata[i - 1][j] = XLUtils.getCellData(path, "addorg", i, j));
			}
		}
		return orgdata;
	}
	
		
		
	

}
