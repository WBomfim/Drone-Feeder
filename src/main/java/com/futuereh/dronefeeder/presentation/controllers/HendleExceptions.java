package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.presentation.exceptions.DataError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class HendleExceptions.
 * 
 */
/* @ControllerAdvice
public class HendleExceptions {

  @ExceptionHandler()
  public ResponseEntity<DataError> noContent(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.NO_CONTENT)
        .body(new DataError(exception.getMessage()));
  }

  @ExceptionHandler()
  public ResponseEntity<DataError> badRequest(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new DataError(exception.getMessage()));
  }

  @ExceptionHandler()
  public ResponseEntity<DataError> unauthorized(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(new DataError(exception.getMessage()));
  }

  @ExceptionHandler()
  public ResponseEntity<DataError> notFound(RuntimeException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new DataError(exception.getMessage()));
  }

  @ExceptionHandler()
  public ResponseEntity<DataError> internalServerError(Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new DataError(exception.getMessage()));
  }

} */
