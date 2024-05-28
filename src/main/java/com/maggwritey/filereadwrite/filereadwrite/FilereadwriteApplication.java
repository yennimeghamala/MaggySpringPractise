package com.maggwritey.filereadwrite.filereadwrite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.unit.DataSize;

import com.maggwritey.filereadwrite.DAO.StudentDAO;
import com.maggwritey.filereadwrite.entity.Student;

import jakarta.servlet.MultipartConfigElement;

@SpringBootApplication
@ComponentScan(basePackages = "com.maggwritey.filereadwrite")
@EntityScan("com.maggwritey.filereadwrite.entity")
public class FilereadwriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilereadwriteApplication.class, args);
	}
/*
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO ) {

		return runner -> {
		//	readExcel("C:/Users/CHAIT/OneDrive/Desktop/Studetails.xlsx",studentDAO);
			
			

		};
	}
	
	 
		
		public void readExcel(String filePath,StudentDAO studentDAO) throws IOException {
       // List<Student> students = new ArrayList<>();

    
        	FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis);
             

            Sheet sheet = workbook.getSheetAt(0); // Assuming the first sheet
            Iterator<Row> rowIterator = sheet.iterator();

            // Skip header row if necessary
            if (rowIterator.hasNext()) {
                rowIterator.next(); // Skip header row
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Student student = mapRowToStudent(row);
               // students.add(student);
                studentDAO.merge(student);
            }
        
}

    private Student mapRowToStudent(Row row) {
    	Student student = new Student();
    	student.setId((int)row.getCell(0).getNumericCellValue());
    	student.setFirstName(row.getCell(1).getStringCellValue());
    	student.setLastName(row.getCell(1).getStringCellValue());
    	student.setEmail(row.getCell(3).getStringCellValue());
        // Map other fields as needed
        return student;
    }
    
    */

}
