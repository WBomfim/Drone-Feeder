package com.futuereh.dronefeeder.application.services;

import com.futuereh.dronefeeder.persistence.daos.DeliveryDao;
import com.futuereh.dronefeeder.persistence.daos.DroneDao;
import com.futuereh.dronefeeder.persistence.daos.VideoDao;
import com.futuereh.dronefeeder.persistence.daos.WaitingListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class DroneService.
 * 
 */
@Service
public class DroneService {

  @Autowired
  private DroneDao droneDao;

  @Autowired
  private DeliveryDao deliveryDao;

  @Autowired
  private WaitingListDao waitingListDao;

  @Autowired
  private VideoDao videoDao;
  
}
