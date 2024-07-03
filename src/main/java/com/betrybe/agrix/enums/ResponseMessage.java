package com.betrybe.agrix.enums;


public enum ResponseMessage {
  SUCCESS("Operação realizada com sucesso."),
  NOT_FOUND("Não foi encontrado o recurso."),
  UPDATED("Recurso atualizado com sucesso."),
  REMOVED("Recurso removido com sucesso."),
  CREATED("Recurso criado com sucesso."),
  ERROR("Ocorreu um erro durante a operação.");

  private final String message;

  /**
   * Constructor for ResponseMessage enum.
   *
   * @param message The message associated with the enum value.
   */
  ResponseMessage(String message) {
    this.message = message;
  }

  /**
   * Retrieves the message associated with the enum value.
   *
   * @return The message.
   */
  public String getMessage() {
    return message;
  }
}
