package com.example.demo.interfaces;

import com.example.demo.interfaces.dto.IBaseDTO;
import com.example.demo.interfaces.entity.IBaseEntity;

public interface IBaseModelMapper<TEntity extends IBaseEntity, TRequestDTO extends IBaseDTO, TResponseDTO extends IBaseDTO> {
    TEntity convertFromRequestDTO(TRequestDTO dto);

    TResponseDTO convertToResponseDTO(TEntity entity);
}
