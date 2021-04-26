package com.example.demo.controller.api.V2;

import com.example.demo.dto.Remedy.ResponseRemedyDTO;
import com.example.demo.service.V2.RemedyV2Service;
import com.example.demo.stabs.RemedyStab;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
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
public class RemedyV2APIControllerTest {
    @MockBean
    private RemedyV2Service service;

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
    @WithMockUser(username = "user", password = "user", roles = "USER")
    void testGetAll() throws Exception {
        ArrayList<ResponseRemedyDTO> list = new ArrayList<>(Arrays.asList(RemedyStab.getResponseDto()));
        when(service.findAll()).thenReturn(list);

        mvc.perform(get("/api/v2/remedy/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(content().string(containsString(RemedyStab.getResponseDto().getName())));
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "USER")
    void testGetById() throws Exception {
        when(service.findById(Mockito.any())).thenReturn(RemedyStab.getResponseDto());

        mvc.perform(get("/api/v2/remedy/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(RemedyStab.getResponseDto().getName())));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void testDeleteById() throws Exception {
        mvc.perform(delete("/api/v2/remedy/1/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void testCreate() throws Exception {
        when(service.create(Mockito.any())).thenReturn(RemedyStab.getResponseDto());

        mvc.perform(post("/api/v2/remedy/").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(asJsonString(RemedyStab.getRequestDto())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(RemedyStab.getResponseDto().getName())));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void testUpdate() throws Exception {
        when(service.update(Mockito.any(), Mockito.any())).thenReturn(RemedyStab.getResponseDto());

        mvc.perform(put("/api/v2/remedy/1/").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(asJsonString(RemedyStab.getRequestDto())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(content().string(containsString(RemedyStab.getResponseDto().getName())));
    }

}
