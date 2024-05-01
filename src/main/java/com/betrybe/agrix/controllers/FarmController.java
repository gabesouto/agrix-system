package com.betrybe.agrix.controllers;


import com.betrybe.agrix.dtos.CropDto;
import com.betrybe.agrix.dtos.FarmDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing farm-related endpoints.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  /**
   * Constructs a new instance of FarmController.
   *
   * @param farmService The FarmService instance to use.
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Handles POST requests to create a new farm.
   *
   * @param farmDto The DTO containing farm information.
   * @return ResponseEntity containing the response status and created farm.
   */
  @PostMapping
  public ResponseEntity<Farm> createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = this.farmService.insertFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }

  /**
   * Handles GET requests to test the endpoint.
   *
   * @return A string indicating that the endpoint is up.
   */
  @GetMapping
  public ResponseEntity<List<Farm>> getFarms() {
    return ResponseEntity.ok(this.farmService.getAllFarms());
  }

  /**
   * Retrieves a farm by its ID.
   *
   * @param farmId The ID of the farm to retrieve.
   * @return ResponseEntity containing the farm if found, or an empty body if not found.
   */
  @GetMapping("/{farmId}")
  public ResponseEntity<Optional<Farm>> getFarmById(@PathVariable Long farmId) {
    return ResponseEntity.ok(this.farmService.getFarmById(farmId));
  }

  /**
   * Retrieves all crops from a specified farm.
   *
   * @param farmId The ID of the farm from which to retrieve crops.
   * @return ResponseEntity containing the list of crops from the farm.
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<CropDto>> getCropsFromFarm(@PathVariable Long farmId) {
    return ResponseEntity.ok(this.farmService.getAllCropsFromFarm(farmId));
  }

  @PostMapping("/{farmId}/crops")
  public ResponseEntity<CropDto> createFarmCrop(@PathVariable Long farmId,
      @RequestBody CropDto cropDto) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(this.farmService.createFarmCrop(farmId, cropDto));
  }


}
