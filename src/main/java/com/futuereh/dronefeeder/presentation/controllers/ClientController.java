package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.services.ClientService;
import com.futuereh.dronefeeder.persistence.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  @PostMapping
  public ResponseEntity<MessageResult> saveClient(@RequestBody Client client) {
    MessageResult messageResult = clientService.saveClient(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(messageResult);
  }
  
}
