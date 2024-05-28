package com.maggwritey.filereadwrite.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.maggwritey.filereadwrite.DAO.StudentDAO;
import com.maggwritey.filereadwrite.utilities.ExcelUtilis;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.MultipartConfigElement;
@Controller 
public class FileUploadController {

    @Value("${file.upload-dir}")
    private  String uploadDir;
    private ExcelUtilis excelUtils;
    private StudentDAO studentDAO;
    
    public FileUploadController(ExcelUtilis excelUtils,StudentDAO studentDAO) {
		super();
		
		this.excelUtils = excelUtils;
		this.studentDAO = studentDAO;
	}

	@PostConstruct
    public void init() {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) throws Exception {
        if (file.isEmpty()) {
        	return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
        }

        try {
            // Save the file
        	file=null;
            byte[] bytes = file.getBytes();
            
           String filePath=getUploadDir() + "/" + file.getOriginalFilename();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
            model.addAttribute("message", "File uploaded successfully!");
            //save file to DB
            excelUtils.saveExceltoDB(filePath,studentDAO);
            System.out.println(8);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Internal server error"+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //get student list from DB
       // excelUtils.listStudents(model);
        
        //return "File uploaded successfully";
         return new ResponseEntity<>("Resource created", HttpStatus.CREATED);
    }
   
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofGigabytes(10)); // Use DataSize for setting max file size
        factory.setMaxRequestSize(DataSize.ofGigabytes(10)); // Use DataSize for setting max request size
        return factory.createMultipartConfig();
    }

    
        
    
    
    
    
	public  String getUploadDir() {
		return uploadDir;
	}

	

	

	
	
}
