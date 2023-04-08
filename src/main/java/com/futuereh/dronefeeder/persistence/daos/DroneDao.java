package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.DronePersistence;
import com.futuereh.dronefeeder.persistence.models.Drone;
import com.futuereh.dronefeeder.persistence.repositories.DroneRepository;
import java.util.List;
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

  /**
   * Select next drone.
   *
   */
  public Drone selectNextDrone() {
    List<Drone> drones = droneRepository.findByStatus("waiting");
    if (drones.size() > 0) {
      return drones.get(0);
    }
    return null;
  }

  /**
   * Update drone status.
   *
   */
  public void updateDroneStatus(Drone drone) {
    droneRepository.save(drone);
  }

}
