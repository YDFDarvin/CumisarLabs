package com.example.demo.service.V2;

import com.example.demo.dto.Customer.RequestCustomerDTO;
import com.example.demo.dto.Customer.ResponseCustomerDTO;
import com.example.demo.dto.Pharmacist.RequestPharmacistDTO;
import com.example.demo.dto.Pharmacist.ResponsePharmacistDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Pharmacist;
import com.example.demo.interfaces.services.ICustomerService;
import com.example.demo.interfaces.services.IPharmacistService;
import com.example.demo.repository.IPharmacistRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PharmacistV2Service implements IPharmacistService {
    final IPharmacistRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public List<ResponsePharmacistDTO> findAll() {
        List<Pharmacist> list = userRepository.findAll();
        return list.stream().map(e -> modelMapper.map(e, ResponsePharmacistDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponsePharmacistDTO findById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        return modelMapper.map(userRepository.findById(id).orElse(null), ResponsePharmacistDTO.class);
    }

    @Override
    public ResponsePharmacistDTO update(Long id, RequestPharmacistDTO dto) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        Pharmacist entity = modelMapper.map(dto, Pharmacist.class);
        entity.setId(id);
        return modelMapper.map(userRepository.save(entity), ResponsePharmacistDTO.class);
    }

    @Override
    public ResponsePharmacistDTO create(RequestPharmacistDTO dto) throws NotFoundException {
        Pharmacist entity = modelMapper.map(dto, Pharmacist.class);
        return modelMapper.map(userRepository.save(entity), ResponsePharmacistDTO.class);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        userRepository.deleteById(id);
    }
}
