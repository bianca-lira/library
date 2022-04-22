package com.br.library.service;

import com.br.library.model.AuthorBook;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorBookService implements CrudService<AuthorBook>{


    @Override
    public List<AuthorBook> findAll() {
        return null;
    }

    @Override
    public Optional<AuthorBook> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public AuthorBook save(AuthorBook dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public AuthorBook update(Long id, AuthorBook dto) {
        return null;
    }
}
