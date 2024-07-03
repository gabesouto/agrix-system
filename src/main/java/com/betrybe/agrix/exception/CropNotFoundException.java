package com.betrybe.agrix.exception;


public class CropNotFoundException extends RuntimeException {


  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
