package com.futuereh.dronefeeder.persistence.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WaitingList Model.
 * 
 */
@Entity
@Table(name = "waiting_list")
public class WaitingList {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int deliveryId;

  @Column(name = "withdrawal_address")
  private String withdrawalAddress;

  @Column(name = "delivery_address")
  private String deliveryAddress;

  public int getId() {
    return id;
  }

  public int getDeliveryId() {
    return deliveryId;
  }

  public void setDeliveryId(int deliveryId) {
    this.deliveryId = deliveryId;
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
  
}
