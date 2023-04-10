package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Drone;
import java.util.List;
import java.util.Optional;


/**
 * Interface DronePersistence.
 * 
 */
public interface DronePersistence {

  public Optional<Drone> getDroneById(int droneId);

  public List<Drone> getDronesByStatus(String status);

  public void updateDroneStatus(Drone drone);
  
}
