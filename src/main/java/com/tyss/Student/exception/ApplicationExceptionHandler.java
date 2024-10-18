package com.tyss.Student.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tyss.Student.dto.ApiResponse;
import com.tyss.Student.utility.ResponseUtil;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(NoStudentFoundException.class)
	public ResponseEntity<ApiResponse<String>> handleException(NoStudentFoundException ex) {
		List<String> errors = Arrays.asList(ex.getMessage());
		ApiResponse<String> response = ResponseUtil.error(errors, "No Student Found with given id", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
		List<String> errors = Arrays.asList(ex.getMessage());
		ApiResponse<String> response = ResponseUtil.error(errors, "An error occurred", 1000);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}





}
