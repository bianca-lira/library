package com.br.library.service;

import com.br.library.exception.BusinessRulesException;
import com.br.library.model.AuthorBook;
import com.br.library.repository.AuthorBookRepository;
import javassist.NotFoundException;
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
        List<AuthorBook> authorBookList = this.repository.findAll();

        if (authorBookList.isEmpty()) {
            throw new BusinessRulesException("Não existem autores cadastrados. Por favor, contatar administrador!");
        }
        return authorBookList;
    }

    @Override
    public Optional<AuthorBook> findById(Integer id) throws NotFoundException {
        Optional<AuthorBook> authorBook = this.repository.findById(id);

        if (authorBook.isEmpty()){
            throw new NotFoundException("Não foi encontrado autor com o id informado");
        }

        return authorBook;
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
