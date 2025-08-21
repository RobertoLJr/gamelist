package com.robertoljr.gamelist.exception.handler;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.robertoljr.gamelist.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomEntityResponseHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleGlobalExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                Instant.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred. Please try again later.", // Generic message for security
                request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return buildResponseEntity(ex, request, HttpStatus.NOT_FOUND);
    }

    // For JSON parsing errors
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<ExceptionResponse> handleJsonParseError(WebRequest request) {
        return buildResponseEntity(new RuntimeException("Invalid request - Unrecognized field names"), request, HttpStatus.BAD_REQUEST);
    }

    // For @Valid validation failures
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationErrors(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return buildResponseEntity(new RuntimeException(errors.toString()), request, HttpStatus.BAD_REQUEST);
    }

    /**
     * Build ResponseEntity<ExceptionResponse> for Exception handler methods to return.
     * @param ex - Exception
     * @param request - WebRequest
     * @param httpStatus - HttpStatus
     * @return ResponseEntity<ExceptionResponse>
     */
    private ResponseEntity<ExceptionResponse> buildResponseEntity(Exception ex, WebRequest request, HttpStatus httpStatus){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                Instant.now(),
                httpStatus.value(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }
}
