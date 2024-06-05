package com.example.TallerSpringBoot.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

@Table(name = "campeon")
public class Campeon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_ataque", length = 15)
    private String tipoAtaque;

    @Column(name = "vida_base")
    private Integer vidaBase;

    @Column(name = "mana_bool", columnDefinition = "TINYINT")
    private Integer manaBool;

    @Column(name = "energia_bool", columnDefinition = "TINYINT")
    private Integer energiaBool;

    @Column(name = "velocidad_ataque_base", columnDefinition = "FLOAT")
    private double velocidadAtaqueBase;

    @Column(name = "velocidad_movimiento_base")
    private Integer velocidadMovimientoBase;

    @Column(name = "nombre", length = 70)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "id_nacionalidad", unique = true)
    private Nacionalidad nacionalidad;

    @OneToOne
    @JoinColumn(name = "id_especie", unique = true)
    private Especie especie;

    @ManyToOne
    @JoinColumn(name = "id_counter")
    private Counter counter;

    @ManyToOne
    @JoinColumn(name = "id_rival")
    private Rival rival;

    @ManyToMany
    @JoinTable(
        name = "campeon_has_interaccion",
        joinColumns = @JoinColumn(name = "id_interaccion"),
        inverseJoinColumns = @JoinColumn(name = "id_campeon")
    )
    private List<Interaccion> campeones = new ArrayList<>();
    

}
