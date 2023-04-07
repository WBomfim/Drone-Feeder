package com.futuereh.dronefeeder.persistence.models;

import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Video Model.
 * 
 */
@Entity
@Table(name = "videos")
public class Video {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private Blob video;

  public int getId() {
    return id;
  }

  public Blob getVideo() {
    return video;
  }

  public void setVideo(Blob video) {
    this.video = video;
  }
  
}
