package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Client;

/**
 * Interface ClientPersistence.
 * 
 */
public interface ClientPersistence {

  public void saveClient(Client client);

  public Client getClientByName(String name);
  
}
