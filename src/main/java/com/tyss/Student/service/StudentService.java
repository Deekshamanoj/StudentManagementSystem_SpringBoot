package com.tyss.Student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tyss.Student.dao.StudentDao;
import com.tyss.Student.dto.ApiResponse;
import com.tyss.Student.entity.Student;
import com.tyss.Student.utility.ResponseUtil;

@Service
public class StudentService {

	@Autowired 
	StudentDao studentDao ;

	public ResponseEntity<ApiResponse<Student>> getStudentByID(int id) {
		Student student=studentDao.getStudentByid(id);
		ApiResponse<Student> response = ResponseUtil.success(student, HttpStatus.OK.name());
		return new ResponseEntity<ApiResponse<Student>>(response,HttpStatus.OK);
	}

	public ResponseEntity<ApiResponse<Student>> createStudent(Student student) {
		Student savedStudent = studentDao.createStudent(student);
		ApiResponse<Student> response = ResponseUtil.success(savedStudent, HttpStatus.OK.name());
		return new  ResponseEntity<ApiResponse<Student>>(response,HttpStatus.OK);
	}

	public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
		List<Student> listStudents=studentDao.getAllStudents();
		ApiResponse<List<Student>> response = ResponseUtil.success(listStudents, HttpStatus.OK.name());
		return new ResponseEntity<ApiResponse<List<Student>>>(response,HttpStatus.OK);
	}

	public ResponseEntity<ApiResponse<String>> deleteStudentById(int id) {
		studentDao.deleteStudentById(id);
		ApiResponse<String> response = ResponseUtil.success("Deleted", "Student deleted");
		return new ResponseEntity<ApiResponse<String>>(response,HttpStatus.OK);
	}

	public ResponseEntity<ApiResponse<Student>> updateStudentById(int id, Student student) {
		Student recieved_student=studentDao.getStudentByid(id);
		recieved_student.setName(student.getName());
		recieved_student.setEmail(student.getEmail());
		recieved_student.setPhonenumber(student.getPhonenumber());
		recieved_student.setAge(student.getAge());
		studentDao.updatetudent(recieved_student);
		ApiResponse<Student> response = ResponseUtil.success(recieved_student, HttpStatus.OK.name());
		return new ResponseEntity<ApiResponse<Student>>(response,HttpStatus.OK);
	}

}
