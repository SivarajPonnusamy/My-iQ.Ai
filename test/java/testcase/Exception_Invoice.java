package testcase;

import org.testng.annotations.Test;

import base.Base_test;
import pageObjects.ExceptionInvoice;

public class Exception_Invoice extends Base_test{
	@Test
	public static void exceptionInvoice() throws InterruptedException {
		ExceptionInvoice exp = new ExceptionInvoice(driver);
		exp.invoiceNavigation();
		Thread.sleep(3000);
		exp.layoutSelection();
		Thread.sleep(3000);
		exp.totalPages();
	}

}
