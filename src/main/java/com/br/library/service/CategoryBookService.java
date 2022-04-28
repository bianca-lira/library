package com.br.library.service;

import com.br.library.exception.BusinessRulesException;
import com.br.library.model.Book;
import com.br.library.model.CategoryBook;
import com.br.library.model.StockBook;
import com.br.library.repository.CategoryBookRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryBookService implements CrudService<CategoryBook> {
    @Autowired
    private CategoryBookRepository repository;

    @Override
    public List<CategoryBook> findAll() {
        List<CategoryBook> categoryBookList = this.repository.findAll();

        if (categoryBookList.isEmpty()) {
            throw new BusinessRulesException("Não existem categorias de livros cadastradas. Por favor, contatar administrador!");
        }
        return categoryBookList;
    }

    @Override
    public Optional<CategoryBook> findById(Integer id) throws NotFoundException {

        Optional<CategoryBook> categoryBook = this.repository.findById(id);

        if (categoryBook.isEmpty()){
            throw new NotFoundException("Não foi encontrado autor com o id informado");
        }
        return categoryBook;
    }

    @Override
    @Transactional
    public CategoryBook save(CategoryBook categoryBook) {

        return this.repository.save(categoryBook);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        Optional<CategoryBook> categoryBookId = findById(id);

        categoryBookId.ifPresent(categoryBookDelete -> this.repository.delete(categoryBookDelete));
    }

    @Override
    public CategoryBook update(Integer id) throws NotFoundException {
        Optional<CategoryBook> categoryBookId = this.findById(id);

        categoryBookId.ifPresent(categoryBookPresent -> this.repository.save(categoryBookPresent));
        return categoryBookId.orElseThrow();
    }
}
