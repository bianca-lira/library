package com.br.library.service;

import com.br.library.model.Book;
import com.br.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements CrudService<Book> {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {
        return this.repository.findAll();
    }

    public Optional<Book> findById(Integer id) {
        return this.repository.findById(id);
    }

    public Book save(Book book) {
        return this.repository.save(book);
    }

    public void delete(Integer id) {
        Optional<Book> book = this.repository.findById(id);
        book.ifPresent(bookDelete -> this.repository.delete(bookDelete));
    }

    public Book update(Integer id, Book dto) {
        Optional<Book> book = this.repository.findById(id);

        book.ifPresent(bookUpdate -> this.repository.save(bookUpdate));
        return book.orElseThrow();
    }
}
