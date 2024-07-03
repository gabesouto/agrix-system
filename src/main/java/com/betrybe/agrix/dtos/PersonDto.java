package com.betrybe.agrix.dtos;

import com.betrybe.agrix.security.Role;


public record PersonDto(Long id, String username, Role role) {

}
