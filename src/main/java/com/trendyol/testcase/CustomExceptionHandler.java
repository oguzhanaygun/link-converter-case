package com.trendyol.testcase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.trendyol.testcase.exception.TrendyolException;
import com.trendyol.testcase.model.Response;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(TrendyolException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(TrendyolException ex, WebRequest request) {
		Response response = new Response();
		response.getMessages().add(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {
		Response response = new Response();
		response.getMessages().add("Internasl server error.");
		response.getMessages().add(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}