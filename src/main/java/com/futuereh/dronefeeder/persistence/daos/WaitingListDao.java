package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.WaitingListPersistence;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import com.futuereh.dronefeeder.persistence.repositories.WaitingListRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Class WaitingListDao.
 * 
 */
@Repository
public class WaitingListDao implements WaitingListPersistence {
  
  @Autowired
  private WaitingListRepository waitingListRepository;

  public void saveWaitingList(WaitingList waitingList) {
    waitingListRepository.save(waitingList);
    return;
  }

  public void updateWaitingList(WaitingList waitingList) {
    waitingListRepository.save(waitingList);
    return;
  }

  public void deleteWaitingList(WaitingList waitingList) {
    waitingListRepository.delete(waitingList);
    return;
  }

  public Optional<WaitingList> getWaitingListByDeliveryId(int deliveryId) {
    return waitingListRepository.findByDeliveryId(deliveryId);
  }

  public List<WaitingList> getAllWaitingList() {
    return waitingListRepository.findAll();
  }

}
