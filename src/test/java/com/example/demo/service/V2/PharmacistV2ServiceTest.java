package com.example.demo.service.V2;

import com.example.demo.dto.Pharmacist.RequestPharmacistDTO;
import com.example.demo.dto.Pharmacist.ResponsePharmacistDTO;
import com.example.demo.entity.Pharmacist;
import com.example.demo.repository.IPharmacistRepository;
import com.example.demo.stabs.PharmacistStab;
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
public class PharmacistV2ServiceTest {
    private PharmacistV2Service service;
    @Mock
    private IPharmacistRepository repository;

    @BeforeEach
    void setup() {
        service = new PharmacistV2Service(repository, new ModelMapper());
    }

    @Test
    void findById() {
        Pharmacist Pharmacist = PharmacistStab.getPharmacist();

        Mockito.when(repository.findAll()).thenReturn(List.of(Pharmacist));

        assertTrue(service.findAll().size() > 0);
    }

    @Test
    void update() {
        var captor = ArgumentCaptor.forClass(Pharmacist.class);
        RequestPharmacistDTO userDTO = PharmacistStab.getRequestDto();
        Mockito.when(repository.save(Mockito.any())).thenReturn(PharmacistStab.getPharmacist());
        Mockito.when(repository.existsById(PharmacistStab.ID)).thenReturn(true);
        try {
            ResponsePharmacistDTO saved = service.create(PharmacistStab.getRequestDto());
            ResponsePharmacistDTO result = service.update(PharmacistStab.ID, PharmacistStab.getRequestDto());
            Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

            assertAll(
                    () -> assertEquals(userDTO.getName(), result.getName())
            );
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void create() throws NotFoundException {
        var captor = ArgumentCaptor.forClass(Pharmacist.class);
        RequestPharmacistDTO userDTO = PharmacistStab.getRequestDto();

        Mockito.when(repository.save(Mockito.any())).thenReturn(PharmacistStab.getPharmacist());

        ResponsePharmacistDTO result = service.create(PharmacistStab.getRequestDto());

        Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

        assertAll(
                () -> assertEquals(userDTO.getName(), result.getName())
        );
    }

    @Test
    void deleteById() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(PharmacistStab.getPharmacist());
        Mockito.when(repository.existsById(PharmacistStab.ID)).thenReturn(true);
        try {
            service.deleteById(PharmacistStab.ID);

            var captor = ArgumentCaptor.forClass(Long.class);
            service.create(PharmacistStab.getRequestDto());
            Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(captor.capture());
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }
}
