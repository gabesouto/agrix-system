package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing a farm.
 */
public record FarmDto(Long id, String name, double size, List<Crop> crops) {

  /**
   * Converts the FarmDTO object to a Farm entity.
   *
   * @return The corresponding Farm entity.
   */
  public Farm toFarm() {
    return new Farm(id, name, size, crops);
  }
}
