package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Drone;

/**
 * Interface DronePersistence.
 * 
 */
public interface DronePersistence {

  public Drone selectNextDrone();
  
}
