package com.student.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.manage.model.Course;
import com.student.manage.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public List<Course> getList() {

		return courseRepository.findAll();
	}

	@Override
	public Course saveCourse(Course course) {

		return courseRepository.save(course);
	}

	@Override
	public Course updateCourse(Course Course) {

		return courseRepository.save(Course);
	}

	@Override
	public Course getCourseById(int courseId) {

		return courseRepository.findById(courseId).get();
	}

	@Override
	public void deleteCourseById(int courseId) {
		courseRepository.deleteById(courseId);

	}

}
