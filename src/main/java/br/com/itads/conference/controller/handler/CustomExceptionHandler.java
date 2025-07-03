package br.com.itads.conference.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.itads.conference.controller.dto.ErrorMessageDTO;
import br.com.itads.conference.exception.ObjectNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(exception= ObjectNotFoundException.class)
	public ResponseEntity<ErrorMessageDTO> handleException(ObjectNotFoundException e) {
		ErrorMessageDTO errorMessage = new ErrorMessageDTO(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
	}
	
}
