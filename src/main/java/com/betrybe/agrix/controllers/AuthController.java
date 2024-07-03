package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.LoginDto;
import com.betrybe.agrix.dtos.TokenDto;
import com.betrybe.agrix.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final AuthenticationManager authManager;
  private final TokenService tokenService;

  @Autowired
  public AuthController(AuthenticationManager authManager, TokenService tokenService) {
    this.authManager = authManager;
    this.tokenService = tokenService;
  }


  @PostMapping("/login")
  public ResponseEntity<TokenDto> login(@RequestBody LoginDto payload) {
    UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
        payload.username(), payload.password());
    Authentication auth = authManager.authenticate(usernamePassword);
    String token = tokenService.generateToken(auth.getName());
    return ResponseEntity.ok(new TokenDto(token));
  }
}
