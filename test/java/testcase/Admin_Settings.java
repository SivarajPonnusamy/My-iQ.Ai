package testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base_test;
import pageObjects.AdminSettings;
import pageObjects.Loginpage;
import utilities.XLUtils;

public class Admin_Settings extends Base_test{
   int rownum;
   @Test(dataProvider="rolename")
   public  void adminSettings(String rolename, String role_description) throws InterruptedException {
		
		/*Loginpage login = new Loginpage(driver);
		login.setBusiness_email(newuserbusinessemail1);
		login.setPwd(userPassword1);
		login.login_bt();*/
		
		AdminSettings adminsettings = new AdminSettings(driver);
		Thread.sleep(3000);
		adminsettings.adminSettings();
		adminsettings.settingS();
		adminsettings.roleMaster();
		
		System.out.println("Total no of roles"+" "+rownum);
		for(int i=1;i<=rownum;) {
			
		adminsettings.addRole();
		adminsettings.roleName(rolename);
		adminsettings.roleDescription(role_description);
		//adminsettings.roleInvoice();
		adminsettings.roleCreation();
		Thread.sleep(3000);
		break;
		}
		
	}
   @DataProvider(name = "rolename")
	public String[][] getOrgData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/rolecreation.xlsx";
		rownum = XLUtils.getRowCount(path, "roles");
		int cellnum = XLUtils.getCellCount(path, "roles", 1);
		String orgdata[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				orgdata[i - 1][j] = XLUtils.getCellData(path, "roles", i, j);
				System.out.println(orgdata[i - 1][j] = XLUtils.getCellData(path, "roles", i, j));
			}
		}
		return orgdata;
	}
	
	
}
