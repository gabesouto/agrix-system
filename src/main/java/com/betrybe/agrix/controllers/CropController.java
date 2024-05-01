package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.CropDto;
import com.betrybe.agrix.dtos.FertilizerDto;
import com.betrybe.agrix.services.FarmService;
import com.betrybe.agrix.services.FertilizerService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the Crop resource.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final FarmService service;
  private final FertilizerService fertilizerService;

  @Autowired
  public CropController(FarmService farmService, FertilizerService fertilizerService) {
    this.service = farmService;
    this.fertilizerService = fertilizerService;
  }

  /**
   * List all Crops.
   */

  @GetMapping
  @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MANAGER')")
  public ResponseEntity<List<CropDto>> getCrops() {
    return ResponseEntity.ok(this.service.getAllCrops());
  }
 
  @GetMapping("/{id}")
  public ResponseEntity<CropDto> getCropById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(this.service.getCropById(id));
  }

  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<Optional<String>> postCropToFertilizer(@PathVariable long cropId,
      @PathVariable long fertilizerId) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.fertilizerService.setFertilizer(fertilizerId, cropId));
  }

  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<Optional<List<FertilizerDto>>> getFertilizerByCrop(
      @PathVariable long cropId) {
    return ResponseEntity.ok(Optional.ofNullable(this.service.getFertilizerByCrop(cropId)));
  }

  /**
   * Retrieves a list of crops per date.
   *
   * @param start The ID of the crop from which to retrieve crops.
   * @param end   The ID of the crop from which to retrieve crops.
   * @return the list.
   */
  @GetMapping("/search")
  public ResponseEntity<List<CropDto>> searchByHarvestDateBetweenDates(
      @RequestParam LocalDate start,
      @RequestParam LocalDate end
  ) {
    List<CropDto> crops = this.service.searchHarvestDate(start, end);

    return ResponseEntity.ok(crops);
  }
}
