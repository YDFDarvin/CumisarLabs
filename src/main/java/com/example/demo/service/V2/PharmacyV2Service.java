package com.example.demo.service.V2;

import com.example.demo.dto.Pharmacy.RequestPharmacyDTO;
import com.example.demo.dto.Pharmacy.ResponsePharmacyDTO;
import com.example.demo.entity.Pharmacy;
import com.example.demo.interfaces.services.IPharmacyService;
import com.example.demo.repository.IPharmacyRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PharmacyV2Service implements IPharmacyService {
    final IPharmacyRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public List<ResponsePharmacyDTO> findAll() {
        List<Pharmacy> list = userRepository.findAll();
        return list.stream().map(e -> modelMapper.map(e, ResponsePharmacyDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponsePharmacyDTO findById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        return modelMapper.map(userRepository.findById(id).orElse(null), ResponsePharmacyDTO.class);
    }

    @Override
    public ResponsePharmacyDTO update(Long id, RequestPharmacyDTO dto) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        Pharmacy entity = modelMapper.map(dto, Pharmacy.class);
        entity.setId(id);
        return modelMapper.map(userRepository.save(entity), ResponsePharmacyDTO.class);
    }

    @Override
    public ResponsePharmacyDTO create(RequestPharmacyDTO dto) throws NotFoundException {
        Pharmacy entity = modelMapper.map(dto, Pharmacy.class);
        return modelMapper.map(userRepository.save(entity), ResponsePharmacyDTO.class);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        userRepository.deleteById(id);
    }
}
