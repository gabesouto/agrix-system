package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Fertilizer;


/**
 * Data Transfer Object (DTO) representing a fertilizier.
 */
public record FertilizerDto(Long id, String name, String brand, String composition) {

  /**
   * Converts the FertilizierDto object to a Fertilizier entity.
   *
   * @return The corresponding Fertilizier entity.
   */
  public Fertilizer toFertilizer() {
    return new Fertilizer(id, name, brand, composition);
  }


  /**
   * Converts the Fertilizier object to a FertilizierDto entity.
   *
   * @return The corresponding FertilizierDto entity.
   */
  public static FertilizerDto convertToFertilizerDto(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition());
  }
}
