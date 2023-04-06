package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class LoginController.
 * 
 */
@RestController
@RequestMapping("/login")
public class LoginController {

  @Autowired
  private LoginService loginService;

  /**
   * Rota para fazer o login de um cliente.
   * 
   */
  @PostMapping("/")
  
}
