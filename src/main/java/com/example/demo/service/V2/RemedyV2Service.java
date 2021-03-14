package com.example.demo.service.V2;

import com.example.demo.dto.Pharmacy.ResponsePharmacyDTO;
import com.example.demo.dto.Remedy.RequestRemedyDTO;
import com.example.demo.dto.Remedy.ResponseRemedyDTO;
import com.example.demo.entity.Pharmacy;
import com.example.demo.entity.Remedy;
import com.example.demo.interfaces.services.IRemedyService;
import com.example.demo.repository.IRemedyRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RemedyV2Service implements IRemedyService {
    final IRemedyRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public List<ResponseRemedyDTO> findAll() {
        List<Remedy> list = userRepository.findAll();
        return list.stream().map(e -> modelMapper.map(e, ResponseRemedyDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseRemedyDTO findById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        return modelMapper.map(userRepository.findById(id).orElse(null), ResponseRemedyDTO.class);
    }

    @Override
    public ResponseRemedyDTO update(Long id, RequestRemedyDTO dto) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        Remedy entity = modelMapper.map(dto, Remedy.class);
        entity.setId(id);
        return modelMapper.map(userRepository.save(entity), ResponseRemedyDTO.class);
    }

    @Override
    public ResponseRemedyDTO create(RequestRemedyDTO dto) throws NotFoundException {
        Remedy entity = modelMapper.map(dto, Remedy.class);
        return modelMapper.map(userRepository.save(entity), ResponseRemedyDTO.class);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        userRepository.deleteById(id);
    }
}
