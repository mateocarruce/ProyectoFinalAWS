package com.example.inventario.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventario.models.Almacen;
import com.example.inventario.repositories.AlmacenRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlmacenService {
    @Autowired
    private AlmacenRepository almacenRepository;

    public List<Almacen> listarTodos() {
        return almacenRepository.findAll();
    }

    public Optional<Almacen> buscarPorId(Integer id) {
        return almacenRepository.findById(id);
    }

    public Almacen guardar(Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    public void eliminarPorId(Integer id) {
        almacenRepository.deleteById(id);
    }
}