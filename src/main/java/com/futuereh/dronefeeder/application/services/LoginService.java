package com.futuereh.dronefeeder.application.services;

import com.futuereh.dronefeeder.persistence.daos.ClientDao;
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
  
}
