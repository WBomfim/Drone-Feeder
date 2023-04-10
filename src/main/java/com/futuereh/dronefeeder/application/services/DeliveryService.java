package com.futuereh.dronefeeder.application.services;

import com.futuereh.dronefeeder.application.dtos.SavedDeliveryDto;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.utils.DeliveryStatus;
import com.futuereh.dronefeeder.application.utils.DroneStatus;
import com.futuereh.dronefeeder.persistence.daos.ClientDao;
import com.futuereh.dronefeeder.persistence.daos.DeliveryDao;
import com.futuereh.dronefeeder.persistence.daos.DroneDao;
import com.futuereh.dronefeeder.persistence.daos.VideoDao;
import com.futuereh.dronefeeder.persistence.daos.WaitingListDao;
import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import com.futuereh.dronefeeder.persistence.models.Drone;
import com.futuereh.dronefeeder.persistence.models.Video;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import com.futuereh.dronefeeder.presentation.exceptions.DeliveryUpdateNotAuthorized;
import com.futuereh.dronefeeder.presentation.exceptions.NotFoundException;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class DeliveryService.
 * 
 */
@Service
public class DeliveryService {

  @Autowired
  private ClientDao clientDao;

  @Autowired
  private DeliveryDao deliveryDao;

  @Autowired
  private WaitingListDao waitingListDao;

  @Autowired
  private DroneDao droneDao;

  @Autowired
  private VideoDao videoDao;

  private void validateSavedDeliveryDto(SavedDeliveryDto savedDeliveryDto) {
    if (savedDeliveryDto.getClientId() == null) {
      throw new IllegalArgumentException("Client_id is required");
    }

    if (savedDeliveryDto.getWithdrawalAddress() == null
        || savedDeliveryDto.getWithdrawalAddress().isEmpty()
        || savedDeliveryDto.getDeliveryAddress() == null
        || savedDeliveryDto.getDeliveryAddress().isEmpty()
    ) {
      throw new IllegalArgumentException("Invalid delivery data");
    }
  }

  private Drone selectNextDrone() {
    List<Drone> drones = droneDao.getDronesByStatus(DroneStatus.WAITING.toString());
    if (drones.size() > 0) {
      return drones.get(0);
    }
    return null;
  }

  private Delivery createDelivery(SavedDeliveryDto savedDeliveryDto, Drone drone) {
    Client client = clientDao.getClientById(savedDeliveryDto.getClientId())
        .orElseThrow(() -> new NotFoundException("Client not found"));

    Delivery delivery = new Delivery();
    delivery.setClientId(client);
    delivery.setDroneId(drone);
    delivery.setRequestDate(LocalDateTime.now());
    delivery.setWithdrawalAddress(savedDeliveryDto.getWithdrawalAddress());
    delivery.setDeliveryAddress(savedDeliveryDto.getDeliveryAddress());
    delivery.setStatus(DeliveryStatus.PENDING.toString());

    return deliveryDao.saveDelivery(delivery);
  }

  private void addDeliveryToWaitingList(Delivery newDelivery) {
    WaitingList waitingList = new WaitingList();
    waitingList.setDeliveryId(newDelivery.getId());
    waitingList.setWithdrawalAddress(newDelivery.getWithdrawalAddress());
    waitingList.setDeliveryAddress(newDelivery.getDeliveryAddress());
    waitingListDao.saveDelivery(waitingList);
  }

  /**
   * Method to save a delivery.
   * 
   */
  @Transactional
  public MessageResult saveDelivery(SavedDeliveryDto savedDeliveryDto) {

    this.validateSavedDeliveryDto(savedDeliveryDto);
    
    Drone drone = this.selectNextDrone();

    if (drone != null) {
      drone.setStatus(DroneStatus.OPERATING.toString());
      this.createDelivery(savedDeliveryDto, drone);
      return new MessageResult("Order received successfully");
    }

    Delivery newDelivery = this.createDelivery(savedDeliveryDto, null);

    this.addDeliveryToWaitingList(newDelivery);

    return new MessageResult("Order received successfully");
  }

