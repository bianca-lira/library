package com.br.library.service;

import com.br.library.model.AuthorBook;
import com.br.library.repository.AuthorBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorBookService implements CrudService<AuthorBook> {

    @Autowired
    private AuthorBookRepository repository;

    @Override
    public List<AuthorBook> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<AuthorBook> findById(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public AuthorBook save(AuthorBook author) {
        return this.repository.save(author);
    }

    @Override
    public void delete(Integer id) {
        Optional<AuthorBook> authorBook = this.repository.findById(id);

        authorBook.ifPresent(author -> this.repository.delete(author));
    }

    @Override
    public AuthorBook update(Integer id) {
        Optional<AuthorBook> authorBook = this.repository.findById(id);

        authorBook.ifPresent(author -> this.repository.save(author));
        return authorBook.orElseThrow();
    }
}
