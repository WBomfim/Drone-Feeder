package com.futuereh.dronefeeder.application.services;

import com.futuereh.dronefeeder.persistence.daos.ClientDao;
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
  
}
