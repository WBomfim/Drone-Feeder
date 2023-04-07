package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Client Repository.
 * 
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

  Client findByName(String name);
  
}
