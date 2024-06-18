package com.maggwritey.filereadwrite.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.maggwritey.filereadwrite.entity.Student;


@Service
public interface StudentService {

	List<Student> findAll();
	Student findById(int theId);

}
