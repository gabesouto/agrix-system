package com.betrybe.agrix.exception;

/**
 * Exception thrown when a crop is not found.
 */
public class CropNotFoundException extends RuntimeException {

  /**
   * Constructs a MuseumNotFoundException with a default error message.
   */
  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
