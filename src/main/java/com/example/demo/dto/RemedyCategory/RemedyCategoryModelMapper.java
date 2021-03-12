package com.example.demo.dto.RemedyCategory;

import com.example.demo.entity.RemedyCategory;
import com.example.demo.interfaces.IBaseModelMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class RemedyCategoryModelMapper implements IBaseModelMapper<RemedyCategory, RequestRemedyCategoryDTO, ResponseRemedyCategoryDTO> {
    final ModelMapper modelMapper;

    @Override
    public RemedyCategory convertFromRequestDTO(RequestRemedyCategoryDTO dto) {
        if (dto == null) return null;
        RemedyCategory remedyCategory = modelMapper.map(dto, RemedyCategory.class);
        remedyCategory.setRemedies(new HashSet<>());
        return remedyCategory;
    }

    @Override
    public ResponseRemedyCategoryDTO convertToResponseDTO(RemedyCategory entity) {
        if (entity == null) return null;
        return modelMapper.map(entity, ResponseRemedyCategoryDTO.class);
    }
}
