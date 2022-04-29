package com.br.library.controller;

import com.br.library.model.BaseEntity;
import com.br.library.service.CrudService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public abstract class CrudResource<T extends BaseEntity>{

    private CrudService<T> service;

    public CrudResource(CrudService<T> crudService){
        this.service = crudService;
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable Integer id) throws NotFoundException {
        Optional<T> optionalT = service.findById(id);
        return optionalT.map(T ->
                        new ResponseEntity<>(T, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<T> save(@Valid @RequestBody T body){
        return new ResponseEntity<>(service.save(body), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) throws NotFoundException {
        Optional<T> optional = service.findById(id);
        return optional.map(T ->
                        new ResponseEntity<>("Object with the id " + id + " was deleted.", HttpStatus.NO_CONTENT))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable Integer id, @Valid @RequestBody T body) throws NotFoundException {
        return ResponseEntity.ok(service.update(id));
    }
}
