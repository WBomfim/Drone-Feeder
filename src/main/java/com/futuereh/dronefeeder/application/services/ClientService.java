package com.futuereh.dronefeeder.application.services;

import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.persistence.daos.ClientDao;
import com.futuereh.dronefeeder.persistence.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class ClientService.
 * 
 */
@Service
public class ClientService {

  @Autowired
  private ClientDao clientDao;

  /**
   * Method saveClient.
   * 
   */
  public MessageResult saveClient(Client client) {

    if (client.getName() == null) {
      throw new IllegalArgumentException("Name is required");
    }

    if (client.getPassword() == null) {
      throw new IllegalArgumentException("Password is required");
    }

    Client clientFound = clientDao.getClientByName(client.getName()).orElse(null);

    if (clientFound != null) {
      throw new IllegalArgumentException("Client already exists");
    }

    clientDao.saveClient(client);
    return new MessageResult("Client saved successfully");
  }
  
}
