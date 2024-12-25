package com.example.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.inventario.models.Almacen;

public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
}