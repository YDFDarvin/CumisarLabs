package com.example.demo.service;

import com.example.demo.interfaces.IBaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseCrudService <TEntity extends IBaseEntity> {
    final protected JpaRepository<TEntity, Long> repository;

    public TEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TEntity> findAll() {
        return repository.findAll();
    }

    public TEntity create(TEntity entity) { return repository.save(entity); }

    public TEntity update(Long id, TEntity entity) {
        if(repository.existsById(id))
            return repository.save(entity);
        else
            return null;
    }

    public void delete(TEntity entity) {
        repository.delete(entity);
    }

    public void deleteById(Long id) { repository.deleteById(id); }
}
