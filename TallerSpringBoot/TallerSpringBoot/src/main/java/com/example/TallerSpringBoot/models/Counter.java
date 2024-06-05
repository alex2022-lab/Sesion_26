package com.example.TallerSpringBoot.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(name = "counter")
public class Counter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 70)
    private String nombre;

    @Column(name = "porcentaje_victoria", columnDefinition = "FLOAT")
    private double porcentajeVictoria;

    @Column(name = "porcentaje_derrota", columnDefinition = "FLOAT")
    private double porcentajeDerrota;

    @OneToOne
    @JoinColumn(name = "id_nacionalidad", unique = true)
    private Nacionalidad nacionalidad;

    @OneToOne
    @JoinColumn(name = "id_especie", unique = true)
    private Especie especie;

    @OneToMany(mappedBy = "counter", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Campeon> campeones;
}
