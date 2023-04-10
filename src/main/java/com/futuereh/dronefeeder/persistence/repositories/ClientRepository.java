package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Client Repository.
 * 
 */
@Component
public interface ClientRepository extends JpaRepository<Client, Integer> {

  Optional<Client> findById(int id);

  Optional<Client> findByName(String name);
  
}
