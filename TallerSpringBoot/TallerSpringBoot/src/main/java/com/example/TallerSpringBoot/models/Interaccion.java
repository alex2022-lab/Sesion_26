package com.example.TallerSpringBoot.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

@Table(name = "interaccion")
public class Interaccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_interaccion", length = 45)
    private String nombreInteraccion;

    @Column(name = "limite_interaccion")
    private Integer limiteInteraccion;

    @ManyToMany(mappedBy = "campeones")
    private List<Campeon> campeons = new ArrayList<>();

}
