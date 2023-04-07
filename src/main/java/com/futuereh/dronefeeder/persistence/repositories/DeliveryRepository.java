package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Delivery Repository.
 * 
 */
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

  @Query("SELECT d FROM Delivery d WHERE d.clientId = ?1")
  List<Delivery> getDeliveriesByClient(Client clientId);

}
