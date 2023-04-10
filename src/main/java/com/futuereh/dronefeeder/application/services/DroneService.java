package com.futuereh.dronefeeder.application.services;

import com.futuereh.dronefeeder.application.dtos.DroneUpdatesDeliveryDto;
import com.futuereh.dronefeeder.application.results.DeliveryToTheDrone;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.utils.DeliveryStatus;
import com.futuereh.dronefeeder.application.utils.DroneStatus;
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
import java.util.List;
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

  private void updateDelivery(
      int deliveryId,
      DroneUpdatesDeliveryDto droneUpdatesDeliveryDto,
      DeliveryStatus status
  ) {
    Delivery delivery = deliveryDao.getDeliveryById(deliveryId)
        .orElseThrow(() -> new NotFoundException("Delivery not found"));
        
    delivery.setStatus(status.toString());
    delivery.setDeliveryDate(LocalDateTime.now());
    delivery.setLatDeliveryAddress(droneUpdatesDeliveryDto.getLatitude());
    delivery.setLongDeliveryAddress(droneUpdatesDeliveryDto.getLongitude());
    deliveryDao.updateDelivery(delivery);
  }

  /**
   * Method startDelivery.
   * 
   */
  @Transactional
  public MessageResult startDelivery(
      int deliveryId,
      DroneUpdatesDeliveryDto updateDeliveryByDrone
  ) {
    this.updateDelivery(deliveryId, updateDeliveryByDrone, DeliveryStatus.IN_PROGRESS);
    return new MessageResult("Delivery started");
  }

  /**
   * Method finishDelivery.
   * 
   */
  public MessageResult finishDelivery(
      int deliveryId,
      DroneUpdatesDeliveryDto updateDeliveryByDrone
  ) {
    this.updateDelivery(deliveryId, updateDeliveryByDrone, DeliveryStatus.DELIVERED);
    return new MessageResult("Delivery finished");
  }

  /**
   * Method getNextDelivery.
   * 
   */
  @Transactional
  public DeliveryToTheDrone getNextDelivery(int droneId) {
    Drone drone = droneDao.getDroneById(droneId)
        .orElseThrow(() -> new NotFoundException("Drone not found"));

    List<WaitingList> allWaitingLists = waitingListDao.getAllWaitingList();

    if (allWaitingLists.isEmpty()) {
      drone.setStatus(DroneStatus.AVAILABLE.toString());
      droneDao.updateDrone(drone);
      throw new NotFoundException("No deliveries available");
    }

    WaitingList waitingList = allWaitingLists.get(0);

    Delivery delivery = deliveryDao.getDeliveryById(waitingList.getDeliveryId())
        .orElseThrow(() -> new NotFoundException("Delivery not found"));

    drone.setStatus(DroneStatus.OPERATING.toString());
    delivery.setDroneId(drone);

    DeliveryToTheDrone deliveryToTheDrone = new DeliveryToTheDrone();
    deliveryToTheDrone.setDeliveryId(waitingList.getDeliveryId());
    deliveryToTheDrone.setWithdrawalAddress(waitingList.getWithdrawalAddress());
    deliveryToTheDrone.setDeliveryAddress(waitingList.getDeliveryAddress());

    waitingListDao.deleteWaitingList(waitingList);

    return deliveryToTheDrone;
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
