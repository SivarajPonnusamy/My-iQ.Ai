package testcase;

import org.testng.annotations.Test;

import base.Base_test;
import pageObjects.ProcessedInvoice;

public class Processed_Invoice extends Base_test{
	@Test
	public static void processedInvoice() throws InterruptedException {
		ProcessedInvoice process = new ProcessedInvoice(driver);
		process.invoiceNavigation();
		Thread.sleep(3000);
		process.layoutSelection();
		Thread.sleep(3000);
		process.totalPages();
	}

}



