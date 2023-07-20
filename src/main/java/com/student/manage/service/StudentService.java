package com.student.manage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.manage.model.Student;
@Service
public interface StudentService {
	
	List<Student> getStudentsList();
	
	
	
	Student saveStudent(Student studentModel);
	
	Student updateStudent(Student studentModel);
	Student getStudentById(int id);
	
	void deleteStudentById(int id);
	
}
