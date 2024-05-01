package com.betrybe.agrix.services;

import com.betrybe.agrix.dtos.CropDto;
import com.betrybe.agrix.dtos.FertilizerDto;
import com.betrybe.agrix.exception.CropNotFoundException;
import com.betrybe.agrix.exception.FarmNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class responsible for handling farm-related operations.
 */
@Service
public class FarmService {

  private final FarmRepository farmRespository;
  private final CropRepository cropRepository;

  DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


  /**
   * Constructor for FarmService.
   *
   * @param farmRepository The repository for farm entities.
   * @param cropRepository The repository for crop entities.
   */
  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.cropRepository = cropRepository;
    this.farmRespository = farmRepository;
  }

  /**
   * Inserts a new farm into the database.
   *
   * @param farm The farm to insert.
   * @return The inserted farm.
   */
  public Farm insertFarm(Farm farm) {
    return this.farmRespository.save(farm);
  }

  /**
   * Retrieves all farms from the database.
   *
   * @return A list of all farms.
   */
  public List<Farm> getAllFarms() {
    return this.farmRespository.findAll();
  }

  /**
   * Retrieves all crops from the database.
   *
   * @return A list of all crops.
   */
  public List<CropDto> getAllCrops() {
    List<CropDto> cropDtos = new ArrayList<>();

    for (Crop crop : this.cropRepository.findAll()) {

      CropDto cropDto = new CropDto(crop.getId(),
          crop.getName(),
          crop.getPlantedArea(),
          crop.getPlantedDate(),
          crop.getHarvestDate(),
          crop.getFarm().getId());
      cropDtos.add(cropDto);
    }

    return cropDtos;
  }

  /**
   * Retrieves a farm by its ID.
   *
   * @param farmId The ID of the farm to retrieve.
   * @return An Optional containing the farm if found, or empty if not found.
   * @throws FarmNotFoundException if the farm with the given ID is not found.
   */
  public Optional<Farm> getFarmById(Long farmId) {
    return Optional.ofNullable(
        this.farmRespository.findById(farmId).orElseThrow(FarmNotFoundException::new));
  }


  /**
   * Retrieves all crops from a specified farm.
   *
   * @param farmId The ID of the farm from which to retrieve crops.
   * @return A list of crops from the specified farm.
   * @throws FarmNotFoundException if the farm with the given ID is not found.
   */
  public List<CropDto> getAllCropsFromFarm(Long farmId) {
    Optional<Farm> optionalFarm = this.farmRespository.findById(farmId);
    if (optionalFarm.isEmpty()) {
      throw new FarmNotFoundException();
    }
    Farm farm = optionalFarm.get();
    List<Crop> crops = farm.getCrops();
    List<CropDto> cropDtos = new ArrayList<>();

    for (Crop crop : crops) {
      CropDto cropDto = new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(),
          crop.getPlantedDate(),
          crop.getHarvestDate(),
          crop.getFarm().getId());

      cropDtos.add(cropDto);
    }
    return cropDtos;
  }

  /**
   * Retrieves one created crop from a specified farm.
   *
   * @param farmId The ID of the farm from which to retrieve crops.
   * @return the crop created from the specified farm.
   * @throws FarmNotFoundException if the farm with the given ID is not found.
   */
  public CropDto createFarmCrop(Long farmId, CropDto cropDto) {
    Optional<Farm> optionalFarm = this.farmRespository.findById(farmId);
    if (optionalFarm.isEmpty()) {
      throw new FarmNotFoundException();
    }

    Farm farm = optionalFarm.get();

    Crop newCrop = new Crop(farm,
        cropDto.name(),
        cropDto.plantedArea(),
        cropDto.plantedDate(),
        cropDto.harvestDate());

    System.out.println(newCrop.getHarvestDate());

    farm.getCrops().add(newCrop);
    newCrop = cropRepository.save(newCrop);

    return new CropDto(newCrop.getId(),
        newCrop.getName(),
        newCrop.getPlantedArea(),
        newCrop.getPlantedDate(),
        newCrop.getHarvestDate(),
        newCrop.getFarm().getId());

  }

  /**
   * Retrieves one crop.
   *
   * @param id The ID of the crop from which to retrieve crops.
   * @return the crop.
   * @throws CropNotFoundException if the crop with the given ID is not found.
   */
  public CropDto getCropById(Long id) {
    Optional<Crop> optionalCrop = this.cropRepository.findById(id);

    if (optionalCrop.isEmpty()) {
      throw new CropNotFoundException();
    }
    Crop crop = optionalCrop.get();
    return new CropDto(crop.getId(),
        crop.getName(),
        crop.getPlantedArea(),
        crop.getPlantedDate(),
        crop.getHarvestDate(),
        crop.getFarm().getId());

  }

  /**
   * Retrieves a list of fertilizers associate to a crop.
   *
   * @param cropId The ID of the crop from which to retrieve crops.
   * @return the list.
   * @throws CropNotFoundException if the crop with the given ID is not found.
   */
  public List<FertilizerDto> getFertilizerByCrop(Long cropId) {
    Optional<Crop> optionalCrop = this.cropRepository.findById(cropId);
    Crop crop = this.cropRepository.findById(cropId)
        .orElseThrow(CropNotFoundException::new);

    return crop.getFertiliziers().stream()
        .map(fertilizer -> new FertilizerDto(fertilizer.getId(),
            fertilizer.getName(),
            fertilizer.getBrand(),
            fertilizer.getComposition()
        )).toList();
  }


  /**
   * Retrieves a list of crops associate to a date.
   *
   * @param start The ID of the crop from which to retrieve crops.
   * @param end   The ID of the crop from which to retrieve crops.
   * @return the list.
   */
  public List<CropDto> searchHarvestDate(LocalDate start, LocalDate end) {

    List<Crop> crops = this.cropRepository.findAll().stream()
        .filter(crop -> crop.getHarvestDate().isAfter(start))
        .filter(crop -> crop.getHarvestDate().isBefore(end))
        .toList();

    return crops.stream()
        .map(e -> new CropDto(e.getId(), e.getName(), e.getPlantedArea(), e.getPlantedDate(),
            e.getHarvestDate(), e.getFarm().getId()))
        .toList();
  }
}
