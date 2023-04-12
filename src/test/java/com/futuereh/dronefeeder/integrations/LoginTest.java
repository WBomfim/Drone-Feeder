package com.futuereh.dronefeeder.integrations;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futuereh.dronefeeder.persistence.models.Client;
import com.futuereh.dronefeeder.persistence.repositories.ClientRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
public class LoginTest {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private MockMvc mockMvc;

  /**
   * Method to create client.
   *
   */
  @BeforeEach
  public void createClient() {
    Client client = new Client();
    client.setName("client1");
    client.setPassword("password1");

    clientRepository.save(client);
  }

  /**
   * Method to delete client.
   *
   */
  @AfterEach
  public void deleteClient() {
    clientRepository.deleteAll();
  }

  @Test
  @Order(1)
  public void loginSuccess() throws Exception {
    Client client = new Client();
    client.setName("client1");
    client.setPassword("password1");

    mockMvc
      .perform(
        post("/login")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(client))
      )
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value("1"))
        .andExpect(jsonPath("$.name").value("client1"));
  }

  @Test
  @Order(2)
  public void loginNameInvalid() throws Exception {
    Client client = new Client();
    client.setName("client2");
    client.setPassword("password1");

    mockMvc
      .perform(
        post("/login")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(client))
      )
        .andExpect(
          content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized())
        .andExpect(jsonPath("$.error").value("Name invalid"));
  }

  @Test
  @Order(3)
  public void loginPasswordInvalid() throws Exception {
    Client client = new Client();
    client.setName("client1");
    client.setPassword("password2");

    mockMvc
      .perform(
        post("/login")
          .contentType(MediaType.APPLICATION_JSON)
          .content(new ObjectMapper().writeValueAsString(client))
      )
        .andExpect(
          content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized())
        .andExpect(jsonPath("$.error").value("Password invalid"));
  }
  
}
