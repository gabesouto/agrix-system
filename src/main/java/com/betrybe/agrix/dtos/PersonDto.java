package com.betrybe.agrix.dtos;

import com.betrybe.agrix.security.Role;


/**
 * Data Transfer Object (DTO) representing a person.
 */
public record PersonDto(Long id, String username, Role role) {

}
