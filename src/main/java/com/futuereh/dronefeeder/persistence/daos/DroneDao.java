package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.DronePersistence;
import com.futuereh.dronefeeder.persistence.models.Drone;
import com.futuereh.dronefeeder.persistence.repositories.DroneRepository;
import java.util.List;
import java.util.Optional;
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
   * Update drone status.
   *
   */
  public void updateDrone(Drone drone) {
    droneRepository.save(drone);
  }

  /**
   * Select drone by id.
   *
   */
  public Optional<Drone> getDroneById(int droneId) {
    return droneRepository.findById(droneId);
  }

  /**
   * Select next drone.
   *
   */
  public List<Drone> getDronesByStatus(String status) {
    return droneRepository.findByStatus(status);

  }

}
