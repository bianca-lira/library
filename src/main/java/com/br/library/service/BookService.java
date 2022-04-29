package com.br.library.service;

import com.br.library.exception.BusinessRulesException;
import com.br.library.model.Book;
import com.br.library.repository.BookRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements CrudService<Book> {

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> findAll() {
        List<Book> bookList = this.repository.findAll();

        if (bookList.isEmpty()) {
            throw new BusinessRulesException("Não existem livros cadastrados. Por favor, contatar administrador!");
        }
        return bookList;
    }

    @Override
    public Optional<Book> findById(Integer id) throws NotFoundException {
        Optional<Book> book = this.repository.findById(id);

        if (book.isEmpty()){
            throw new NotFoundException("Não foi encontrado autor com o id informado");
        }
        return book;
    }

    @Override
    public Book save(Book book) {
        return this.repository.save(book);
    }

    @Override
    public void delete(Integer id) {
        Optional<Book> book = this.repository.findById(id);
        book.ifPresent(bookDelete -> this.repository.delete(bookDelete));
    }

    @Override
    public Book update(Integer id) {
        Optional<Book> book = this.repository.findById(id);

        book.ifPresent(bookUpdate -> this.repository.save(bookUpdate));
        return book.orElseThrow();
    }
}
