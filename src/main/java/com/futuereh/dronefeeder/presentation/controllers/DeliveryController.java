package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.dtos.SavedDeliveryDto;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.services.DeliveryService;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class DeliveryController.
 * 
 */
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
  
  @Autowired
  private DeliveryService deliveryService;

  /**
   * Route to order delivery.
   * 
   */
  @PostMapping
  public MessageResult saveDelivery(@RequestBody SavedDeliveryDto savedDeliveryDto) {
    return deliveryService.saveDelivery(savedDeliveryDto);
  }

  /**
   * Route to list delivery orders by customer.
   * 
   */
  @GetMapping("/client/{client_id}")
  public List<Delivery> getDeliveriesByClient(@PathVariable("client_id") Integer clientId) {
    return deliveryService.getDeliveriesByClient(clientId);
  }

  /**
   * Route to view a delivery order.
   * 
   */
  @GetMapping("/{id}")
  public Delivery getDeliveryById(@PathVariable("id") Integer deliveryId) {
    return deliveryService.getDeliveryById(deliveryId);
  }

  /**
   * Route to view the video of a delivery.
   * 
   */
  @GetMapping("/video/{id}")
  public void getDeliveryVideo(@PathVariable("id") Integer deliveryId, HttpServletResponse response)
      throws Exception {
    try {
      Blob videoBlob = deliveryService.getDeliveryVideo(deliveryId);
      
      byte[] videoBytes = videoBlob.getBytes(1, (int) videoBlob.length());

      response.setContentType("video/mp4");
      response.setContentLength(videoBytes.length);
      response.setHeader("Content-Disposition", "attachment; filename=\"video.mp4\"");

      ServletOutputStream outputStream = response.getOutputStream();
      outputStream.write(videoBytes);
      outputStream.flush();
      outputStream.close();

    } catch (SQLException e) {
      throw new Exception();
    }
  }

  /**
   * Route to update a delivery order.
   * 
   */
  @PutMapping("/{id}")
  public MessageResult updateDelivery(
      @PathVariable("id") Integer deliveryId,
      @RequestBody SavedDeliveryDto savedDeliveryDto
  ) {
    return deliveryService.updateDelivery(deliveryId, savedDeliveryDto);
  }

  /**
   * Route to cancel a delivery order.
   * 
   */
  @DeleteMapping("/{id}")
  public MessageResult deleteDelivery(@PathVariable("id") Integer deliveryId) {
    return deliveryService.deleteDelivery(deliveryId);
  }

}
