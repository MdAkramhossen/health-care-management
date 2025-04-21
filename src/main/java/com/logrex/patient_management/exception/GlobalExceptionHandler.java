package com.logrex.patient_management.exception;

import com.logrex.patient_management.patient_DTO.ErrorDetailsDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    // Handler for ResourceNotFoundException.
    // When a ResourceNotFoundException is thrown, this method creates an ErrorDetailsDTO
    // with the exception message, current date, and request details, then returns a 404 response.

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDTO> handleResourceNotFoundExcetion(ResourceNotFoundException exception,
   WebRequest request) {
        logger.error("Resource not found", exception);
         ErrorDetailsDTO errorDetails= new ErrorDetailsDTO(new Date(),exception.getMessage()
         ,request.getDescription(false));

         return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    // Handler for HealthCareApiException.
    // This method handles HealthCareApiException by returning a 400 Bad Request response
    // with an error details object containing the exception message and request info.
    @ExceptionHandler(HealthCareApiException.class)
    public ResponseEntity<ErrorDetailsDTO>
    handleHealthCareApiException(HealthCareApiException exception,WebRequest webRequest){
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(new Date(), exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // Global exception handler for all other exceptions.
    // This catches any Exception not handled by more specific handlers and returns a 500 response.

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDTO> handleGlobalException(Exception exception,WebRequest webRequest){
        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(new Date(), exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Specific handler for DataIntegrityViolationException (e.g., duplicate entry errors).
    // This method returns a 409 Conflict response with a generic message to avoid exposing SQL details.
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDetailsDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest webRequest) {

        ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(new Date(),"A database error occurred. Possibly a duplicate entry.",
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    // Override for handling validation errors when method arguments are not valid.
    // This method collects all validation errors into a map and returns it with a 400 Bad Request status.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

       Map<String,String> errors = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((error) -> {

           String fieldName=error.getDefaultMessage();
           String message=error.getDefaultMessage();
           errors.put(fieldName,message);

       });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
