package com.example.demo.dto.Customer;

import com.example.demo.entity.Customer;
import com.example.demo.interfaces.IBaseModelMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class CustomerModelMapper implements IBaseModelMapper<Customer, RequestCustomerDTO, ResponseCustomerDTO> {
    final ModelMapper modelMapper;

    @Override
    public Customer convertFromRequestDTO(RequestCustomerDTO dto) {
        if (dto == null) return null;
        Customer customer = modelMapper.map(dto, Customer.class);
        customer.setPurchases(new HashSet<>());
        return customer;
    }

    @Override
    public ResponseCustomerDTO convertToResponseDTO(Customer entity) {
        if (entity == null) return null;
        return modelMapper.map(entity, ResponseCustomerDTO.class);
    }
}
