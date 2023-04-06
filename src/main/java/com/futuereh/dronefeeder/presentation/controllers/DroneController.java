package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class DroneController.
 * 
 */
@RestController
@RequestMapping("/drone")
public class DroneController {

  @Autowired
  private DroneService droneService;

  /**
   * Rota que simula o drone recebendo o pedido de entrega.
   * 
   */
  @GetMapping("/delivery/start")

  /**
   * Rota para o drone informar o inicio da entrega.
   * 
   */
  @PostMapping("/delivery/start/{id}")

  /**
   * Rota para o drone informar o fim da entrega.
   * 
   */
  @PostMapping("/delivery/finish/{id}")
  
}