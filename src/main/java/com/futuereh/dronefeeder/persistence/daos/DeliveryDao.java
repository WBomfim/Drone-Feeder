package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.persistence.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class DeliveryDao.
 * 
 */
@Component
public class DeliveryDao {
  
  @Autowired
  private DeliveryRepository deliveryRepository;

}
