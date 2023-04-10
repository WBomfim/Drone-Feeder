package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import java.util.List;
import java.util.Optional;

/**
 * Interface DeliveryPersistence.
 * 
 */
public interface DeliveryPersistence {

  Delivery saveDelivery(Delivery delivery);

  void updateDelivery(Delivery delivery);

  void deleteDelivery(Delivery delivery);

  Optional<Delivery> getDeliveryById(int deliveryId);

  List<Delivery> getDeliveriesByClient(Client client);

}
