package com.example.demo.service.V2;

import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.stabs.CustomerStab;
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
public class CustomerV2ServiceTest {
    private CustomerV2Service customerV2Service;
    @Mock
    private ICustomerRepository customerRepository;

    @BeforeEach
    void setup() {
        customerV2Service = new CustomerV2Service(customerRepository, new ModelMapper());
    }

    @Test
    void findById() {
        Customer customer = CustomerStab.getCustomer();

        Mockito.when(customerRepository.findAll()).thenReturn(List.of(customer));

        assertTrue(customerV2Service.findAll().size() > 0);
    }

    @Test
    void update() {
        var captor = ArgumentCaptor.forClass(Customer.class);
        RequestCustomerDTO userDTO = CustomerStab.getRequestDto();
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(CustomerStab.getCustomer());
        Mockito.when(customerRepository.existsById(CustomerStab.ID)).thenReturn(true);
        try {
            ResponseCustomerDTO saved = customerV2Service.create(CustomerStab.getRequestDto());
            ResponseCustomerDTO result = customerV2Service.update(CustomerStab.ID, CustomerStab.getRequestDto());
            Mockito.verify(customerRepository, Mockito.atLeastOnce()).save(captor.capture());

            assertAll(
                    () -> assertEquals(userDTO.getName(), result.getName()),
                    () -> assertEquals(userDTO.getBalance(), result.getBalance())
            );
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }

    @Test
    void create() throws NotFoundException {
        var captor = ArgumentCaptor.forClass(Customer.class);
        RequestCustomerDTO userDTO = CustomerStab.getRequestDto();

        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(CustomerStab.getCustomer());

        ResponseCustomerDTO result = customerV2Service.create(CustomerStab.getRequestDto());

        Mockito.verify(customerRepository, Mockito.atLeastOnce()).save(captor.capture());

        assertAll(
                () -> assertEquals(userDTO.getName(), result.getName()),
                () -> assertEquals(userDTO.getBalance(), result.getBalance())
        );
    }

    @Test
    void deleteById() {
        Mockito.when(customerRepository.save(Mockito.any())).thenReturn(CustomerStab.getCustomer());
        Mockito.when(customerRepository.existsById(CustomerStab.ID)).thenReturn(true);
        try {
            customerV2Service.deleteById(CustomerStab.ID);

            var captor = ArgumentCaptor.forClass(Long.class);
            customerV2Service.create(CustomerStab.getRequestDto());
            Mockito.verify(customerRepository, Mockito.atLeastOnce()).deleteById(captor.capture());
        } catch (NotFoundException e) {
            String expectedMessage = "not found";
            String actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessage));
        }
    }
}
