package com.futuereh.dronefeeder.persistence.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Delivery Model.
 *
 */
@Entity
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private LocalDateTime dateTime;

  private String latitude;

  private String longitude;

  private String videoUrl;
  
  private boolean delivered;
  
  private Long droneId;

  public Delivery() {}

  public Delivery(LocalDateTime dateTime, String latitude, String longitude,
      String videoUrl, boolean delivered, Long droneId) {
    this.dateTime = dateTime;
    this.latitude = latitude;
    this.longitude = longitude;
    this.videoUrl = videoUrl;
    this.delivered = delivered;
    this.droneId = droneId;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getVideoUrl() {
    return videoUrl;
  }

  public void setVideoUrl(String videoUrl) {
    this.videoUrl = videoUrl;
  }

  public boolean isDelivered() {
    return delivered;
  }

  public void setDelivered(boolean delivered) {
    this.delivered = delivered;
  }

  public Long getDroneId() {
    return droneId;
  }

  public void setDroneId(Long droneId) {
    this.droneId = droneId;
  }

  public Long getId() {
    return id;
  }

}
