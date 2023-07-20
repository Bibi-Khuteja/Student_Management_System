package com.student.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.student.manage.model.Course;
import com.student.manage.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/course")
	public String courseList(Model model) {
		model.addAttribute("course", courseService.getList());
		return "course";
	}

	@GetMapping("/course/new")
	public String addCourse(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "addcourse";

	}

	@PostMapping("/addcourse")
	public String saveCourse(@ModelAttribute Course course) {
		courseService.saveCourse(course);
		return "redirect:/course";
	}

	@GetMapping("/course/edit/{courseId}")
	public String editCourse(@PathVariable int courseId, Model model) {
		
		model.addAttribute("course", courseService.getCourseById(courseId));
		
		return "edit_course.html";
	}

	@PostMapping("/course/{courseId}")
	public String updateCourse(@PathVariable int courseId, @ModelAttribute("course") Course course, Model model) {
		Course existimgCourse = courseService.getCourseById(2);
		existimgCourse.setCourseId(courseId);
		existimgCourse.setCourseName(course.getCourseName());
		existimgCourse.setDuration(course.getDuration());
		courseService.updateCourse(existimgCourse);
		return "redirect:/course";

	}

	@GetMapping("/delete-course/{courseId}")
	public String deleteStudent(@PathVariable int courseId) {
		courseService.deleteCourseById(courseId);
		return "redirect:/course";
	}
}
