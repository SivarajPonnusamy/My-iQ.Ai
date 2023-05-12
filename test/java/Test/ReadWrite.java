package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadWrite {
	public static void main(String args[]) throws IOException {

		Properties prop = new Properties();
		String file = "/Users/sivaraj/Automation/MyiQ.Ai/src/test/resources/configfiles/configFile-read";
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		String configfile = prop.getProperty("browser");
		System.out.println(configfile);

// write data in config file
		prop.setProperty("clientdata", "1234567");
		String filewrite = "/Users/sivaraj/Automation/MyiQ.Ai/src/test/resources/configfiles/configfile-write";
		FileOutputStream output = new FileOutputStream(filewrite);
		prop.store(output, "customer data");

//read file using reader class beides input stream

		FileReader read = new FileReader(file);
		prop.load(read);
		String url_read = prop.getProperty("url");
		System.out.println(url_read);
	}
}
