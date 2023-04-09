package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.WaitingListPersistence;
import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import com.futuereh.dronefeeder.persistence.repositories.WaitingListRepository;
import java.util.List;
import java.util.Optional;
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

  public void updateDelivery(WaitingList waitingList) {
    waitingListRepository.save(waitingList);
    return;
  }

  public void deleteDelivery(WaitingList waitingList) {
    waitingListRepository.delete(waitingList);
    return;
  }

  public List<WaitingList> getWaitingListByClient(Client client) {
    return waitingListRepository.getWaitingListByClient(client);
  }

  public Optional<WaitingList> getWaitingListById(int waitingListId) {
    return waitingListRepository.getWaitingListById(waitingListId);
  }

  public WaitingList getNextDelivery() {
    return waitingListRepository.findAll().get(0);
  }

}
