package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Delivery Repository.
 * 
 */
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {}
