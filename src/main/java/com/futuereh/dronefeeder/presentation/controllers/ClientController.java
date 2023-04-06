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
   * Rota para o cliente fazer o pedido de entrega.
   * 
   */
  @PostMapping("/pedido")

  /**
   * Rota para o cliente listar os pedidos de entrega.
   * 
   */
  @GetMapping("/pedido/list")

  /**
   * Rota para o cliente visualizar um pedido de entrega.
   * 
   */
  @GetMapping("/pedido/{id}")

  /**
   * Rota para o cliente visualizar o video de uma entrega.
   * 
   */
  @GetMapping("/pedido/video/{id}")

  /**
   * Rota para o cliente alterar um pedido de entrega.
   * 
   */
  @PostMapping("/pedido/{id}")

  /**
   * Rota para o cliente cancelar um pedido de entrega.
   * 
   */
  @DeleteMapping("/pedido/{id}")
  
}