  /**
   * Method to get all deliveries by client.
   * 
   */
  public List<Delivery> getDeliveriesByClient(int clientId) {
    Client client = clientDao.getClientById(clientId)
        .orElseThrow(() -> new NotFoundException("Client not found"));

    List<Delivery> deliveries = deliveryDao.getDeliveriesByClient(client);

    List<WaitingList> waitingLists = waitingListDao.getWaitingListByClient(client);
    for (WaitingList waitingList : waitingLists) {
      Delivery delivery = new Delivery();
      delivery.setId(waitingList.getId());
      delivery.setClientId(waitingList.getClientId());
      delivery.setRequestDate(waitingList.getRequestDate());
      delivery.setWithdrawalAddress(waitingList.getWithdrawalAddress());
      delivery.setDeliveryAddress(waitingList.getDeliveryAddress());
      delivery.setStatus(waitingList.getStatus());
      deliveries.add(delivery);
    }

    return deliveries;
  }

  /**
   * Method to get delivery by id.
   * 
   */
  public Delivery getDeliveryById(int deliveryId, Boolean presentDrone) {
    if (presentDrone) {
      return deliveryDao.getDeliveryById(deliveryId)
          .orElseThrow(() -> new NotFoundException("Delivery not found"));
    }

    WaitingList waitingList = waitingListDao.getWaitingListById(deliveryId)
        .orElseThrow(() -> new NotFoundException("Delivery not found"));

    Delivery delivery = new Delivery();
    delivery.setId(waitingList.getId());
    delivery.setClientId(waitingList.getClientId());
    delivery.setRequestDate(waitingList.getRequestDate());
    delivery.setWithdrawalAddress(waitingList.getWithdrawalAddress());
    delivery.setDeliveryAddress(waitingList.getDeliveryAddress());
    delivery.setStatus(waitingList.getStatus());

    return delivery;
  }

  /**
   * Method to get video by id.
   * 
   */
  public Blob getDeliveryVideo(int deliveryId) {
    Video video = videoDao.getVideoById(deliveryId);

    if (video == null) {
      throw new NotFoundException("Video not found");
    }

    return video.getVideo();
  }

  /**
   * Method to update delivery.
   * 
   */
  @Transactional
  public MessageResult updateDelivery(
      int deliveryId, SavedDeliveryDto savedDeliveryDto, Boolean presentDrone
  ) {
    if (presentDrone) {
      Delivery delivery = deliveryDao.getDeliveryById(deliveryId)
          .orElseThrow(() -> new NotFoundException("Delivery not found"));

      if (!delivery.getStatus().equals(DeliveryStatus.PENDING.toString())) {
        throw new DeliveryUpdateNotAuthorized("Unauthorized update, order in progress of delivery");
      }

      delivery.setWithdrawalAddress(savedDeliveryDto.getWithdrawalAddress());
      delivery.setDeliveryAddress(savedDeliveryDto.getDeliveryAddress());

      deliveryDao.saveDelivery(delivery);
      return new MessageResult("Delivery updated successfully");
    }

    WaitingList waitingList = waitingListDao.getWaitingListById(deliveryId)
        .orElseThrow(() -> new NotFoundException("Delivery not found"));

    if (!waitingList.getStatus().equals(DeliveryStatus.PENDING.toString())) {
      throw new DeliveryUpdateNotAuthorized("Unauthorized update, order in progress of delivery");
    }

    waitingList.setWithdrawalAddress(savedDeliveryDto.getWithdrawalAddress());
    waitingList.setDeliveryAddress(savedDeliveryDto.getDeliveryAddress());

    waitingListDao.saveDelivery(waitingList);
    return new MessageResult("Delivery updated successfully");
  }

  /**
   * Method to delete delivery.
   * 
   */
  @Transactional
  public MessageResult deleteDelivery(int deliveryId, Boolean presentDrone) {
    if (presentDrone) {
      Delivery delivery = deliveryDao.getDeliveryById(deliveryId)
          .orElseThrow(() -> new NotFoundException("Delivery not found"));

      if (!delivery.getStatus().equals(DeliveryStatus.PENDING.toString())) {
        throw new DeliveryUpdateNotAuthorized("Unauthorized cancel, order in progress of delivery");
      }

      deliveryDao.deleteDelivery(delivery);
      return new MessageResult("Delivery deleted successfully");
    }

    WaitingList waitingList = waitingListDao.getWaitingListById(deliveryId)
        .orElseThrow(() -> new NotFoundException("Delivery not found"));

    if (!waitingList.getStatus().equals(DeliveryStatus.PENDING.toString())) {
      throw new DeliveryUpdateNotAuthorized("Unauthorized cancel, order in progress of delivery");
    }

    waitingListDao.deleteDelivery(waitingList);
    return new MessageResult("Delivery deleted successfully");
  }

}
