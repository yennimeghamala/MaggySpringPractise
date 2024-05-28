package com.maggwritey.filereadwrite.DAO;

import com.maggwritey.filereadwrite.entity.Student;

public interface StudentDAO {
	
	void save(Student theStudent);
	  void merge(Student theStudent);

}
