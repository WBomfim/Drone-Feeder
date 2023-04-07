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
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import com.futuereh.dronefeeder.presentation.exceptions.NotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;
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

  /**
   * Method to save a delivery.
   * 
   */
  @Transactional
  public MessageResult saveDelivery(SavedDeliveryDto savedDeliveryDto) {

    if (savedDeliveryDto.getClientId() == null) {
      throw new IllegalArgumentException("Client_id is required");
    }

    if (savedDeliveryDto.getWithdrawalAddress() == null
        || savedDeliveryDto.getWithdrawalAddress().isEmpty()
        || savedDeliveryDto.getDeliveryAddress() == null
        || savedDeliveryDto.getDeliveryAddress().isEmpty()
    ) {
      throw new IllegalArgumentException("Adresses is required");
    }

    Optional<Client> clientOptional = clientDao.getClientById(savedDeliveryDto.getClientId());
    Client client = clientOptional.orElseThrow(() -> new NotFoundException("Client not found"));
    
    Drone drone = droneDao.selectNextDrone();

    if (drone == null) {
      WaitingList waitingList = new WaitingList();
      waitingList.setClientId(client);
      waitingList.setRequestDate(LocalDateTime.now());
      waitingList.setWithdrawalAddress(savedDeliveryDto.getWithdrawalAddress());
      waitingList.setDeliveryAddress(savedDeliveryDto.getDeliveryAddress());
      waitingList.setStatus(DeliveryStatus.PENDING.toString());
      
      waitingListDao.saveDelivery(waitingList);
      return new MessageResult("Order received successfully");
    }

    drone.setStatus(DroneStatus.OPERATING.toString());

    Delivery delivery = new Delivery();
    delivery.setClientId(client);
    delivery.setDroneId(drone);
    delivery.setRequestDate(LocalDateTime.now());
    delivery.setWithdrawalAddress(savedDeliveryDto.getWithdrawalAddress());
    delivery.setDeliveryAddress(savedDeliveryDto.getDeliveryAddress());
    delivery.setStatus(DeliveryStatus.PENDING.toString());

    deliveryDao.saveDelivery(delivery);
    return new MessageResult("Order received successfully");
  }
  
}
