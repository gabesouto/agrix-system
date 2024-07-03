package com.betrybe.agrix.exception;


public class InvalidCoordinateException extends RuntimeException {


  public InvalidCoordinateException() {
    super("Coordenada inválida!");
  }
}
