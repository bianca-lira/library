package com.br.library.repository;

import com.br.library.model.StockBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockBookRepository extends JpaRepository<StockBook, Integer> {
}
