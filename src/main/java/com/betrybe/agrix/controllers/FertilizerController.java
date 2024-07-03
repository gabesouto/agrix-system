package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.FertilizerDto;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.services.FertilizerService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @GetMapping
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public List<FertilizerDto> getAllFertilizers() {
    return this.fertilizerService.getAllFertilizers().stream()
        .map(FertilizerDto::convertToFertilizerDto)
        .collect(Collectors.toList());
  }


  @PostMapping
  public ResponseEntity<FertilizerDto> createFarm(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer newFertilizer = this.fertilizerService.insertFertilizer(
        fertilizerDto.toFertilizer());

    FertilizerDto response = new FertilizerDto(newFertilizer.getId(),
        newFertilizer.getName(),
        newFertilizer.getBrand(),
        newFertilizer.getComposition());
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }


  @GetMapping("/{fertilizerId}")
  public ResponseEntity<Optional<FertilizerDto>> getFertilizerById(
      @PathVariable Long fertilizerId) {
    return ResponseEntity.ok(this.fertilizerService.getFertilizerById(fertilizerId));
  }


}
