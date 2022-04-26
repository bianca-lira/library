package com.br.library.model;

import com.br.library.model.enums.StatusBook;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Data
public class Book extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1313290579039884534L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private Integer year;

    @Column(name = "publishing_company")
    private String publishingCompany;

    @Column(name = "status")
    private StatusBook status;

    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryBook category;


}
