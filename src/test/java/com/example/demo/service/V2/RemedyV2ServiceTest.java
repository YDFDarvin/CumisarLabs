package com.example.demo.service.V2;

import com.example.demo.dto.Remedy.RequestRemedyDTO;
import com.example.demo.dto.Remedy.ResponseRemedyDTO;
import com.example.demo.entity.Remedy;
import com.example.demo.repository.IRemedyCategoryRepository;
import com.example.demo.repository.IRemedyRepository;
import com.example.demo.stabs.RemedyStab;
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
public class RemedyV2ServiceTest {
    private RemedyV2Service service;
    @Mock
    private IRemedyRepository repository;

    @BeforeEach
    void setup() {
        service = new RemedyV2Service(repository, new ModelMapper());
    }

    @Test
    void findById() {
        Remedy Remedy = RemedyStab.getRemedy();

        Mockito.when(repository.findAll()).thenReturn(List.of(Remedy));

        assertTrue(service.findAll().size() > 0);
    }

    @Test
    void update() {
        var captor = ArgumentCaptor.forClass(Remedy.class);
        RequestRemedyDTO userDTO = RemedyStab.getRequestDto();
        Mockito.when(repository.save(Mockito.any())).thenReturn(RemedyStab.getRemedy());
        Mockito.when(repository.existsById(RemedyStab.ID)).thenReturn(true);
        try {
            ResponseRemedyDTO saved = service.create(RemedyStab.getRequestDto());
            ResponseRemedyDTO result = service.update(RemedyStab.ID, RemedyStab.getRequestDto());
            Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

            assertAll(
                    () -> assertEquals(userDTO.getName(), result.getName()),
                    () -> assertEquals(userDTO.getPrice(), result.getPrice())
            );
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void create() throws NotFoundException {
        var captor = ArgumentCaptor.forClass(Remedy.class);
        RequestRemedyDTO userDTO = RemedyStab.getRequestDto();

        Mockito.when(repository.save(Mockito.any())).thenReturn(RemedyStab.getRemedy());

        ResponseRemedyDTO result = service.create(RemedyStab.getRequestDto());

        Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

        assertAll(
                () -> assertEquals(userDTO.getName(), result.getName()),
                () -> assertEquals(userDTO.getPrice(), result.getPrice())
        );
    }

    @Test
    void deleteById() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(RemedyStab.getRemedy());
        Mockito.when(repository.existsById(RemedyStab.ID)).thenReturn(true);
        try {
            service.deleteById(RemedyStab.ID);

            var captor = ArgumentCaptor.forClass(Long.class);
            service.create(RemedyStab.getRequestDto());
            Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(captor.capture());
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }
}
