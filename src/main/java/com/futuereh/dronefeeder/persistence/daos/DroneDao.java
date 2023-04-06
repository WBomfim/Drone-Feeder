package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.DronePersistence;
import com.futuereh.dronefeeder.persistence.repositories.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class DroneDao.
 * 
 */
@Component
public class DroneDao implements DronePersistence {
  
  @Autowired
  private DroneRepository droneRepository;

}
