package com.rapidminer.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MedianControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testMedian() throws Exception {

        Map<String, Object> fieldToValue = new HashMap<>();
        List<Map<String, Object>> requestBody = new ArrayList<>();

        fieldToValue.put("a1", 5.1);
        fieldToValue.put("a2", 3.5);
        fieldToValue.put("a3", 1.4);
        fieldToValue.put("a4", 0.2);
        fieldToValue.put("id", "id_1");
        fieldToValue.put("label", "Iris-setosa");
        requestBody.add(fieldToValue);

        fieldToValue = new HashMap<>();
        fieldToValue.put("a1", 4.9);
        fieldToValue.put("a2", 3.0);
        fieldToValue.put("a3", 1.4);
        fieldToValue.put("a4", 0.2);
        fieldToValue.put("id", "id_2");
        fieldToValue.put("label", "Iris-setosa");
        requestBody.add(fieldToValue);

        fieldToValue = new HashMap<>();
        fieldToValue.put("a1", 6.3);
        fieldToValue.put("a2", 3.3);
        fieldToValue.put("a3", 6.0);
        fieldToValue.put("a4", 2.5);
        fieldToValue.put("id", "id_101");
        fieldToValue.put("label", "Iris-virginica");
        requestBody.add(fieldToValue);

        fieldToValue = new HashMap<>();
        fieldToValue.put("a1", 5.8);
        fieldToValue.put("a2", 2.7);
        fieldToValue.put("a3", 5.1);
        fieldToValue.put("a4", 1.9);
        fieldToValue.put("id", "id_102");
        fieldToValue.put("label", "Iris-virginica");
        requestBody.add(fieldToValue);

        fieldToValue = new HashMap<>();
        fieldToValue.put("a1", 7.1);
        fieldToValue.put("a2", 3.0);
        fieldToValue.put("a3", 5.9);
        fieldToValue.put("a4", 2.1);
        fieldToValue.put("id", "id_103");
        fieldToValue.put("label", "Iris-virginica");
        requestBody.add(fieldToValue);

        String requestBodyJson = objectMapper.writeValueAsString(requestBody);

        mockMvc.perform(
                post("/median")
                        .content(requestBodyJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].a1").value(6.3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].a2").value(3.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].a3").value(5.9))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].a4").value(2.1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value("id_102"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].label").value("Iris-virginica"))

                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].a1").value(5.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].a2").value(3.25))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].a3").value(1.4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].a4").value(0.2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value("id_2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].label").value("Iris-setosa"));
    }
}
