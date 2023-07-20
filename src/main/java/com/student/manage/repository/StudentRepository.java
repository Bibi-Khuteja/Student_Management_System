package com.student.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.student.manage.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
