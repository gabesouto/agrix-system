package com.betrybe.agrix.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing a farm.
 */
@Entity
@Table(name = "farms")
public class Farm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private double size;

  @OneToMany(mappedBy = "farm",
      cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Crop> crops = new ArrayList<>();

  public List<Crop> getCrops() {
    return crops;
  }

  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }

  /**
   * Default constructor.
   */
  public Farm() {
  }

  /**
   * Parameterized constructor.
   *
   * @param id   The ID of the farm.
   * @param name The name of the farm.
   * @param size The size of the farm.
   */
  public Farm(Long id, String name, double size, List<Crop> crops) {
    this.id = id;
    this.name = name;
    this.size = size;
    this.crops = crops;
  }

  /**
   * Retrieves the ID of the farm.
   *
   * @return The ID of the farm.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the ID of the farm.
   *
   * @param id The ID of the farm.
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Retrieves the name of the farm.
   *
   * @return The name of the farm.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the farm.
   *
   * @param name The name of the farm.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Retrieves the size of the farm.
   *
   * @return The size of the farm.
   */
  public double getSize() {
    return size;
  }

  /**
   * Sets the size of the farm.
   *
   * @param size The size of the farm.
   */
  public void setSize(double size) {
    this.size = size;
  }
}
