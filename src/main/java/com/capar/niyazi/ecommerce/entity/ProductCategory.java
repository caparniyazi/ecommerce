package com.capar.niyazi.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "product_category")
// @Data -- Known bug
@Getter
@Setter
public class ProductCategory {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    /*
    CascadeType.ALL means all entity state changes on the parent will be cascaded to the children.
    This includes:

    PERSIST → Saving the parent also saves children
    MERGE → Updating the parent also updates children
    REMOVE → Deleting the parent also deletes children
    REFRESH → Refreshing parent also refreshes children
    DETACH → Detaching parent also detaches children

    mappedBy tells Hibernate:
    This side is not the owner of the relationship; the other side owns the foreign key.
    In a bidirectional relationship, only one side owns the association
    (the one with the foreign key column).
    The owning side is where you put @JoinColumn.
    The inverse side is where you put mappedBy.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;
}
