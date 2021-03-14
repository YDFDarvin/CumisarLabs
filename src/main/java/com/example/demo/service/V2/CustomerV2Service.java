package com.example.demo.service.V2;


import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.interfaces.services.ICustomerService;
import com.example.demo.repository.ICustomerRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerV2Service implements ICustomerService {
    final ICustomerRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public List<ResponseCustomerDTO> findAll() {
        List<Customer> list = userRepository.findAll();
        return list.stream().map(e -> modelMapper.map(e, ResponseCustomerDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseCustomerDTO findById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        return modelMapper.map(userRepository.findById(id).orElse(null), ResponseCustomerDTO.class);
    }

    @Override
    public ResponseCustomerDTO update(Long id, RequestCustomerDTO dto) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        Customer entity = modelMapper.map(dto, Customer.class);
        entity.setId(id);
        return modelMapper.map(userRepository.save(entity), ResponseCustomerDTO.class);
    }

    @Override
    public ResponseCustomerDTO create(RequestCustomerDTO dto) throws NotFoundException {
        Customer entity = modelMapper.map(dto, Customer.class);
        return modelMapper.map(userRepository.save(entity), ResponseCustomerDTO.class);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        userRepository.deleteById(id);
    }
}
