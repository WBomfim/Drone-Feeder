package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.persistence.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class VideoDao.
 * 
 */
@Component
public class VideoDao {
  
  @Autowired
  private VideoRepository videoRepository;

}
