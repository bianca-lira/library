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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
public class Book extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -1313290579039884534L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @NotBlank
    private String title;

    @NotNull
    private Integer year;

    @NotBlank
    private String publishingCompany;

    @NotNull
    private StatusBook status;

    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryBook category;


}
