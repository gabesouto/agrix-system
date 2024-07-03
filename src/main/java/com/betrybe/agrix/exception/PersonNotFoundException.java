package com.betrybe.agrix.exception;


public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

}
