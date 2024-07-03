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


  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }


  @PostMapping
  public ResponseEntity<Farm> createFarm(@RequestBody FarmDto farmDto) {
    Farm newFarm = this.farmService.insertFarm(farmDto.toFarm());
    return ResponseEntity.status(HttpStatus.CREATED).body(newFarm);
  }


  @GetMapping
  public ResponseEntity<List<Farm>> getFarms() {
    return ResponseEntity.ok(this.farmService.getAllFarms());
  }


  @GetMapping("/{farmId}")
  public ResponseEntity<Optional<Farm>> getFarmById(@PathVariable Long farmId) {
    return ResponseEntity.ok(this.farmService.getFarmById(farmId));
  }

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
