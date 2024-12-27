package com.example; // Asegúrate de que coincida con el paquete de InventariosApplication

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.inventario.InventariosApplication;

@SpringBootTest(classes = InventariosApplication.class)
public class InventariosApplicationTests {
    
    @Test
    void contextLoads() {
        // Este método prueba si el contexto de la aplicación se carga correctamente.
    }
}
