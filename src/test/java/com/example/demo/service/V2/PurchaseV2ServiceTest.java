package com.example.demo.service.V2;

import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.dto.Purchase.RequestPurchaseDTO;
import com.example.demo.dto.Purchase.ResponsePurchaseDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Purchase;
import com.example.demo.repository.*;
import com.example.demo.stabs.*;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PurchaseV2ServiceTest {
    private PurchaseV2Service service;
    @Mock
    private IPurchaseRepository purchaseRepository;
    @Mock
    private ICustomerRepository customerRepository;
    @Mock
    private IPharmacyRepository pharmacyRepository;
    @Mock
    private IPharmacistRepository pharmacistRepository;
    @Mock
    private IRemedyRepository remedyRepository;

    @BeforeEach
    void setup() {
        service = new PurchaseV2Service(
                purchaseRepository,
                customerRepository,
                pharmacyRepository,
                pharmacistRepository,
                remedyRepository,
                new ModelMapper()
        );
    }

    @Test
    void findAll() {
        Purchase Purchase = PurchaseStab.getPurchase();

        Mockito.when(purchaseRepository.findAll()).thenReturn(List.of(Purchase));

        assertTrue(service.findAll().size() > 0);
    }

    @Test
    void findById() {
        Purchase Purchase = PurchaseStab.getPurchase();

        Mockito.when(purchaseRepository.findById(Mockito.any())).thenReturn(Optional.of(Purchase));

        try {
            ResponsePurchaseDTO result = service.findById(PurchaseStab.ID);
            assertAll(() -> assertEquals(Purchase.getId(), result.getId()));
            service.findById(1L);
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }

        assertTrue(service.findAll().size() > 0);
    }

    @Test
    void update() {
        var captor = ArgumentCaptor.forClass(Purchase.class);
        RequestPurchaseDTO PurchaseDTO = PurchaseStab.getRequestDto();
        Mockito.when(purchaseRepository.save(Mockito.any())).thenReturn(PurchaseStab.getPurchase());

        Mockito.when(customerRepository.findById(Mockito.any())).thenReturn(Optional.of(CustomerStab.getCustomer()));
        Mockito.when(customerRepository.existsById(CustomerStab.ID)).thenReturn(true);

        Mockito.when(pharmacistRepository.findById(Mockito.any())).thenReturn(Optional.of(PharmacistStab.getPharmacist()));
        Mockito.when(pharmacistRepository.existsById(PharmacistStab.ID)).thenReturn(true);

        Mockito.when(pharmacyRepository.findById(Mockito.any())).thenReturn(Optional.of(PharmacyStab.getPharmacy()));
        Mockito.when(pharmacyRepository.existsById(PharmacyStab.ID)).thenReturn(true);

        Mockito.when(remedyRepository.findById(Mockito.any())).thenReturn(Optional.of(RemedyStab.getRemedy()));
        Mockito.when(remedyRepository.existsById(RemedyStab.ID)).thenReturn(true);

        try {
            ResponsePurchaseDTO result = service.update(PurchaseStab.ID, PurchaseStab.getRequestDto());
            Mockito.verify(purchaseRepository, Mockito.atLeastOnce()).save(captor.capture());

            assertAll(
                    () -> assertEquals(PurchaseDTO.getCustomerId(), result.getCustomer().getId()),
                    () -> assertEquals(PurchaseDTO.getPharmacistId(), result.getPharmacist().getId()),
                    () -> assertEquals(PurchaseDTO.getPharmacyId(), result.getPharmacy().getId()),
                    () -> assertEquals(PurchaseDTO.getRemedyId(), result.getRemedy().getId())
            );
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void create() {
        var captor = ArgumentCaptor.forClass(Purchase.class);
        RequestPurchaseDTO PurchaseDTO = PurchaseStab.getRequestDto();

        try {
            ResponsePurchaseDTO result = service.create(PurchaseStab.getRequestDto());

            Mockito.verify(purchaseRepository, Mockito.atLeastOnce()).save(captor.capture());

            assertAll(
                    () -> assertEquals(PurchaseDTO.getCustomerId(), result.getCustomer().getId()),
                    () -> assertEquals(PurchaseDTO.getPharmacistId(), result.getPharmacist().getId()),
                    () -> assertEquals(PurchaseDTO.getPharmacyId(), result.getPharmacy().getId()),
                    () -> assertEquals(PurchaseDTO.getRemedyId(), result.getRemedy().getId())
            );
        } catch (Exception e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }

    }
}
