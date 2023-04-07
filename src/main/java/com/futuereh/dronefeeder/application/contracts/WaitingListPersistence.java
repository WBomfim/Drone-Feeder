package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.WaitingList;

/**
 * Interface WaitingListPersistence.
 * 
 */
public interface WaitingListPersistence {

  void saveDelivery(WaitingList waitingList);
  
}
