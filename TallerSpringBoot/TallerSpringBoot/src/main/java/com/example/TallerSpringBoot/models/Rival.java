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

@Table(name = "rival")
public class Rival {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 75)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_nacionalidad", unique = true)
    private Nacionalidad nacionalidad;

    @OneToOne
    @JoinColumn(name = "id_especie", unique = true)
    private Especie especie;

    @OneToMany(mappedBy = "rival", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Campeon> campeones;
}
