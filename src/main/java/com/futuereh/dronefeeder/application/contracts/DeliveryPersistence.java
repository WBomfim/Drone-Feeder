package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Delivery;

/**
 * Interface DeliveryPersistence.
 * 
 */
public interface DeliveryPersistence {

  void saveDelivery(Delivery delivery);
  
}
