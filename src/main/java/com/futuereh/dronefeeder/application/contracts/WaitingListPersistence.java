package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import java.util.List;

/**
 * Interface WaitingListPersistence.
 * 
 */
public interface WaitingListPersistence {

  void saveDelivery(WaitingList waitingList);

  List<WaitingList> getWaitingListByClient(Client client);
  
}
