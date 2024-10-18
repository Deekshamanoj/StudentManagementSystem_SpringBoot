package com.tyss.Student.utility;

import java.util.Arrays;
import java.util.List;

import com.tyss.Student.dto.ApiResponse;

public class ResponseUtil {
	

    public static <T> ApiResponse<T> success(T data, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setData(data);
        response.setErrors(null);
        response.setErrorCode(0); // No application-level error, success scenario
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }

    public static <T> ApiResponse<T> error(List<String> errors, String message, int errorCode) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setData(null);
        response.setErrors(errors);
        response.setErrorCode(errorCode);  // Application-specific error code
        response.setTimestamp(System.currentTimeMillis());
        return response;
    }

    public static <T> ApiResponse<T> error(String error, String message, int errorCode) {
        return error(Arrays.asList(error), message, errorCode);
    }

}
