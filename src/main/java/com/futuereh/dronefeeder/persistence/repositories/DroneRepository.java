package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Drone Repository.
 * 
 */
@Repository
public interface DroneRepository extends JpaRepository<Drone, Integer> {}