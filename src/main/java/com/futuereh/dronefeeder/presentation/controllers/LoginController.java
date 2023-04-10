package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.results.LoginResponse;
import com.futuereh.dronefeeder.application.services.LoginService;
import com.futuereh.dronefeeder.persistence.models.Client;
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
   * Route for logging in a customer.
   * 
   */
  @PostMapping
  public LoginResponse login(@RequestBody Client client) {
    return loginService.login(client);
  }
  
}
