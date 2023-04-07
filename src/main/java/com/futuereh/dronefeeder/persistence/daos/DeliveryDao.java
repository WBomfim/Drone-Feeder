package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.DeliveryPersistence;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import com.futuereh.dronefeeder.persistence.repositories.DeliveryRepository;
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

}
