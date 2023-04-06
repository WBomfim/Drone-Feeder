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
    clientDao.saveClient(client);
    return new MessageResult("Client saved successfully");
  }
  
}
