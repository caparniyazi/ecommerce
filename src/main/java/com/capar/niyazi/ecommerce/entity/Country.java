package com.capar.niyazi.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "country")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    // Ignore the states when returning JSON.
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> states;

    // Ignore the cities when returning JSON.
    // The value of mappedBy is the name of the association-mapping attribute on the owning side.
    // With this, we have now established a bidirectional association between our Country and City entities.
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<City> cities;
}
