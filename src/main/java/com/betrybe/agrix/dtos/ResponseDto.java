package com.betrybe.agrix.dtos;

/**
 * Data Transfer Object (DTO) representing a response.
 *
 * @param <T> The type of data included in the response.
 */
public record ResponseDto<T>(String message, T data) {

}
