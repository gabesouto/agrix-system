package com.betrybe.agrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application main class.
 */
@EntityScan({"com.betrybe.agrix.models.entities",
    "com.betrybe.agrix.ebytr.staff.entity"})
@EnableJpaRepositories({"com.betrybe.agrix.models.repositories",
    "com.betrybe.agrix.ebytr.staff.repository"})
@ComponentScan("com.betrybe.agrix")
@SpringBootApplication
public class AgrixApplication {

  public static void main(String[] args) {
    SpringApplication.run(AgrixApplication.class, args);
  }

}
