package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.dtos.UpdateDeliveryByDrone;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.services.DroneService;
import com.futuereh.dronefeeder.persistence.models.Delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
   * Rota que simula o drone recebendo o pedido de entrega.
   * 
   */
  @GetMapping("/start/{id}")
  public Delivery getNextDeliveryByDrone(@PathVariable("id") int droneId) {
    return droneService.getNextDeliveryByDrone(droneId);
  }

  /**
   * Rota para o drone informar o inicio da entrega.
   * 
   */
  @PostMapping("/start/{id}")
  public MessageResult startDelivery(
      @PathVariable("id") int deliveryId,
      @RequestBody UpdateDeliveryByDrone updateDeliveryByDrone
  ) {
    return droneService.startDelivery(deliveryId, updateDeliveryByDrone);
  }

  /**
   * Rota para o drone informar o fim da entrega.
   * 
   */
  /* @PostMapping("/finish/{id}") */
  
}
