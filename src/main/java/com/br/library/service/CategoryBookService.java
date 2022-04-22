package com.br.library.service;

import com.br.library.model.CategoryBook;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Entity
public class CategoryBookService implements CrudService<CategoryBook> {
    @Override
    public List<CategoryBook> findAll() {
        return null;
    }

    @Override
    public Optional<CategoryBook> findById(Long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public CategoryBook save(CategoryBook dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CategoryBook update(Long id, CategoryBook dto) {
        return null;
    }
}
