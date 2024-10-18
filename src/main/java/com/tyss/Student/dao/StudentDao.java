package com.tyss.Student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tyss.Student.entity.Student;
import com.tyss.Student.exception.NoStudentFoundException;
import com.tyss.Student.repository.StudentRepository;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository ;

	public Student getStudentByid(int id) {
		//		Optional<Student> optionalStudent = studentRepository.findById(id);
		//		if(optionalStudent.isPresent())
		//			return optionalStudent.get();
		//		throw new NoStudentFoundException("Student with given Id Not found");

		return studentRepository.findById(id).orElseThrow(()->new NoStudentFoundException("No student found"));
	}

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void deleteStudentById(int id) {
		Student student=getStudentByid(id);
		if(student!=null)
			studentRepository.deleteById(id);
		else
			throw new NoStudentFoundException("No student found with given id");
	}

	public Student updatetudent(Student recieved_student) {
		return studentRepository.save(recieved_student);
	}


}
