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
 * WaitingList Model.
 * 
 */
@Entity
@Table(name = "waiting_list")
public class WaitingList {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client clientId;

  @Column(name = "request_date")
  private LocalDateTime requestDate;

  @Column(name = "withdrawal_address")
  private String withdrawalAddress;

  @Column(name = "delivery_address")
  private String deliveryAddress;

  @Column
  private String status;

  public int getId() {
    return id;
  }

  public Client getClientId() {
    return clientId;
  }

  public void setClientId(Client clientId) {
    this.clientId = clientId;
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
  
}
