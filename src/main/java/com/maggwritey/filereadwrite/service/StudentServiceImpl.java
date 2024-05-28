package com.maggwritey.filereadwrite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggwritey.filereadwrite.DAO.StudentRepository;
import com.maggwritey.filereadwrite.entity.Student;


@Service
public class StudentServiceImpl implements StudentService {

private StudentRepository studentRepository;
public StudentServiceImpl() {
	
}



	
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

}
