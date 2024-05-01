
package com.betrybe.agrix.security;

import com.betrybe.agrix.services.PersonService;
import com.betrybe.agrix.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Filter for JWT authentication.
 *
 * <p>This filter intercepts each request, extracts the JWT from the Authorization header,
 * validates
 * the token, and sets the authentication in the SecurityContext.
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

  private final TokenService tokenService;
  private final PersonService personService;

  /**
   * Constructs a JwtFilter with the given TokenService and PersonService.
   *
   * @param tokenService  the TokenService to use for token operations
   * @param personService the PersonService to use for user operations
   */
  @Autowired
  public JwtFilter(TokenService tokenService, PersonService personService) {
    this.tokenService = tokenService;
    this.personService = personService;
  }

  /**
   * Intercepts each request, validates the JWT, and sets the authentication in the
   * SecurityContext.
   *
   * @param request     the HttpServletRequest
   * @param response    the HttpServletResponse
   * @param filterChain the FilterChain
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException      if an I/O error occurs
   */
  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    Optional<String> token = extractToken(request);

    if (token.isPresent()) {

      String subject = tokenService.validateToken(token.get());

      UserDetails userDetails = personService.loadUserByUsername(subject);

      UsernamePasswordAuthenticationToken authentication =
          new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    filterChain.doFilter(request, response);
  }

  /**
   * Extracts the JWT from the Authorization header of the request.
   *
   * @param request the HttpServletRequest
   * @return an Optional containing the JWT if it exists, or an empty Optional if it does not
   */
  private Optional<String> extractToken(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");

    if (authHeader == null) {
      return Optional.empty();
    }

    return Optional.of(authHeader.replace("Bearer ", ""));
  }
}
