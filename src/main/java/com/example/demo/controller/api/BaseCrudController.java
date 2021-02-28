package com.example.demo.controller.api;

import com.example.demo.service.BaseCrudService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public abstract class BaseCrudController<TEntity> {
    final BaseCrudService<TEntity> service;

    @ApiOperation(value = "Get list of entities")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TEntity> getAll(
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        List<TEntity> list = service.findAll();
        if(list.size() < size) return list;

        int start = Math.min(list.size(), size * (page - 1));
        int end = Math.min(list.size(), page * size);
        return list.subList(start, end);
    }

    @ApiOperation(value = "Get single entity by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TEntity getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @ApiOperation(value = "Delete entity by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @ApiOperation(value = "Update entity by id")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public TEntity update(@PathVariable Long id, @RequestBody TEntity entity) {
        return service.update(id, entity);
    }

    @ApiOperation(value = "Create entity")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TEntity create(@RequestBody TEntity entity) {
        return service.create(entity);
    }
}
