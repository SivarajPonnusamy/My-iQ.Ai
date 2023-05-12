package testcase;

import org.testng.annotations.Test;

import base.Base_test;
import pageObjects.EmailConfig;

public class Email_config extends Base_test {

	@Test
	public void emailConfig() throws InterruptedException {
		EmailConfig email = new EmailConfig(driver);
		email.sideBarOrg();
		email.orgList();
		email.emailConfig();
		email.emailConfigList();
	}
}
