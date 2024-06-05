package com.example.TallerSpringBoot.models;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(name = "nacionalidad")
public class Nacionalidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "nombre")
    private NombreNacionalidad nombre;

    @OneToOne(mappedBy = "nacionalidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Rival rival;

    @OneToOne(mappedBy = "nacionalidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Counter counter;

    @OneToOne(mappedBy = "nacionalidad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Campeon campeon;
}
