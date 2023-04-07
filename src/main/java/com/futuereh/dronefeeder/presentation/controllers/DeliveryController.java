package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.dtos.SavedDeliveryDto;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  /* @GetMapping */

  /**
   * Rota para visualizar um pedido de entrega.
   * 
   */
  /* @GetMapping("/{id}") */

  /**
   * Rota para visualizar o video de uma entrega.
   * 
   */
  /* @GetMapping("/video/{id}") */

  /**
   * Rota para alterar um pedido de entrega.
   * 
   */
  /* @PostMapping("/{id}") */

  /**
   * Rota para cancelar um pedido de entrega.
   * 
   */
  /* @DeleteMapping("/{id}") */

}
