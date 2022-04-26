package com.br.library.controller;

import com.br.library.model.AuthorBook;
import com.br.library.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("{api.version}/authors")
public class AuthorBookResource extends CrudResource<AuthorBook>{
    public AuthorBookResource(CrudService<AuthorBook> crudService) {
        super(crudService);
    }
}
