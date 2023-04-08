package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * WaitingList Repository.
 * 
 */
@Repository
public interface WaitingListRepository extends JpaRepository<WaitingList, Integer> {

  @Query("SELECT w FROM WaitingList w WHERE w.clientId = ?1")
  List<WaitingList> getWaitingListByClient(Client client);

  Optional<WaitingList> getWaitingListById(int waitingListId);

  List<WaitingList> findAll();
  
}
