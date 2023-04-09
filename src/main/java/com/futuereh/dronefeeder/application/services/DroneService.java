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
import com.futuereh.dronefeeder.persistence.models.Video;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import com.futuereh.dronefeeder.presentation.exceptions.NotFoundException;
import java.sql.Blob;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
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
  @Transactional
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

  /**
   * Method finishDelivery.
   * 
   */
  public MessageResult finishDelivery(int deliveryId, UpdateDeliveryByDrone updateDeliveryByDrone) {
    Delivery delivery = deliveryDao.getDeliveryById(deliveryId)
        .orElseThrow(() -> new NotFoundException("Delivery not found"));

    delivery.setStatus(DeliveryStatus.DELIVERED.toString());
    delivery.setDeliveryDate(LocalDateTime.now());
    delivery.setLatDeliveryAddress(updateDeliveryByDrone.getLatitude());
    delivery.setLongDeliveryAddress(updateDeliveryByDrone.getLongitude());

    deliveryDao.updateDelivery(delivery);
    return new MessageResult("Delivery finished");
  }

  /**
   * Method getNextDelivery.
   * 
   */
  @Transactional
  public Delivery getNextDelivery(int droneId) {
    Drone drone = droneDao.getDroneById(droneId);

    WaitingList waitingList = waitingListDao.getNextDelivery();

    Delivery delivery = new Delivery();
    delivery.setClientId(waitingList.getClientId());
    delivery.setDroneId(drone);
    delivery.setRequestDate(waitingList.getRequestDate());
    delivery.setWithdrawalAddress(waitingList.getWithdrawalAddress());
    delivery.setDeliveryAddress(waitingList.getDeliveryAddress());
    delivery.setStatus(waitingList.getStatus());

    deliveryDao.saveDelivery(delivery);
    waitingListDao.deleteDelivery(waitingList);

    return getNextDeliveryByDrone(droneId);
  }

  /**
   * Method saveVideo.
   * 
   */
  @Transactional
  public MessageResult saveVideo(int deliveryId, Blob video) {
    Delivery delivery = deliveryDao.getDeliveryById(deliveryId)
        .orElseThrow(() -> new NotFoundException("Delivery not found"));

    Video newVideo = new Video();
    newVideo.setVideo(video);

    Video savedVideo = videoDao.saveVideo(newVideo);

    delivery.setVideoId(savedVideo);
    
    return new MessageResult("Video saved");
  }

}
