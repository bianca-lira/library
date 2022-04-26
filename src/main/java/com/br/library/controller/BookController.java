package com.br.library.controller;

import com.br.library.model.Book;
import com.br.library.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("{api.version}/books")
public class BookController extends CrudResource<Book>{
    public BookController(BookService crudService) {
        super(crudService);
    }
}
