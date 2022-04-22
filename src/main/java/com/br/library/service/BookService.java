package com.br.library.service;

import com.br.library.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements CrudService<Book>{
    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Book save(Book dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Book update(Long id, Book dto) {
        return null;
    }
}
