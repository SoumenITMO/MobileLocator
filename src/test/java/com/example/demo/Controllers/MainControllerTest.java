package com.example.demo.Controllers;

import com.example.demo.Dto.NotFoundMS;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void whenNotSendAnyUUIDThenNotFound() throws Exception {

        this.mockMvc.perform(get("/location"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void whenSendUUIDThenFound() throws Exception {

        this.mockMvc.perform(get("/location/2")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenSendWrongUUIDAndNotFound() throws Exception {

        NotFoundMS notFound = new NotFoundMS();
        notFound.setError_code(404);
        notFound.setError_description("Not Found in Range");
        String responseBody = this.mockMvc.perform(get("/location/25")
                .contentType("application/json")).andReturn().getResponse().getContentAsString();

        assertThat(objectMapper.writeValueAsString(notFound)).isEqualTo(responseBody);
    }
}
