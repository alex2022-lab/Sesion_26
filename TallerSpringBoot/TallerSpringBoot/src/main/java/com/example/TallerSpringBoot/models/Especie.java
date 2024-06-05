package com.example.TallerSpringBoot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

public class Especie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre")
    private Nombre nombre;

    @OneToOne(mappedBy = "especie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rival rival;

    @OneToOne(mappedBy = "especie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Counter counter;

    @OneToOne(mappedBy = "especie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Campeon campeon;


    
}

