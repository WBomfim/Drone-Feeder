package com.futuereh.dronefeeder.presentation.controllers;

import com.futuereh.dronefeeder.application.dtos.SavedDeliveryDto;
import com.futuereh.dronefeeder.application.results.MessageResult;
import com.futuereh.dronefeeder.application.services.DeliveryService;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
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
   * Rota para fazer o pedido de entrega.
   * 
   */
  @PostMapping
  public MessageResult saveDelivery(@RequestBody SavedDeliveryDto savedDeliveryDto) {
    return deliveryService.saveDelivery(savedDeliveryDto);
  }

  /**
   * Rota para listar os pedidos de entrega.
   * 
   */
  @GetMapping("/client/{client_id}")
  public List<Delivery> getDeliveriesByClient(@PathVariable("client_id") Integer clientId) {
    return deliveryService.getDeliveriesByClient(clientId);
  }

  /**
   * Rota para visualizar um pedido de entrega.
   * 
   */
  @GetMapping("/{id}")
  public Delivery getDeliveryById(@PathVariable("id") Integer deliveryId) {
    return deliveryService.getDeliveryById(deliveryId);
  }

  /**
   * Rota para visualizar o video de uma entrega.
   * 
   */
  @GetMapping("/video/{id}")
  public InputStreamResource getDeliveryVideo(@PathVariable("id") Integer deliveryId)
      throws Exception {
    try {
      Blob videoBlob = deliveryService.getDeliveryVideo(deliveryId);
      InputStream videoStream = videoBlob.getBinaryStream();

      InputStreamResource videoResource = new InputStreamResource(videoStream);

      return videoResource;

    } catch (SQLException e) {
      throw new Exception();
    }
  }

  /**
   * Rota para alterar um pedido de entrega.
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
   * Rota para cancelar um pedido de entrega.
   * 
   */
  @DeleteMapping("/{id}")
  public MessageResult deleteDelivery(@PathVariable("id") Integer deliveryId) {
    return deliveryService.deleteDelivery(deliveryId);
  }

}
