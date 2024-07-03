package com.maggwritey.filereadwrite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maggwritey.filereadwrite.DAO.StudentRepository;
import com.maggwritey.filereadwrite.entity.Student;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public Student findById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
}
