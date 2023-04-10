package com.futuereh.dronefeeder.application.results;

/**
 * Class DeliveryToTheDrone.
 * 
 */
public class DeliveryToTheDrone {

  private int deliveryId;

  private String withdrawalAddress;

  private String deliveryAddress;

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
