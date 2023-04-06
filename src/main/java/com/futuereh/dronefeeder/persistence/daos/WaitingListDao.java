package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.persistence.repositories.WaitingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class WaitingListDao.
 * 
 */
@Component
public class WaitingListDao {
  
  @Autowired
  private WaitingListRepository waitingListRepository;

}
