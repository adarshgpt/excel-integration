package com.wptexcelintegration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ExportExcel {

	@Autowired
	private ReadExcel readResultExcel;

	int rowCount = 0;

	public void writeObjectsToExcelFile(JsonNode fetchedData) throws IOException {

		String filePath = "D:\\BulkTest.xlsx";

		FileInputStream inputStream = null;

		File file = new File(filePath);

		try {
			XSSFWorkbook workbook = null;

			if (!file.exists()) {
				workbook = new XSSFWorkbook();
			}

			else {
				inputStream = new FileInputStream(file);
				workbook = new XSSFWorkbook(inputStream);
			}

			XSSFSheet spreadsheet = workbook.getSheet("RequestSheet");
			if (workbook.getNumberOfSheets() != 0) {
				for (int i = 1; i < workbook.getNumberOfSheets(); i++) {
					if (workbook.getSheetName(i).equals("ResultMetric")) {
						spreadsheet = workbook.getSheet("ResultMetric");
					}
				}
			} else {
				spreadsheet = workbook.createSheet("ResultMetric");
			}

			List<ResultMetric> data = readResultExcel.readResultMetricExcelFile(filePath);

			String jsonString = convertObjects2JsonString(data);

			JSONArray jsonArray = new JSONArray(jsonString);

			for (int k = 0; k < jsonArray.length(); k++) {

				JSONObject obj = jsonArray.getJSONObject(k);

				XSSFRow row = (XSSFRow) spreadsheet.createRow(++rowCount);

				XSSFCell cell1 = row.createCell(0);

				cell1.setCellValue(fetchedData.get(obj.get("requestData1").toString()).toString());

				XSSFCell cell2 = row.createCell(1);
				cell2.setCellValue(fetchedData.get(obj.get("requestData2").toString()).toString());

				XSSFCell cell3 = row.createCell(2);
				cell3.setCellValue(fetchedData.get(obj.get("requestData3").toString()).toString());

				XSSFCell cell4 = row.createCell(3);
				cell4.setCellValue(fetchedData.get(obj.get("requestData4").toString()).toString());

				XSSFCell cell5 = row.createCell(4);
				cell5.setCellValue(fetchedData.get(obj.get("requestData5").toString()).toString());

				XSSFCell cell6 = row.createCell(5);
				cell6.setCellValue(fetchedData.get(obj.get("requestData6").toString()).toString());

				XSSFCell cell7 = row.createCell(6);
				cell7.setCellValue(fetchedData.get(obj.get("requestData7").toString()).toString());

			}

			if (inputStream != null)
				inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
			outputStream.close();
			workbook.close();

			System.out.println("Exported excel successfully");

		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}

	}

	private static String convertObjects2JsonString(List<ResultMetric> lstRes) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "";

		try {
			jsonString = mapper.writeValueAsString(lstRes);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}
