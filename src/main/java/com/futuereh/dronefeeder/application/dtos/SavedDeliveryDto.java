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

  public String getWithdrawalAddress() {
    return withdrawalAddress;
  }

  public String getDeliveryAddress() {
    return deliveryAddress;
  }
  
}
