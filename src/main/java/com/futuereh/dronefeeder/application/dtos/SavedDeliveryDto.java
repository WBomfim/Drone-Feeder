package com.futuereh.dronefeeder.application.dtos;

/**
 * Class savedDelivery.
 * 
 */
public class SavedDeliveryDto {

  private Integer clientId;

  private String withdrawalAddress;

  private String deliveryAddress;

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
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
