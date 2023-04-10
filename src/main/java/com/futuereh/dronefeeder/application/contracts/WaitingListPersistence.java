package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.WaitingList;
import java.util.Optional;

/**
 * Interface WaitingListPersistence.
 * 
 */
public interface WaitingListPersistence {

  void saveWaitingList(WaitingList waitingList);

  void updateWaitingList(WaitingList waitingList);

  void deleteWaitingList(WaitingList waitingList);

  Optional<WaitingList> getWaitingListByDeliveryId(int waitingListId);

  WaitingList getNextDelivery();
  
}
