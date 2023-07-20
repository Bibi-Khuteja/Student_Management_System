package com.student.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.manage.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
