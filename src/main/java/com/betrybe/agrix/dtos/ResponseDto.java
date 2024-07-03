package com.betrybe.agrix.dtos;

public record ResponseDto<T>(String message, T data) {

}
