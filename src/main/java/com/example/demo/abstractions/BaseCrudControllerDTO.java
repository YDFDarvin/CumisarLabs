package com.example.demo.abstractions;

import com.example.demo.interfaces.IBaseModelMapper;
import com.example.demo.interfaces.dto.IBaseDTO;
import com.example.demo.interfaces.entity.IBaseEntity;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public abstract class BaseCrudControllerDTO<TEntity extends IBaseEntity, TRequestDTO extends IBaseDTO, TResponseDTO extends IBaseDTO> {
    final BaseCrudService<TEntity> service;
    final IBaseModelMapper<TEntity, TRequestDTO, TResponseDTO> modelMapper;

    @ApiOperation(value = "Get list of entities")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TResponseDTO> getAll(
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        List<TEntity> list = service.findAll();
        final int listSize = list.size();
        int start = 0;
        int end = listSize;
        if(listSize > size) {
            start = Math.min(listSize, size * (page - 1));
            end = Math.min(listSize, page * size);
        }
        return list.subList(start, end).stream().map(modelMapper::convertToResponseDTO).collect(Collectors.toList());
    }

    @ApiOperation(value = "Get single entity by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TResponseDTO getById(@PathVariable Long id) {
        return modelMapper.convertToResponseDTO(service.findById(id));
    }

    @ApiOperation(value = "Delete entity by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @ApiOperation(value = "Update entity by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TResponseDTO update(@PathVariable Long id, @RequestBody TRequestDTO dto) {
        TEntity entity = modelMapper.convertFromRequestDTO(dto);
        entity.setId(id);
        return modelMapper.convertToResponseDTO(service.update(id, entity));
    }

    @ApiOperation(value = "Create entity")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TResponseDTO create(@RequestBody TRequestDTO dto) {
        return modelMapper.convertToResponseDTO(service.create(modelMapper.convertFromRequestDTO(dto)));
    }
}
