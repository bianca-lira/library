package com.br.library.service;

import com.br.library.model.BaseEntity;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CrudService<T extends BaseEntity> {
    List<T> findAll();

    Optional<T> findById(Integer id) throws NotFoundException;

    T save(T dto);

    void delete(Integer id) throws NotFoundException;

    T update(Integer id) throws NotFoundException;
}
