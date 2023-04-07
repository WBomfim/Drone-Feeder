package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import java.util.List;

/**
 * Interface DeliveryPersistence.
 * 
 */
public interface DeliveryPersistence {

  void saveDelivery(Delivery delivery);

  List<Delivery> getDeliveriesByClient(Client client);
  
}
