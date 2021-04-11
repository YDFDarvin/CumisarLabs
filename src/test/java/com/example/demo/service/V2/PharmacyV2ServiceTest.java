package com.example.demo.service.V2;

import com.example.demo.dto.Pharmacy.RequestPharmacyDTO;
import com.example.demo.dto.Pharmacy.ResponsePharmacyDTO;
import com.example.demo.entity.Pharmacy;
import com.example.demo.repository.IPharmacyRepository;
import com.example.demo.stabs.PharmacyStab;
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
public class PharmacyV2ServiceTest {
    private PharmacyV2Service service;
    @Mock
    private IPharmacyRepository repository;

    @BeforeEach
    void setup() {
        service = new PharmacyV2Service(repository, new ModelMapper());
    }

    @Test
    void findById() {
        Pharmacy Pharmacy = PharmacyStab.getPharmacy();

        Mockito.when(repository.findAll()).thenReturn(List.of(Pharmacy));

        assertTrue(service.findAll().size() > 0);
    }

    @Test
    void update() {
        var captor = ArgumentCaptor.forClass(Pharmacy.class);
        RequestPharmacyDTO userDTO = PharmacyStab.getRequestDto();
        Mockito.when(repository.save(Mockito.any())).thenReturn(PharmacyStab.getPharmacy());
        Mockito.when(repository.existsById(PharmacyStab.ID)).thenReturn(true);
        try {
            ResponsePharmacyDTO saved = service.create(PharmacyStab.getRequestDto());
            ResponsePharmacyDTO result = service.update(PharmacyStab.ID, PharmacyStab.getRequestDto());
            Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

            assertAll(
                    () -> assertEquals(userDTO.getName(), result.getName()),
                    () -> assertEquals(userDTO.getAddress(), result.getAddress())
            );
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void create() throws NotFoundException {
        var captor = ArgumentCaptor.forClass(Pharmacy.class);
        RequestPharmacyDTO userDTO = PharmacyStab.getRequestDto();

        Mockito.when(repository.save(Mockito.any())).thenReturn(PharmacyStab.getPharmacy());

        ResponsePharmacyDTO result = service.create(PharmacyStab.getRequestDto());

        Mockito.verify(repository, Mockito.atLeastOnce()).save(captor.capture());

        assertAll(
                () -> assertEquals(userDTO.getName(), result.getName()),
                () -> assertEquals(userDTO.getAddress(), result.getAddress())
        );
    }

    @Test
    void deleteById() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(PharmacyStab.getPharmacy());
        Mockito.when(repository.existsById(PharmacyStab.ID)).thenReturn(true);
        try {
            service.deleteById(PharmacyStab.ID);

            var captor = ArgumentCaptor.forClass(Long.class);
            service.create(PharmacyStab.getRequestDto());
            Mockito.verify(repository, Mockito.atLeastOnce()).deleteById(captor.capture());
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }
}
