package com.br.library.service;

import com.br.library.model.StockBook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockBookService implements CrudService<StockBook> {

    @Override
    public List<StockBook> findAll() {
        return null;
    }

    @Override
    public Optional<StockBook> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public StockBook save(StockBook dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public StockBook update(Long id, StockBook dto) {
        return null;
    }
}
