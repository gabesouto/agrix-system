package com.betrybe.agrix.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * Entity class representing a crop.
 */
@Entity
@Table(name = "crops")
public class Crop {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;
  private String name;
  private Double plantedArea;

  private LocalDate plantedDate;

  private LocalDate harvestDate;
  @ManyToMany
  @JoinTable(
      name = "crops_fertilizers",
      joinColumns = @JoinColumn(name = "crop_id"),
      inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  private List<Fertilizer> fertilizers;


  public Crop() {
  }

  /**
   * Constructor of entity crop.
   */


  public Crop(
      Farm farm,
      String name,
      Double plantedArea,
      LocalDate plantedDate,
      LocalDate harvestDate

  ) {
    this.farm = farm;
    this.name = name;
    this.plantedArea = plantedArea;
    this.harvestDate = harvestDate;
    this.plantedDate = plantedDate;


  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPlantedArea() {
    return plantedArea;
  }

  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Retrieves the ID of the crop.
   *
   * @return The ID of the crop.
   */
  public Long getId() {
    return id;
  }

  /**
   * Retrieves the farm associated with the crop.
   *
   * @return The farm associated with the crop.
   */
  public Farm getFarm() {
    return farm;
  }

  /**
   * Sets the farm associated with the crop.
   *
   * @param farm The farm to associate with the crop.
   */
  public void setFarm(Farm farm) {
    this.farm = farm;
  }

  public LocalDate getPlantedDate() {
    return plantedDate;
  }


  public LocalDate getHarvestDate() {
    return harvestDate;
  }

  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  public List<Fertilizer> getFertiliziers() {
    return fertilizers;
  }

  public void setFertiliziers(List<Fertilizer> fertilizers) {
    this.fertilizers = fertilizers;
  }
}
