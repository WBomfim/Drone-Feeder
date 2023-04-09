package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Drone;

/**
 * Interface DronePersistence.
 * 
 */
public interface DronePersistence {

  Drone getDroneById(int droneId);

  public Drone selectNextDrone();

  public void updateDroneStatus(Drone drone);
  
}
