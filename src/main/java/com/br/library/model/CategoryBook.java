package com.br.library.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category_book")
@Data
public class CategoryBook extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6483558778349016631L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    @Column(name = "code")
    @NotNull
    private Integer code;

    @Column(name = "description")
    @NotBlank
    private String description;


}
