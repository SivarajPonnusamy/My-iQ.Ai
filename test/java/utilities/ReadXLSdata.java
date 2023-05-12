package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSdata {

	public static void getData() throws IOException {

		String path = "/Users/sivaraj/Automation/MyiQ.Ai/src/test/resources/testData/login_data.xlsx";
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet = book.getSheet("login");
		int row_num = sheet.getLastRowNum();
		System.out.println(row_num);
		int cell_num = sheet.getRow(1).getLastCellNum();
		System.out.println(cell_num);
		DataFormatter format = new DataFormatter();

		for (int i = 0; i <= row_num; i++) {
			System.out.println(i);
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < cell_num; j++) {

				row.getCell(j);

			}

		}

	}

}
