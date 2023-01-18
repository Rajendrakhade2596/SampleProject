package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetUtils {

	static FileInputStream fis;

	static FileOutputStream fos;

	static Workbook wb;

	static Sheet sh;

	static Row row;

	static Cell c;

	public static String[][] ExcelsheetRead(String filepath, String sheetname) throws Exception {
		DataFormatter df = new DataFormatter();

		fis = new FileInputStream(filepath);

		wb = WorkbookFactory.create(fis);

		sh = wb.getSheet(sheetname);

		int rows = sh.getLastRowNum();

		String[][] data = new String[rows + 1][];

		for (int i = 0; i <= rows; i++) {

			int cols = sh.getRow(i).getLastCellNum();

			data[i] = new String[cols];

			for (int j = 0; j < cols; j++) {

				c = sh.getRow(i).getCell(j);

				String value = df.formatCellValue(c);

				data[i][j] = value;
			}
		}

		return data;
	}

	public static void excelSheetWrite(String filepath, String sheetname, int rows, int cols, String value)
			throws Exception {

		fis = new FileInputStream(filepath);

		wb = WorkbookFactory.create(fis);

		/* If Sheet is not Present in Workbook */
		if (wb.getSheet(sheetname) == (null)) {

			sh = wb.createSheet(sheetname);

			row = sh.createRow(rows);

			c = row.createCell(cols);

		} else {
			sh = wb.getSheet(sheetname);

			row = sh.getRow(rows);

			/* If any row is not Present in Workbook */

			if (row == null) {

				row = sh.createRow(rows);

				c = row.createCell(cols);

			} else {

				row = sh.getRow(rows);

				c = row.getCell(cols);

				/* If any cell is not Present in Workbook */

				if (c == null) {

					row.createCell(cols);

				} else {

					c = row.getCell(cols);
				}
			}
		}

		c.setCellValue(value);

		fos = new FileOutputStream(filepath);

		wb.write(fos);

		fis.close();

		fos.close();

		wb.close();
	}
}
