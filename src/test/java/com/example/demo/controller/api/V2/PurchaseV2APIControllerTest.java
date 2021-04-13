package com.example.demo.controller.api.V2;

import com.example.demo.dto.Purchase.ResponsePurchaseDTO;
import com.example.demo.service.V2.PurchaseV2Service;
import com.example.demo.stabs.PurchaseStab;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PurchaseV2APIControllerTest {    
    @MockBean
    private PurchaseV2Service service;

    @Autowired
    private MockMvc mvc;

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGetAll() throws Exception {
        ArrayList<ResponsePurchaseDTO> list = new ArrayList<>(Arrays.asList(PurchaseStab.getResponseDto()));
        when(service.findAll()).thenReturn(list);

        mvc.perform(get("/api/v2/purchase/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(PurchaseStab.getResponseDto().getCustomer().getName())));
    }

    @Test
    void testGetById() throws Exception {
        when(service.findById(Mockito.any())).thenReturn(PurchaseStab.getResponseDto());

        mvc.perform(get("/api/v2/purchase/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(PurchaseStab.getResponseDto().getCustomer().getName())));
    }

    @Test
    void testDeleteById() throws Exception {
        mvc.perform(delete("/api/v2/purchase/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testCreate() throws Exception {
        when(service.create(Mockito.any())).thenReturn(PurchaseStab.getResponseDto());

        mvc.perform(post("/api/v2/purchase/").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(asJsonString(PurchaseStab.getRequestDto())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(PurchaseStab.getResponseDto().getCustomer().getName())));
    }

    @Test
    void testUpdate() throws Exception {
        when(service.update(Mockito.any(), Mockito.any())).thenReturn(PurchaseStab.getResponseDto());

        mvc.perform(put("/api/v2/purchase/1/").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(asJsonString(PurchaseStab.getRequestDto())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(PurchaseStab.getResponseDto().getCustomer().getName())));
    }
}