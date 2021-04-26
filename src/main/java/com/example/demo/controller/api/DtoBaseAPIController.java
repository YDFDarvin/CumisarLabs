package com.example.demo.controller.api;

import com.example.demo.interfaces.IBaseDTO;
import com.example.demo.interfaces.IBaseEntity;
import com.example.demo.interfaces.IDtoCrudService;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public abstract class DtoBaseAPIController <TEntity extends IBaseEntity, TRequestDTO extends IBaseDTO, TResponseDTO extends IBaseDTO> {
    final IDtoCrudService<TRequestDTO, TResponseDTO> service;

    @ApiOperation(value = "Get list of entities")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TResponseDTO> getAll(
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        List<TResponseDTO> list = service.findAll();
        final int listSize = list.size();
        int start = 0;
        int end = listSize;
        if(listSize > size) {
            start = Math.min(listSize, size * (page - 1));
            end = Math.min(listSize, page * size);
        }
        return list.subList(start, end);
    }

    @ApiOperation(value = "Get single entity by id")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TResponseDTO getById(@PathVariable Long id) throws NotFoundException {
        return service.findById(id);
    }

    @ApiOperation(value = "Delete entity by id")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) throws NotFoundException {
        service.deleteById(id);
    }

    @ApiOperation(value = "Update entity by id")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TResponseDTO update(@PathVariable Long id, @RequestBody TRequestDTO dto) throws NotFoundException {
        return service.update(id, dto);
    }

    @ApiOperation(value = "Create entity")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TResponseDTO create(@RequestBody TRequestDTO dto) throws NotFoundException {
        return service.create(dto);
    }
}
