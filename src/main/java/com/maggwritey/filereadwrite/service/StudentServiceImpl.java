package com.maggwritey.filereadwrite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggwritey.filereadwrite.DAO.StudentRepository;
import com.maggwritey.filereadwrite.entity.Student;


@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private StudentRepository studentRepository;
public StudentServiceImpl(StudentRepository studentRepository) {
	this.studentRepository=studentRepository;}



@Override
public Student findById(int theId) {
	Optional<Student> result = studentRepository.findById(theId);
	
	Student student = null;
	
	if (result.isPresent()) {
		student = result.get();
	}
	else {
		// we didn't find the employee
		throw new RuntimeException("Did not find employee id - " + theId);
	}
	
	return student;
}
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

}
