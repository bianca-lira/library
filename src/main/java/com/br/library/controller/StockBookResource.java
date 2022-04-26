package com.br.library.controller;

import com.br.library.model.StockBook;
import com.br.library.service.StockBookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("{api.version}/stocks")
public class StockBookResource extends CrudResource<StockBook> {
    public StockBookResource(StockBookService crudService) {
        super(crudService);
    }
}
