package com.example.inventario.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventario.models.Almacen;
import com.example.inventario.services.AlmacenService;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {

    @Autowired
    private AlmacenService almacenService;

    // Listar todos los almacenes
    @GetMapping
    public List<Almacen> listarTodos() {
        return almacenService.listarTodos();
    }

    // Buscar un almacén por ID
    @GetMapping("/{id}")
    public ResponseEntity<Almacen> buscarPorId(@PathVariable Integer id) {
        return almacenService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo almacén
    @PostMapping
    public ResponseEntity<Almacen> guardar(@RequestBody Almacen almacen) {
        if (almacen.getNombre() == null || almacen.getNombre().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Almacen nuevoAlmacen = almacenService.guardar(almacen);
        return ResponseEntity.ok(nuevoAlmacen);
    }

    // Actualizar un almacén existente
    @PutMapping("/{id}")
    public ResponseEntity<Almacen> actualizar(@PathVariable Integer id, @RequestBody Almacen almacen) {
        return almacenService.buscarPorId(id)
                .map(almacenExistente -> {
                    almacen.setAlmacenID(id);
                    Almacen almacenActualizado = almacenService.guardar(almacen);
                    return ResponseEntity.ok(almacenActualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un almacén por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Integer id) {
        return almacenService.buscarPorId(id)
                .map(almacen -> {
                    almacenService.eliminarPorId(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}