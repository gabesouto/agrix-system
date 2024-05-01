package com.betrybe.agrix.exception;

/**
 * Exception thrown when a museum is not found.
 */
public class FarmNotFoundException extends RuntimeException {

  /**
   * Constructs a MuseumNotFoundException with a default error message.
   */
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
