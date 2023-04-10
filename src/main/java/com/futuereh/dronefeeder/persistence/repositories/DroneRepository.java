package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.Drone;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Drone Repository.
 * 
 */
@Component
public interface DroneRepository extends JpaRepository<Drone, Integer> {

  public Optional<Drone> findById(int droneId);

  public List<Drone> findByStatus(String status);

}
