package com.example.inventario.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.inventario.models.Almacen;
import com.example.inventario.services.AlmacenService;

@RestController
@RequestMapping("/api/almacenes")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @GetMapping
    public List<Almacen> listarTodos() {
        return almacenService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Almacen> buscarPorId(@PathVariable Integer id) {
        return almacenService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Almacen guardar(@RequestBody Almacen almacen) {
        return almacenService.guardar(almacen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Almacen> actualizar(@PathVariable Integer id, @RequestBody Almacen almacen) {
        return almacenService.buscarPorId(id)
                .map(almacenExistente -> {
                    almacen.setAlmacenID(id);
                    return ResponseEntity.ok(almacenService.guardar(almacen));
                })
                .orElse(ResponseEntity.notFound().build());
    }

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