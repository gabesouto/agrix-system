package com.betrybe.agrix.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 * Represents a fertilzer used in agricultural practices. Each fertilizer has an identifier, name,
 * composition, and associated crops it can be used for.
 */
@Entity
@Table(name = "fertilizers")
public class Fertilizer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String composition;
  private String brand;
  @ManyToMany(mappedBy = "fertilizers")
  @JsonIgnoreProperties("fertilizers")
  private List<Crop> crops;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }


  public Fertilizer() {

  }

  /**
   * Constructs a new Fertilizer object with the given parameters.
   *
   * @param id          The unique identifier for the fertilizer.
   * @param name        The name of the fertilizer.
   * @param composition The composition or ingredients of the fertilizer.
   * @param brand       The brand.
   */

  public Fertilizer(Long id, String name, String brand, String composition) {
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.composition = composition;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getComposition() {
    return composition;
  }

  public void setComposition(String composition) {
    this.composition = composition;
  }

  public List<Crop> getCrops() {
    return crops;
  }

  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }
}
