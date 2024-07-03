package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import java.util.List;

public record FarmDto(Long id, String name, double size, List<Crop> crops) {

  public Farm toFarm() {
    return new Farm(id, name, size, crops);
  }
}
