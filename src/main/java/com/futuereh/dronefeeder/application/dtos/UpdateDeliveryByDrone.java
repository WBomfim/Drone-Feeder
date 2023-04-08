package com.futuereh.dronefeeder.application.dtos;

import java.sql.Blob;
import java.util.Optional;

/**
 * Class UpdateDeliveryByDrone.
 * 
 */
public class UpdateDeliveryByDrone {

  private String latitude;

  private String longitude;

  private Optional<Blob> video;

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public Optional<Blob> getVideo() {
    return video;
  }
  
}
