package com.futuereh.dronefeeder.application.services;

import com.futuereh.dronefeeder.application.results.LoginResponse;
import com.futuereh.dronefeeder.persistence.daos.ClientDao;
import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.presentation.exceptions.UnauthorizedLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class Login.
 * 
 */
@Service
public class LoginService {

  @Autowired
  private ClientDao clientDao;

  /**
   * Verifica se o cliente existe e valida a senha.
   * 
   */
  public LoginResponse login(Client client) {
    Client registeredCustomer = clientDao.getClientByName(client.getName()).orElse(null);

    if (registeredCustomer == null) {
      throw new UnauthorizedLogin("Name invalid");
    }

    if (!registeredCustomer.getPassword().equals(client.getPassword())) {
      throw new UnauthorizedLogin("Password invalid");
    }

    return new LoginResponse(
      registeredCustomer.getId(),
      registeredCustomer.getName()
    );
  }
  
}
