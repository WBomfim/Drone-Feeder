package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.ClientPersistence;
import com.futuereh.dronefeeder.persistence.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class ClientDao.
 * 
 */
@Component
public class ClientDao implements ClientPersistence {

  @Autowired
  private ClientRepository clientRepository;
  
}