package com.betrybe.agrix.exception;

/**
 * Exception thrown when an invalid coordinate is encountered.
 */
public class InvalidCoordinateException extends RuntimeException {

  /**
   * Constructs an InvalidCoordinateException with a default error message.
   */
  public InvalidCoordinateException() {
    super("Coordenada inválida!");
  }
}
