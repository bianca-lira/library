package com.br.library.controller;

import com.br.library.model.CategoryBook;
import com.br.library.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("{api.version}/categories")
public class CategoryBookResource extends CrudResource<CategoryBook>{
    public CategoryBookResource(CrudService<CategoryBook> crudService) {
        super(crudService);
    }
}
