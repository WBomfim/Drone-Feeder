package com.futuereh.dronefeeder.persistence.daos;

import com.futuereh.dronefeeder.application.contracts.VideoPersistence;
import com.futuereh.dronefeeder.persistence.models.Video;
import com.futuereh.dronefeeder.persistence.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Class VideoDao.
 * 
 */
@Repository
public class VideoDao implements VideoPersistence {
  
  @Autowired
  private VideoRepository videoRepository;

  public Video saveVideo(Video video) {
    return videoRepository.save(video);
  }

  public Video getVideoById(int videoId) {
    return videoRepository.findById(videoId);
  }

}
