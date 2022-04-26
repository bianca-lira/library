package com.br.library.service;

import com.br.library.model.StockBook;
import com.br.library.repository.StockBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockBookService implements CrudService<StockBook> {

    @Autowired
    private StockBookRepository repository;

    @Override
    public List<StockBook> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<StockBook> findById(Integer id) {

        return this.repository.findById(id);
    }

    @Override
    public StockBook save(StockBook dto) {

        return this.repository.save(dto);
    }

    @Override
    public void delete(Integer id) {
        Optional<StockBook> stockBookId = findById(id);

        stockBookId.ifPresent(stockBookDelete -> this.repository.delete(stockBookDelete));
    }

    @Override
    public StockBook update(Integer id) {
        Optional<StockBook> stockBook = this.findById(id);

        stockBook.ifPresent(stockBookUpdate -> this.repository.save(stockBookUpdate));
        return stockBook.orElseThrow();
    }
}
