package com.technical.test.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;
    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    private Rol rol;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ACTIVO")
    private char activo;




}
