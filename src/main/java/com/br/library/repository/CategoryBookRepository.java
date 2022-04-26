package com.br.library.repository;

import com.br.library.model.CategoryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryBookRepository extends JpaRepository<CategoryBook, Integer> {
}
