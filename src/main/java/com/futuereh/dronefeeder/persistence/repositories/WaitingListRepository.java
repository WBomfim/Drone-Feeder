package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.WaitingList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

/**
 * WaitingList Repository.
 * 
 */
@Component
public interface WaitingListRepository extends JpaRepository<WaitingList, Integer> {

  @Query("SELECT w FROM WaitingList w WHERE w.deliveryId = ?1")
  Optional<WaitingList> findByDeliveryId(int deliveryId);

  List<WaitingList> findAll();
  
}
