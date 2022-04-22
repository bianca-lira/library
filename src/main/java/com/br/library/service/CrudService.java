package com.br.library.service;

import com.br.library.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService<T extends BaseEntity> {
    List<T> findAll();

    Optional<T> findById(Long id);

    T save(T dto);

    void delete(Long id);

    T update(Long id, T dto);
}
