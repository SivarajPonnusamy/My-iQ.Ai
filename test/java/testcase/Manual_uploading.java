package testcase;

import org.testng.annotations.Test;

import base.Base_test;
import pageObjects.Loginpage;
import pageObjects.Manualuploading;

public class Manual_uploading extends Base_test {
	@Test
	public static void manual_Uploading() throws InterruptedException {
	/*	Loginpage login = new Loginpage(driver);
		login.setBusiness_email(newuserbusinessemail1);
		login.setPwd(userPassword1);
		login.login_bt();
		Thread.sleep(3000);*/
		
		
		Manualuploading upload = new Manualuploading(driver);
		upload.sidebarManual();
		
		upload.orgLayout();
		Thread.sleep(3000);
		upload.uploadFiles();
		Thread.sleep(3000);
		upload.uploadBt();
	    Thread.sleep(3000);
		upload.confirmationMess();
		Thread.sleep(3000);
	
		
		
		
		}

}
