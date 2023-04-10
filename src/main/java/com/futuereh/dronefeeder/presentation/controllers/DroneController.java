package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.dtos.DroneUpdatesDeliveryDto;
import com.futuereh.dronefeeder.application.results.DeliveryToTheDrone;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.services.DroneService;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import java.sql.Blob;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Class DroneController.
 * 
 */
@RestController
@RequestMapping("/drone/delivery")
public class DroneController {

  @Autowired
  private DroneService droneService;

  /**
   * Rota para o drone informar o inicio da entrega.
   * 
   */
  @PostMapping("/start/{id}")
  public MessageResult startDelivery(
      @PathVariable("id") int deliveryId,
      @RequestBody DroneUpdatesDeliveryDto updateDeliveryByDrone
  ) {
    return droneService.startDelivery(deliveryId, updateDeliveryByDrone);
  }

  /**
   * Rota para o drone informar o fim da entrega.
   * 
   */
  @PostMapping("/finish/{id}")
  public MessageResult finishDelivery(
      @PathVariable("id") int deliveryId,
      @RequestBody DroneUpdatesDeliveryDto updateDeliveryByDrone
  ) {
    return droneService.finishDelivery(deliveryId, updateDeliveryByDrone);
  }

  /**
   * Rota para o drone buscar a próxima entrega.
   * 
   */
  @GetMapping("/next/{id}")
  public DeliveryToTheDrone getNextDelivery(@PathVariable("id") int droneId) {
    return droneService.getNextDelivery(droneId);
  }

  /**
   * Rota para o drone enviar o video da entrega.
   * 
   */
  @PostMapping("/video/{id}")
  public MessageResult saveVideo(
      @PathVariable("id") int deliveryId,
      @RequestParam("file") MultipartFile file
  ) throws Exception {
    try {
      Blob video = new SerialBlob(file.getBytes());
      return droneService.saveVideo(deliveryId, video);
    } catch (Exception e) {
      throw new Exception();
    }
  }
  
}
