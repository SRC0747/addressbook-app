package com.bridgelabz.addressbookapp.exception;

import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.bind.ValidationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomException.class)
    public ResponseEntity<ResponseDTO> handleCustomException(CustomException customException){
        return new ResponseEntity<>(new ResponseDTO(customException.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ResponseDTO> handleValidationException(ValidationException validationException){
        return new ResponseEntity<>(new ResponseDTO(validationException.getMessage(), null), HttpStatus.NOT_FOUND);
    }
}
