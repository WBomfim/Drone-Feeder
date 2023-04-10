package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.WaitingList;
import java.util.List;
import java.util.Optional;

/**
 * Interface WaitingListPersistence.
 * 
 */
public interface WaitingListPersistence {

  public void saveWaitingList(WaitingList waitingList);

  public void updateWaitingList(WaitingList waitingList);

  public void deleteWaitingList(WaitingList waitingList);

  public Optional<WaitingList> getWaitingListByDeliveryId(int waitingListId);

  public List<WaitingList> getAllWaitingList();
  
}
