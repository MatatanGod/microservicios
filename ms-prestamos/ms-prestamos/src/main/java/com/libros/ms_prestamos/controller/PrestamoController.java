package com.libros.ms_prestamos.controller;

import com.libros.ms_prestamos.model.dto.PrestamoRequest;
import com.libros.ms_prestamos.model.dto.PrestamoResponse;
import com.libros.ms_prestamos.service.PrestamoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
@RequiredArgsConstructor
@Tag(name = "Préstamos", description = "Gestión de préstamos de libros")
public class PrestamoController {

    private final PrestamoService prestamoService;

    @GetMapping
    public List<PrestamoResponse> listar() {
        return prestamoService.listarTodos();
    }

    @PostMapping
    public PrestamoResponse crear(@RequestBody PrestamoRequest request) {
        return prestamoService.crear(request);
    }

    @PutMapping("/{id}/devolver")
    public PrestamoResponse devolver(@PathVariable Long id) {
        return prestamoService.devolver(id);
    }
}