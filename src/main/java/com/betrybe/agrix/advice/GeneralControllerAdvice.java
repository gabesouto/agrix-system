package com.betrybe.agrix.advice;

import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.exception.InvalidCoordinateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the Museum Finder application.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Handles the exception when a farm is not found.
   *
   * @param exception The exception of type MuseumNotFoundException.
   * @return ResponseEntity with a NOT_FOUND status and the exception message.
   */
  @ExceptionHandler(FarmNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFound(
      FarmNotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  /**
   * Handles the exception when a fertilizer is not found.
   *
   * @param exception The exception of type FertilizerNotFoundException.
   * @return ResponseEntity with a NOT_FOUND status and the exception message.
   */
  @ExceptionHandler(FertilizerNotFoundException.class)
  public ResponseEntity<String> handleMuseumNotFound(
      FertilizerNotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  /**
   * Handles the exception when a crop is not found.
   *
   * @param exception The exception of type MuseumNotFoundException.
   * @return ResponseEntity with a NOT_FOUND status and the exception message.
   */
  @ExceptionHandler(CropNotFoundException.class)
  public ResponseEntity<String> cropNotFound(
      CropNotFoundException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }


  /**
   * Handles the exception when an invalid coordinate is encountered.
   *
   * @param exception The exception of type InvalidCoordinateException.
   * @return ResponseEntity with a BAD_REQUEST status and the exception message.
   */
  @ExceptionHandler(InvalidCoordinateException.class)
  public ResponseEntity<String> handleInvalidCoordinate(InvalidCoordinateException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }


}
