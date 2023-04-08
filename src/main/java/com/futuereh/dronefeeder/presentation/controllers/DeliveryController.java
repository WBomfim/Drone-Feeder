package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.dtos.SavedDeliveryDto;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.services.DeliveryService;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class DeliveryController.
 * 
 */
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
  
  @Autowired
  private DeliveryService deliveryService;

  /**
   * Rota para fazer o pedido de entrega.
   * 
   */
  @PostMapping
  public MessageResult saveDelivery(@RequestBody SavedDeliveryDto savedDeliveryDto) {
    return deliveryService.saveDelivery(savedDeliveryDto);
  }

  /**
   * Rota para listar os pedidos de entrega.
   * 
   */
  @GetMapping("/client/{client_id}")
  public List<Delivery> getDeliveries(@PathVariable("client_id") Integer clientId) {
    return deliveryService.getDeliveriesByClient(clientId);
  }

  /**
   * Rota para visualizar um pedido de entrega.
   * 
   */
  @GetMapping("/{id}/drone")
  public Delivery getDeliveryWithDrone(@PathVariable("id") Integer deliveryId) {
    return deliveryService.getDeliveryById(deliveryId, true);
  }

  @GetMapping("/{id}")
  public Delivery getDeliveryWithoutDrone(@PathVariable("id") Integer deliveryId) {
    return deliveryService.getDeliveryById(deliveryId, false);
  }

  /**
   * Rota para visualizar o video de uma entrega.
   * 
   */
  /* @GetMapping("/video/{id}") */

  /**
   * Rota para alterar um pedido de entrega.
   * 
   */
  @PutMapping("/{id}/drone")
  public MessageResult updateDeliveryWithDrone(
      @PathVariable("id") Integer deliveryId,
      @RequestBody SavedDeliveryDto savedDeliveryDto
  ) {
    return deliveryService.updateDelivery(deliveryId, savedDeliveryDto, true);
  }

  @PutMapping("/{id}")
  public MessageResult updateDeliveryWithoutDrone(
      @PathVariable("id") Integer deliveryId,
      @RequestBody SavedDeliveryDto savedDeliveryDto
  ) {
    return deliveryService.updateDelivery(deliveryId, savedDeliveryDto, false);
  }

  /**
   * Rota para cancelar um pedido de entrega.
   * 
   */
  /* @DeleteMapping("/{id}") */

}
