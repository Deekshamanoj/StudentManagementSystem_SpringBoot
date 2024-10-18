package com.tyss.Student.exception;

public class NoStudentFoundException extends RuntimeException {
	public NoStudentFoundException(String mesage) {
		super(mesage);
	}
}
