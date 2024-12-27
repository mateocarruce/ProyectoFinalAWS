package com.example.inventario.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Almacenes")
@Data
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer almacenID;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = true)
    private String ubicacion;

    @Column(nullable = false)
    private Integer capacidad;
}