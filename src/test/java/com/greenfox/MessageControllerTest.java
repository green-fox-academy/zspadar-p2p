package com.greenfox;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.greenfox.repository.MessageRepository;
import com.greenfox.repository.UserRepository;
import java.nio.charset.Charset;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by zsuzsanna.padar on 2017. 05. 23..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = P2pchatApplication.class)
@WebAppConfiguration
@EnableWebMvc


public class MessageControllerTest {

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(),
      Charset.forName("utf8"));

  private MockMvc mockMvc;


  @Autowired
  WebApplicationContext webApplicationContext;


  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testReceivedJsonIsOk() throws Exception {
    mockMvc.perform(post("/api/message/receive")
    .contentType(MediaType.APPLICATION_JSON)
    .content("{\n"
        + "  \"message\": {\n"
        + "    \"id\": 7655482,\n"
        + "    \"username\": \"EggDice\",\n"
        + "    \"text\": \"How you doin'?\",\n"
        + "    \"timestamp\": 1322018752992\n"
        + "  },\n"
        + "  \"client\": {\n"
        + "    \"id\": \"EggDice\"\n"
        + "  }\n"
        + "}"))
    .andExpect(status().isOk())
    .andExpect(content().contentType(contentType))
    .andExpect(jsonPath("$.status").value("ok"));
  }

//  @Test
//  public void testReceivedJsonIsNotOk() throws Exception {
//    mockMvc.perform(post("/api/message/receive")
//        .contentType(MediaType.APPLICATION_JSON)
//        .content("{\n"
//            + "  \"message\": {\n"
//            + "    \"id\": 7655482,\n"
//            + "    \"text\": \"How you doin'?\",\n"
//            + "    \"timestamp\": 1322018752992\n"
//            + "  },\n"
//            + "  \"client\": {\n"
//            + "    \"id\": \"EggDice\"\n"
//            + "  }\n"
//            + "}"))
//        .andExpect(status().isOk())
//        .andExpect(content().contentType(contentType))
//        .andExpect(jsonPath("$.status").value("error"))
//        .andExpect(jsonPath("$.message").value("Missing field(s): message.username"));
//  }
//


}
