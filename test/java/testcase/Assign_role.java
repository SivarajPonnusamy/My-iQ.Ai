package testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base_test;
import pageObjects.AssignRole;
import utilities.XLUtils;

public class Assign_role extends Base_test{
	int rownum;
	@Test(dataProvider="assignrole")
	public static void assignRolea(String username,String org_name_dropdown, String roles_dropdown ) throws InterruptedException {
		AssignRole role = new AssignRole(driver);
		role.navigationUsers();
		role.usersList(username,org_name_dropdown,roles_dropdown);
		//role.kebabIcon();
		//role.addOrganisation();
		
		//role.selectOrg();
		Thread.sleep(3000);
		//role.createBt();
		
		//role.addRole();
		Thread.sleep(3000);
		//role.createBt();
		//Thread.sleep(3000);
		
		
	}
	@DataProvider(name = "assignrole")
	public String[][] getOrgData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/resources/testData/assignrole.xlsx";
		rownum = XLUtils.getRowCount(path, "assign_role");
		int cellnum = XLUtils.getCellCount(path, "assign_role", 1);
		String assignrole[][] = new String[rownum][cellnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < cellnum; j++) {
				assignrole[i - 1][j] = XLUtils.getCellData(path, "assign_role", i, j);
				System.out.println(assignrole[i - 1][j] = XLUtils.getCellData(path, "assign_role", i, j));
			}
		}
		return assignrole;
	}

}
