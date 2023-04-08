package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.VideoPersistence;
import com.futuereh.dronefeeder.persistence.models.Video;
import com.futuereh.dronefeeder.persistence.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class VideoDao.
 * 
 */
@Component
public class VideoDao implements VideoPersistence {
  
  @Autowired
  private VideoRepository videoRepository;

  public Video getVideoById(int videoId) {
    return videoRepository.getVideoById(videoId);
  }

}
