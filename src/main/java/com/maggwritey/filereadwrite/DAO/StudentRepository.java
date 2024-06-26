package com.maggwritey.filereadwrite.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.maggwritey.filereadwrite.entity.Student;



public interface StudentRepository extends JpaRepository<Student, Integer> {
	public List<Student> findAllByOrderByLastNameAsc();
}
