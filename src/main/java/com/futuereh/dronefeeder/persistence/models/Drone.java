package com.futuereh.dronefeeder.persistence.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Drone Model.
 * 
 */
@Entity
@Table(name = "drones")
public class Drone {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column
  private String status;

  public int getId() {
    return id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
  
}
