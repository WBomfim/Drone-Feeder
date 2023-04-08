package com.futuereh.dronefeeder.application.contracts;

import com.futuereh.dronefeeder.persistence.models.Video;

/**
 * Interface VideoPersistence.
 * 
 */
public interface VideoPersistence {

  Video getVideoById(int videoId);
  
}
