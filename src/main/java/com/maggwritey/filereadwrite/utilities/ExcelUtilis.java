package com.maggwritey.filereadwrite.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.maggwritey.filereadwrite.DAO.StudentDAO;
import com.maggwritey.filereadwrite.entity.Student;
import com.maggwritey.filereadwrite.service.*;

@Component
public class ExcelUtilis {
	
	private StudentDAO studentDAO;
	private StudentService studentService;
@Autowired
	public ExcelUtilis(StudentDAO studentDAO, StudentService studentService) {
		super();
		this.studentService = studentService;
		this.studentDAO = studentDAO;
	}
	public void saveExceltoDB(String filePath,StudentDAO studentDAO) throws IOException {
	       // List<Student> students = new ArrayList<>();
		
		//String filePath="FileUploadController.getUploadDir()/Studetails.xlsx";
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
	 
	 
	 public String listStudents(Model theModel) {

			// get the employees from db
			List<Student> theStudents = studentService.findAll();
			

			// add to the spring model
			theModel.addAttribute("students", theStudents);

			return "students/list-students";
			}

	
		 
	 }

