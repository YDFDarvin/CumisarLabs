package com.example.demo.controller.api.V2;

import com.example.demo.dto.Pharmacist.ResponsePharmacistDTO;
import com.example.demo.service.V2.PharmacistV2Service;
import com.example.demo.stabs.PharmacistStab;
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
public class PharmacistV2APIControllerTest {
    @MockBean
    private PharmacistV2Service service;

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
        ArrayList<ResponsePharmacistDTO> list = new ArrayList<>(Arrays.asList(PharmacistStab.getResponseDto()));
        when(service.findAll()).thenReturn(list);

        mvc.perform(get("/api/v2/pharmacist/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(PharmacistStab.getResponseDto().getName())));
    }

    @Test
    void testGetById() throws Exception {
        when(service.findById(Mockito.any())).thenReturn(PharmacistStab.getResponseDto());

        mvc.perform(get("/api/v2/pharmacist/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(PharmacistStab.getResponseDto().getName())));
    }

    @Test
    void testDeleteById() throws Exception {
        mvc.perform(delete("/api/v2/pharmacist/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testCreate() throws Exception {
        when(service.create(Mockito.any())).thenReturn(PharmacistStab.getResponseDto());

        mvc.perform(post("/api/v2/pharmacist/").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(asJsonString(PharmacistStab.getRequestDto())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(PharmacistStab.getResponseDto().getName())));
    }

    @Test
    void testUpdate() throws Exception {
        when(service.update(Mockito.any(), Mockito.any())).thenReturn(PharmacistStab.getResponseDto());

        mvc.perform(put("/api/v2/pharmacist/1/").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(asJsonString(PharmacistStab.getRequestDto())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(PharmacistStab.getResponseDto().getName())));
    }
}
