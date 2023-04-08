package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import java.util.List;
import java.util.Optional;

/**
 * Interface WaitingListPersistence.
 * 
 */
public interface WaitingListPersistence {

  void saveDelivery(WaitingList waitingList);

  List<WaitingList> getWaitingListByClient(Client client);

  Optional<WaitingList> getWaitingListById(int waitingListId);
  
}
