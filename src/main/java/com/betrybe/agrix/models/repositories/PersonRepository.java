package com.betrybe.agrix.models.repositories;

import com.betrybe.agrix.models.entities.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface PersonRepository extends JpaRepository<Person, Long> {

  Optional<Person> findByUsername(String username);

}
