package com.betrybe.agrix.dtos;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) representing a crop.
 */
public record CropDto(
    Long id,
    String name,
    Double plantedArea,
    LocalDate plantedDate,
    LocalDate harvestDate,
    Long farmId

) {


}
