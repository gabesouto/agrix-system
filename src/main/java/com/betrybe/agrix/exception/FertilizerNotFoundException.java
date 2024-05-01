package com.betrybe.agrix.exception;


/**
 * Exception thrown when a museum is not found.
 */
public class FertilizerNotFoundException extends RuntimeException {

  /**
   * Constructs a MuseumNotFoundException with a default error message.
   */
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
