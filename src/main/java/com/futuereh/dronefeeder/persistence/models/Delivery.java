package com.futuereh.dronefeeder.persistence.models;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Deliveries Model.
 *
 */
@Entity
@Table(name = "deliveries")
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client clientId;

  @ManyToOne
  @JoinColumn(name = "drone_id")
  private Drone droneId;

  @Column(name = "request_date")
  private LocalDateTime requestDate;

  @Column(name = "withdrawal_address")
  private String withdrawalAddress;

  @Column(name = "delivery_address")
  private String deliveryAddress;

  @Column
  private String status;

  @Column(name = "departure_date")
  private LocalDateTime departureDate;

  @Column(name = "lat_withdrawal_address")
  private String latWithdrawalAddress;

  @Column(name = "long_withdrawal_address")
  private String longWithdrawalAddress;

  @Column(name = "delivery_date")
  private LocalDateTime deliveryDate;

  @Column(name = "lat_delivery_address")
  private String latDeliveryAddress;

  @Column(name = "long_delivery_address")
  private String longDeliveryAddress;

  @ManyToOne
  @JoinColumn(name = "video_id")
  private Video videoId;

  public int getId() {
    return id;
  }

  public Client getClientId() {
    return clientId;
  }

  public void setClientId(Client clientId) {
    this.clientId = clientId;
  }

  public Drone getDroneId() {
    return droneId;
  }

  public void setDroneId(Drone droneId) {
    this.droneId = droneId;
  }

  public LocalDateTime getRequestDate() {
    return requestDate;
  }

  public void setRequestDate(LocalDateTime requestDate) {
    this.requestDate = requestDate;
  }

  public String getWithdrawalAddress() {
    return withdrawalAddress;
  }

  public void setWithdrawalAddress(String withdrawalAddress) {
    this.withdrawalAddress = withdrawalAddress;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }

  public void setDeliveryAddress(String deliveryAddress) {
    this.deliveryAddress = deliveryAddress;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

  public LocalDateTime getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDateTime deliveryDate) {
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
