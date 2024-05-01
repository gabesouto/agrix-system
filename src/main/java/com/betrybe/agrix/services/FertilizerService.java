package com.betrybe.agrix.services;

import com.betrybe.agrix.dtos.FertilizerDto;
import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.exception.FertilizerNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for handling fertilizier-related operations.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;
  private final CropRepository cropRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizierRepository,
      CropRepository cropRepository) {
    this.fertilizerRepository = fertilizierRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Retrieves all farms from the database.
   *
   * @return A list of all fertiliziers.
   */

  public List<Fertilizer> getAllFertilizers() {
    return this.fertilizerRepository.findAll();
  }

  public Fertilizer insertFertilizer(Fertilizer fertilizer) {
    return this.fertilizerRepository.save(fertilizer);
  }

  /**
   * Retrieves a farm by its ID.
   *
   * @param fertilizerId The ID of the fertilizer to retrieve.
   * @return An Optional containing the farm if found, or empty if not found.
   * @throws FertilizerNotFoundException if the fertilizer with the given ID is not found.
   */
  public Optional<FertilizerDto> getFertilizerById(Long fertilizerId) {
    Optional<Fertilizer> optionalFertilizer = this.fertilizerRepository.findById(fertilizerId);
    return Optional.ofNullable(optionalFertilizer.map(fertilizer ->
            new FertilizerDto(fertilizer.getId(), fertilizer.getName(), fertilizer.getBrand(),
                fertilizer.getComposition()))
        .orElseThrow(FertilizerNotFoundException::new));
  }

  /**
   * Set a crop to a fertilizer.
   *
   * @param fertilizerId The ID of the fertilizer to retrieve.
   * @param cropId       The ID of the crop to retrieve.
   * @return An Optional message.
   * @throws FertilizerNotFoundException if the fertilizer with the given ID is not found.
   */
  public Optional<String> setFertilizer(Long fertilizerId, Long cropId) {
    Fertilizer fertilizer = this.fertilizerRepository.findById(fertilizerId)
        .orElseThrow(
            FertilizerNotFoundException::new);

    Crop crop = this.cropRepository.findById(cropId)
        .orElseThrow(CropNotFoundException::new);

    crop.getFertiliziers().add(fertilizer);

    Crop newCrop = this.cropRepository.save(crop);

    return Optional.of("Fertilizante e plantação associados com sucesso!");
  }


}
