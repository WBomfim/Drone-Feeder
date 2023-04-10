package com.futuereh.dronefeeder.persistence.repositories;

import com.futuereh.dronefeeder.persistence.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Video Repository.
 * 
 */
@Component
public interface VideoRepository extends JpaRepository<Video, Integer> {

  Video findById(int videoId);

}
