package com.betrybe.agrix.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Token Service.
 */
@Service
public class TokenService {

  private final Algorithm algorithm;

  /**
   * default constructor for the service.
   */
  public TokenService(@Value("secret") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * Method to generate the token.
   */
  public String generateToken(String username) {
    return JWT.create()
        .withSubject(username)
        .withExpiresAt(generateExpiration())
        .sign(algorithm);
  }

  /**
   * Token validation.
   */
  public String validateToken(String token) {
    return JWT.require(algorithm)
        .build()
        .verify(token)
        .getSubject();
  }

  /**
   * sets the expiration time from now.
   */
  private Instant generateExpiration() {
    return Instant.now()
        .plus(24, ChronoUnit.HOURS);
  }

  
}
