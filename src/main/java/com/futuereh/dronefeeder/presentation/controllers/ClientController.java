package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class ClientController.
 * 
 */
@RestController
@RequestMapping("/client")
public class ClientController {

  @Autowired
  private ClientService clientService;

  /**
   * Rota para fazer o cadastro de um cliente.
   * 
   */
  @PostMapping("/")
  
}
