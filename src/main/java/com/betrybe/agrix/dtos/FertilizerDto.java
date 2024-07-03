package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Fertilizer;


public record FertilizerDto(Long id, String name, String brand, String composition) {


  public Fertilizer toFertilizer() {
    return new Fertilizer(id, name, brand, composition);
  }


  public static FertilizerDto convertToFertilizerDto(Fertilizer fertilizer) {
    return new FertilizerDto(
        fertilizer.getId(),
        fertilizer.getName(),
        fertilizer.getBrand(),
        fertilizer.getComposition());
  }
}
