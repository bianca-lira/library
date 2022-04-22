package com.br.library.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Data
public class StockBook extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -8309252866254956826L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @OneToOne
    private Book idBook;

    @Column(name = "quantity")
    private Integer quantity;
}
