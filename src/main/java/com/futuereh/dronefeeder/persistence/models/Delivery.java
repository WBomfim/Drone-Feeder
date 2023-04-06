package com.futuereh.dronefeeder.persistence.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Deliveries Model.
 *
 */
@Entity
@Table(name = "deliveries")
public class Delivery extends WaitingList {

  @ManyToOne
  @JoinColumn(name = "drone_id")
  private Drone droneId;

  @Column(name = "departure_date")
  private LocalDateTime departureDate;

  @Column(name = "lat_withdrawal_address")
  private String latWithdrawalAddress;

  @Column(name = "long_withdrawal_address")
  private String longWithdrawalAddress;

  @Column(name = "delivery_date")
  private String deliveryDate;

  @Column(name = "lat_delivery_address")
  private String latDeliveryAddress;

  @Column(name = "long_delivery_address")
  private String longDeliveryAddress;

  @ManyToOne
  @JoinColumn(name = "video_id")
  private Video videoId;

  public Drone getDroneId() {
    return droneId;
  }

  public void setDroneId(Drone droneId) {
    this.droneId = droneId;
  }

  public LocalDateTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(LocalDateTime departureDate) {
    this.departureDate = departureDate;
  }

  public String getLatWithdrawalAddress() {
    return latWithdrawalAddress;
  }

  public void setLatWithdrawalAddress(String latWithdrawalAddress) {
    this.latWithdrawalAddress = latWithdrawalAddress;
  }

  public String getLongWithdrawalAddress() {
    return longWithdrawalAddress;
  }

  public void setLongWithdrawalAddress(String longWithdrawalAddress) {
    this.longWithdrawalAddress = longWithdrawalAddress;
  }

  public String getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(String deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public String getLatDeliveryAddress() {
    return latDeliveryAddress;
  }

  public void setLatDeliveryAddress(String latDeliveryAddress) {
    this.latDeliveryAddress = latDeliveryAddress;
  }

  public String getLongDeliveryAddress() {
    return longDeliveryAddress;
  }

  public void setLongDeliveryAddress(String longDeliveryAddress) {
    this.longDeliveryAddress = longDeliveryAddress;
  }

  public Video getVideoId() {
    return videoId;
  }

  public void setVideoId(Video videoId) {
    this.videoId = videoId;
  }

}
