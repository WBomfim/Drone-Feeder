package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * WaitingList Repository.
 * 
 */
@Repository
public interface WaitingListRepository extends JpaRepository<WaitingList, Integer> {}
