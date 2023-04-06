package com.futuereh.dronefeeder.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.futuereh.dronefeeder.application.services.ClientService;
import com.futuereh.dronefeeder.application.services.DeliveryService;

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
  @PostMapping("/delivery")

  /**
   * Rota para listar os pedidos de entrega.
   * 
   */
  @GetMapping("/delivery")

  /**
   * Rota para visualizar um pedido de entrega.
   * 
   */
  @GetMapping("/delivery/{id}")

  /**
   * Rota para visualizar o video de uma entrega.
   * 
   */
  @GetMapping("/delivery/video/{id}")

  /**
   * Rota para alterar um pedido de entrega.
   * 
   */
  @PostMapping("/delivery/{id}")

  /**
   * Rota para cancelar um pedido de entrega.
   * 
   */
  @DeleteMapping("/delivery/{id}")

}
