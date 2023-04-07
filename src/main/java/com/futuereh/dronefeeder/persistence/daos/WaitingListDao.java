package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.WaitingListPersistence;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import com.futuereh.dronefeeder.persistence.repositories.WaitingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class WaitingListDao.
 * 
 */
@Component
public class WaitingListDao implements WaitingListPersistence {
  
  @Autowired
  private WaitingListRepository waitingListRepository;

  public void saveDelivery(WaitingList waitingList) {
    waitingListRepository.save(waitingList);
    return;
  }

}
