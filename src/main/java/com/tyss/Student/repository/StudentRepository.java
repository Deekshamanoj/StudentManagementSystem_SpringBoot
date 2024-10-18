package com.tyss.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.Student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
