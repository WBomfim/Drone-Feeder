package com.futuereh.dronefeeder.application.services;

import com.futuereh.dronefeeder.application.dtos.UpdateDeliveryByDrone;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.utils.DeliveryStatus;
import com.futuereh.dronefeeder.persistence.daos.DeliveryDao;
import com.futuereh.dronefeeder.persistence.daos.DroneDao;
import com.futuereh.dronefeeder.persistence.daos.VideoDao;
import com.futuereh.dronefeeder.persistence.daos.WaitingListDao;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import com.futuereh.dronefeeder.persistence.models.Drone;
import com.futuereh.dronefeeder.presentation.exceptions.NotFoundException;

import java.time.LocalDateTime;

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
  
  /**
   * Method getNextDelivery.
   * 
   */
  public Delivery getNextDeliveryByDrone(int droneId) {
    Drone drone = droneDao.getDroneById(droneId);

    Delivery delivery = deliveryDao.getNextDeliveryByDrone(drone);

    if (delivery == null) {
      throw new NotFoundException("Order not found");
    }

    return delivery;
  }

  /**
   * Method startDelivery.
   * 
   */
  public MessageResult startDelivery(int deliveryId, UpdateDeliveryByDrone updateDeliveryByDrone) {
    Delivery delivery = deliveryDao.getDeliveryById(deliveryId)
        .orElseThrow(() -> new NotFoundException("Delivery not found"));

    delivery.setStatus(DeliveryStatus.IN_PROGRESS.toString());
    delivery.setDepartureDate(LocalDateTime.now());
    delivery.setLatWithdrawalAddress(updateDeliveryByDrone.getLatitude());
    delivery.setLongWithdrawalAddress(updateDeliveryByDrone.getLongitude());

    deliveryDao.updateDelivery(delivery);
    return new MessageResult("Delivery started");
  }

}
