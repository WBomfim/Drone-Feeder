package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Video;

/**
 * Interface VideoPersistence.
 * 
 */
public interface VideoPersistence {

  Video saveVideo(Video video);

  Video getVideoById(int videoId);
  
}
