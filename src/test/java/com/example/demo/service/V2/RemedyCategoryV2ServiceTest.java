package com.example.demo.service.V2;

import com.example.demo.dto.RemedyCategory.RequestRemedyCategoryDTO;
import com.example.demo.dto.RemedyCategory.ResponseRemedyCategoryDTO;
import com.example.demo.entity.RemedyCategory;
import com.example.demo.repository.IRemedyCategoryRepository;
import com.example.demo.stabs.RemedyCategoryStab;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
public class RemedyCategoryV2ServiceTest {
    private RemedyCategoryV2Service service;
    @Mock
    private IRemedyCategoryRepository repository;

    @BeforeEach
    void setup() {
        service = new RemedyCategoryV2Service(repository, new ModelMapper());
    }

    @Test
    void findById() {
        RemedyCategory RemedyCategory = RemedyCategoryStab.getRemedyCategory();

        Mockito.when(repository.findAll()).thenReturn(List.of(RemedyCategory));

        assertTrue(service.findAll().size() > 0);
    }

    @Test
    void update() {
        var captor = ArgumentCaptor.forClass(RemedyCategory.class);
        RequestRemedyCategoryDTO userDTO = RemedyCategoryStab.getRequestDto();
        Mockito.when(repository.save(Mockito.any())).thenReturn(RemedyCategoryStab.getRemedyCategory());
        Mockito.when(repository.existsById(RemedyCategoryStab.ID)).thenReturn(true);
        try {
            ResponseRemedyCategoryDTO saved = service.create(RemedyCategoryStab.getRequestDto());
            ResponseRemedyCategoryDTO result = service.update(RemedyCategoryStab.ID, RemedyCategoryStab.getRequestDto());
            Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

            assertAll(
                    () -> assertEquals(userDTO.getName(), result.getName()),
                    () -> assertEquals(userDTO.getDescription(), result.getDescription())
            );
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void create() throws NotFoundException {
        var captor = ArgumentCaptor.forClass(RemedyCategory.class);
        RequestRemedyCategoryDTO userDTO = RemedyCategoryStab.getRequestDto();

        Mockito.when(repository.save(Mockito.any())).thenReturn(RemedyCategoryStab.getRemedyCategory());

        ResponseRemedyCategoryDTO result = service.create(RemedyCategoryStab.getRequestDto());

        Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

        assertAll(
                () -> assertEquals(userDTO.getName(), result.getName()),
                () -> assertEquals(userDTO.getDescription(), result.getDescription())
        );
    }

    @Test
    void deleteById() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(RemedyCategoryStab.getRemedyCategory());
        Mockito.when(repository.existsById(RemedyCategoryStab.ID)).thenReturn(true);
        try {
            service.deleteById(RemedyCategoryStab.ID);

            var captor = ArgumentCaptor.forClass(Long.class);
            service.create(RemedyCategoryStab.getRequestDto());
            Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(captor.capture());
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }
}
