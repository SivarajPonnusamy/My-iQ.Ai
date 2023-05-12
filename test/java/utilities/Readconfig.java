package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {

	Properties pro;

	public Readconfig() {
		String file1 = (System.getProperty("user.dir") + "/src/test/resources/configfiles/newlogincreation.properties");
		try {
			FileInputStream signin = new FileInputStream(file1);
			pro = new Properties();
			pro.load(signin);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());

		}
	}

	public String getnewUseremail() {
		String newuserbusinessemail = pro.getProperty("newuserbusinessemail");
		return newuserbusinessemail;
	}

	public String getuserPassword() {
		String userPassword = pro.getProperty("userPassword");
		return userPassword;
	}

}
