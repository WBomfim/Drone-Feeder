package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.DeliveryPersistence;
import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import com.futuereh.dronefeeder.persistence.models.Drone;
import com.futuereh.dronefeeder.persistence.repositories.DeliveryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class DeliveryDao.
 * 
 */
@Component
public class DeliveryDao implements DeliveryPersistence {
  
  @Autowired
  private DeliveryRepository deliveryRepository;

  public void saveDelivery(Delivery delivery) {
    deliveryRepository.save(delivery);
  }

  public void updateDelivery(Delivery delivery) {
    deliveryRepository.save(delivery);
  }

  public void deleteDelivery(Delivery delivery) {
    deliveryRepository.delete(delivery);
  }

  public Optional<Delivery> getDeliveryById(int deliveryId) {
    return deliveryRepository.getDeliveryById(deliveryId);
  }

  public List<Delivery> getDeliveriesByClient(Client clientId) {
    return deliveryRepository.getDeliveriesByClient(clientId);
  }

  public Delivery getNextDeliveryByDrone(Drone drone) {
    return deliveryRepository.getNextDeliveryByDrone(drone);
  }
  
}
