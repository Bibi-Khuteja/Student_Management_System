package com.student.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.manage.model.Student;
import com.student.manage.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@Override
	public List<Student> getStudentsList() {
		
		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student studentModel) {
		
		return studentRepository.save(studentModel);
	}


	@Override
	public Student updateStudent(Student studentModel) {

		return studentRepository.save(studentModel);
	}


	@Override
	public Student getStudentById(int id) {
		
		return studentRepository.findById(id).get();
	}


	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
		
	}


	

	}
