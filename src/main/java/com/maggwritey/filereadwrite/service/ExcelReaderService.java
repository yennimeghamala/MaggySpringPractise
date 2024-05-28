package com.maggwritey.filereadwrite.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;

@Service
public class ExcelReaderService {

	 public void readExcelFile(String filePath) throws IOException {
	        FileInputStream inputStream = new FileInputStream(new File(filePath));
	        Workbook workbook = WorkbookFactory.create(inputStream);

	        Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet

	        for (Row row : sheet) {
	            for (Cell cell : row) {
	                switch (cell.getCellType()) {
	                    case STRING:
	                        System.out.print(cell.getStringCellValue() + "\t");
	                        break;
	                    case NUMERIC:
	                        System.out.print(cell.getNumericCellValue() + "\t");
	                        break;
	                    case BOOLEAN:
	                        System.out.print(cell.getBooleanCellValue() + "\t");
	                        break;
	                    case BLANK:
	                        System.out.print("[BLANK]\t");
	                        break;
	                    default:
	                        System.out.print("[UNKNOWN]\t");
	                }
	            }
	            System.out.println(); // Move to the next line for the next row
	        }

	        workbook.close();
	        inputStream.close();
	    }
}
