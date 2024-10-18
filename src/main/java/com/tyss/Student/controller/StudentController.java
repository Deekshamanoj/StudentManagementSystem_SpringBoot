package com.tyss.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.Student.dto.ApiResponse;
import com.tyss.Student.entity.Student;
import com.tyss.Student.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Student>> getStudentByID(@PathVariable int id)
	{
		return studentService.getStudentByID(id);
	}
	
	@GetMapping()
	public ResponseEntity<ApiResponse<List<Student>>> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student student)
	{
		return studentService.createStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<String>> deleteStudentById(@PathVariable int id)
	{
		return studentService.deleteStudentById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<Student>> updateStudentById(@PathVariable int id,@RequestBody Student student)
	{
		return studentService.updateStudentById(id,student);
	}
	

}
