package com.br.library.service;

import com.br.library.model.CategoryBook;
import com.br.library.model.StockBook;
import com.br.library.repository.CategoryBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryBookService implements CrudService<CategoryBook> {
    @Autowired
    private CategoryBookRepository repository;

    @Override
    public List<CategoryBook> findAll() {

        return this.repository.findAll();
    }

    @Override
    public Optional<CategoryBook> findById(Integer id) {

        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public CategoryBook save(CategoryBook categoryBook) {

        return this.repository.save(categoryBook);
    }

    @Override
    public void delete(Integer id) {
        Optional<CategoryBook> categoryBookId = findById(id);

        categoryBookId.ifPresent(categoryBookDelete -> this.repository.delete(categoryBookDelete));
    }

    @Override
    public CategoryBook update(Integer id) {
        Optional<CategoryBook> categoryBookId = this.findById(id);

        categoryBookId.ifPresent(categoryBookPresent -> this.repository.save(categoryBookPresent));
        return categoryBookId.orElseThrow();
    }
}
