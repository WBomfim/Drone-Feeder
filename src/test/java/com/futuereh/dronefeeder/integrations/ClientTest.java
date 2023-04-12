package com.futuereh.dronefeeder.integrations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futuereh.dronefeeder.persistence.models.Client;
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
 * Class to test the client.
 * @
 */
@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @Order(1)
  public void createClient() throws Exception {
    Client client = new Client();
    client.setName("client10");
    client.setPassword("password10");

    mockMvc
      .perform(
        post("/client")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(client))
      )
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.message").value("Client saved successfully"));
  }

  @Test
  @Order(2)
  public void createClientExisting() throws Exception {
    Client client = new Client();
    client.setName("client10");
    client.setPassword("ClientTest123");

    mockMvc
      .perform(
        post("/client")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(client))
      )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Client already exists"));
  }

  @Test
  public void createClientWithNameEmpty() throws Exception {
    Client client = new Client();
    client.setPassword("password1");

    mockMvc
      .perform(
        post("/client")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(client))
      )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Name is required"));
  }

  @Test
  public void createClientWithPasswordEmpty() throws Exception {
    Client client = new Client();
    client.setName("client1");

    mockMvc
      .perform(
        post("/client")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(client))
      )
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error").value("Password is required"));
  }
  
}
