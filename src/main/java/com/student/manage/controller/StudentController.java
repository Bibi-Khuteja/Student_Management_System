package com.student.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.manage.model.Student;
import com.student.manage.service.StudentService;


@Controller
public class StudentController {
@Autowired
StudentService studentService;



	@GetMapping("/students")
	public String studentList(Model model) {
		model.addAttribute("students", studentService.getStudentsList());
		return "students";
	}
		
	@GetMapping("/student/new")
	public String createStudent(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
		
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student model) {
		studentService.saveStudent(model);
		return "redirect:/students";
	}
	
	@GetMapping("/student/edit/{id}")
	public String editStudent(@PathVariable int id,Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student"; 
		
		
	}
	
	@PostMapping("/student/{id}")
	public String updatStudent(@PathVariable int id,@ModelAttribute("student") Student studentModel,Model model2) {
		Student existintStudentModel=studentService.getStudentById(id);
		existintStudentModel.setId(id);
		existintStudentModel.setFirstName(studentModel.getFirstName());
		existintStudentModel.setLastName(studentModel.getLastName());
		existintStudentModel.setEmail(studentModel.getEmail());
		
		studentService.updateStudent(existintStudentModel);
		return "redirect:/students";
	}
	
	//method to delete 
	@GetMapping("/student/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
	
}
	

