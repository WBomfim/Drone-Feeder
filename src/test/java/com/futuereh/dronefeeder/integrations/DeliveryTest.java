package com.futuereh.dronefeeder.integrations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futuereh.dronefeeder.application.dtos.SavedDeliveryDto;
import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.models.Delivery;
import com.futuereh.dronefeeder.persistence.models.Drone;
import com.futuereh.dronefeeder.persistence.models.WaitingList;
import com.futuereh.dronefeeder.persistence.repositories.ClientRepository;
import com.futuereh.dronefeeder.persistence.repositories.DeliveryRepository;
import com.futuereh.dronefeeder.persistence.repositories.DroneRepository;
import com.futuereh.dronefeeder.persistence.repositories.WaitingListRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Class to test the delivery.
 * 
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DeliveryTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private DroneRepository droneRepository;

  @Autowired
  private DeliveryRepository deliveryRepository;

  @Autowired
  private WaitingListRepository waitingListRepository;

  @Test
  @Order(1)
  public void createDeliveryWithDroneAvailable() throws Exception {
    Drone drone = new Drone();
    drone.setStatus("AVAILABLE");
    droneRepository.save(drone);

    Client client = new Client();
    client.setName("client1");
    client.setPassword("password1");
    clientRepository.save(client);


    SavedDeliveryDto delivery = new SavedDeliveryDto();
    delivery.setClientId(1);
    delivery.setWithdrawalAddress("Withdrawal Address");
    delivery.setDeliveryAddress("Delivery Address");

    mockMvc
      .perform(
        post("/delivery")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(delivery))
      )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Order received successfully"));

    List<Delivery> deliveries = deliveryRepository.findAll();
    assert deliveries.size() == 1;

    List<WaitingList> waitingLists = waitingListRepository.findAll();
    assert waitingLists.size() == 0;
  }

  @Test
  @Order(2)
  public void createDeliveryWithoutDroneAvailable() throws Exception {
    SavedDeliveryDto delivery = new SavedDeliveryDto();
    delivery.setClientId(1);
    delivery.setWithdrawalAddress("Withdrawal Address");
    delivery.setDeliveryAddress("Delivery Address");

    mockMvc
      .perform(
        post("/delivery")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(delivery))
      )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("Order received successfully"));

    List<Delivery> deliveries = deliveryRepository.findAll();
    assert deliveries.size() == 2;

    List<WaitingList> waitingLists = waitingListRepository.findAll();
    assert waitingLists.size() == 1;
  }
    
  @Test
  @Order(3)
  public void createDeliveryClientNotFound() throws Exception {
    SavedDeliveryDto delivery = new SavedDeliveryDto();
    delivery.setClientId(2);
    delivery.setWithdrawalAddress("Withdrawal Address");
    delivery.setDeliveryAddress("Delivery Address");

    mockMvc
      .perform(
        post("/delivery")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(delivery))
      )
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.error").value("Client not found"));
  }

  @Test
  @Order(4)
  public void createDeliveryWithClientIdEmpty() throws Exception {
    SavedDeliveryDto delivery = new SavedDeliveryDto();
    delivery.setWithdrawalAddress("Withdrawal Address");
    delivery.setDeliveryAddress("Delivery Address");

    mockMvc
      .perform(
        post("/delivery")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(delivery))
      )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Client_id is required"));
  }

  @Test
  @Order(5)
  public void createDeliveryWithWithdrawalAddressEmpty() throws Exception {
    SavedDeliveryDto delivery = new SavedDeliveryDto();
    delivery.setClientId(1);
    delivery.setDeliveryAddress("Delivery Address");

    mockMvc
      .perform(
        post("/delivery")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(delivery))
      )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Adresses is required"));

    delivery.setWithdrawalAddress("");
    delivery.setDeliveryAddress("Delivery Address");

    mockMvc
      .perform(
        post("/delivery")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(delivery))
      )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Adresses is required"));
  }

  @Test
  @Order(6)
  public void createDeliveryWithDeliveryAddressEmpty() throws Exception {
    SavedDeliveryDto delivery = new SavedDeliveryDto();
    delivery.setClientId(1);
    delivery.setWithdrawalAddress("Withdrawal Address");

    mockMvc
      .perform(
        post("/delivery")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(delivery))
      )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Adresses is required"));

    delivery.setWithdrawalAddress("Withdrawal Address");
    delivery.setDeliveryAddress("");

    mockMvc
      .perform(
        post("/delivery")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(delivery))
      )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Adresses is required"));
  }
  
}
