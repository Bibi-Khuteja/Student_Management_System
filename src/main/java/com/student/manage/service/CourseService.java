package com.student.manage.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.student.manage.model.Course;

@Service
public interface CourseService {
	List<Course> getList();

	Course saveCourse(Course course);

	Course updateCourse(Course Course);

	Course getCourseById(int courseId);

	void deleteCourseById(int courseId);
}
