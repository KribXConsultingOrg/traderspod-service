package com.traderspod.listing.exception;

import org.joda.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.traderspod.listing.dto.output.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest req) {
		String message = ex.getLocalizedMessage();
		
		if (message == null) {
			message = ex.toString();
		}
		ErrorMessage errorMessage = new ErrorMessage(message, LocalDateTime.now());
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
