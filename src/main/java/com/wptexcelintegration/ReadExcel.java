package com.wptexcelintegration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ReadExcel {

	public List<ResultMetric> readResultMetricExcelFile(String filePath) throws IOException {

		FileInputStream file = new FileInputStream(new File(filePath));
		List<ResultMetric> lstResult = new ArrayList<ResultMetric>();

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("ResultMetric");
		XSSFRow row = sheet.getRow(0);

		Iterator<Cell> cellIterator = row.cellIterator();
		ResultMetric res = new ResultMetric();

		int cellIndex = 0;
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();

			if (cellIndex == 0) {
				res.setRequestData1(cell.getStringCellValue());
			} else if (cellIndex == 1) {
				res.setRequestData2(cell.getStringCellValue());
			} else if (cellIndex == 2) {
				res.setRequestData3(cell.getStringCellValue());
			} else if (cellIndex == 3) {
				res.setRequestData4(cell.getStringCellValue());
			} else if (cellIndex == 4) {
				res.setRequestData5(cell.getStringCellValue());
			} else if (cellIndex == 5) {
				res.setRequestData6(cell.getStringCellValue());
			} else if (cellIndex == 6) {
				res.setRequestData7(cell.getStringCellValue());
			}

			cellIndex++;
		}

		lstResult.add(res);
		workbook.close();

		return lstResult;

	}

}
