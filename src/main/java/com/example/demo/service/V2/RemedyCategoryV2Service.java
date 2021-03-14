package com.example.demo.service.V2;

import com.example.demo.dto.RemedyCategory.RequestRemedyCategoryDTO;
import com.example.demo.dto.RemedyCategory.ResponseRemedyCategoryDTO;
import com.example.demo.entity.RemedyCategory;
import com.example.demo.interfaces.services.IRemedyCategoryService;
import com.example.demo.repository.IRemedyCategoryRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RemedyCategoryV2Service implements IRemedyCategoryService {
    final IRemedyCategoryRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public List<ResponseRemedyCategoryDTO> findAll() {
        List<RemedyCategory> list = userRepository.findAll();
        return list.stream().map(e -> modelMapper.map(e, ResponseRemedyCategoryDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseRemedyCategoryDTO findById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        return modelMapper.map(userRepository.findById(id).orElse(null), ResponseRemedyCategoryDTO.class);
    }

    @Override
    public ResponseRemedyCategoryDTO update(Long id, RequestRemedyCategoryDTO dto) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        RemedyCategory entity = modelMapper.map(dto, RemedyCategory.class);
        entity.setId(id);
        return modelMapper.map(userRepository.save(entity), ResponseRemedyCategoryDTO.class);
    }

    @Override
    public ResponseRemedyCategoryDTO create(RequestRemedyCategoryDTO dto) throws NotFoundException {
        RemedyCategory entity = modelMapper.map(dto, RemedyCategory.class);
        return modelMapper.map(userRepository.save(entity), ResponseRemedyCategoryDTO.class);
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
        if(!userRepository.existsById(id)) throw new NotFoundException("User with specified id not found");

        userRepository.deleteById(id);
    }
}
