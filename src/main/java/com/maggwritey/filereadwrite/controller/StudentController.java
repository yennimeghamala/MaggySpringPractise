package com.maggwritey.filereadwrite.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maggwritey.filereadwrite.DAO.StudentDAO;
import com.maggwritey.filereadwrite.entity.Student;
import com.maggwritey.filereadwrite.service.StudentService;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.MultipartConfigElement;



@RestController
@RequestMapping("/students")
public class StudentController {
	/*
	@Value("${file.upload-dir}")
    private  String uploadDir;
	private StudentDAO studentDAO;
	private StudentService studentService;
	@Autowired
	public StudentController(StudentService theStudentService, StudentDAO theStudentDAO) {
		 System.out.println(7);
		studentService = theStudentService;
		studentDAO =theStudentDAO;
	}
	
	
	
    
    @PostConstruct
    public void init() {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
/*
    @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, StudentDAO studentDAO) {
        System.out.println(1);
    	if (file.isEmpty()) {
            return "Please select a file to upload.";
        }

        try {
            // Save the file
            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadDir + "/" + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            
            FileInputStream fis = new FileInputStream(uploadDir + "/" + file.getOriginalFilename());
            Workbook workbook = WorkbookFactory.create(fis);
            System.out.println(2);

           Sheet sheet = workbook.getSheetAt(0); 
           System.out.println(3);// Assuming the first sheet
           Iterator<Row> rowIterator = sheet.iterator();

           // Skip header row if necessary
           if (rowIterator.hasNext()) {
               rowIterator.next(); // Skip header row
           }

           while (rowIterator.hasNext()) {
               Row row = rowIterator.next();
               Student student = mapRowToStudent(row);
              // students.add(student);
               
               System.out.println(4);
               studentDAO.merge(student);
               System.out.println(5);
           }
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the file.";
        }
        System.out.println(6);
        return "students/student-upload-form";
        
    }
    
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofGigabytes(10)); // Use DataSize for setting max file size
        factory.setMaxRequestSize(DataSize.ofGigabytes(10)); // Use DataSize for setting max request size
        return factory.createMultipartConfig();
    }

	
	
	
	
	
	@PostMapping("/save")
	public void saveExceltoDB(StudentDAO studentDAO) throws IOException{
		
	}
	 
	 @GetMapping("/list")
	 public String listStudents(Model theModel) {

			// get the employees from db
			List<Student> theStudents = studentService.findAll();
			

			// add to the spring model
			theModel.addAttribute("students", theStudents);

			return "students/list-students";
		}
*/
}
