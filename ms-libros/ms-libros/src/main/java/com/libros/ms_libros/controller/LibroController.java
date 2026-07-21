package com.libros.ms_libros.controller;
import com.libros.ms_libros.model.dto.LibroRequest;
import com.libros.ms_libros.model.dto.LibroResponse;
import com.libros.ms_libros.service.LibroService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
@RequiredArgsConstructor
@Tag(name = "Libros", description = "Gestión de libros de la biblioteca") // <-- aparece agrupado en Swagger
public class LibroController {

    private final LibroService libroService;

    @GetMapping
    public List<LibroResponse> listar() {
        return libroService.listarTodos();
    }

    @GetMapping("/{id}")
    public LibroResponse buscarPorId(@PathVariable Long id) {
        return libroService.buscarPorId(id);
    }

    @PostMapping
    public LibroResponse crear(@RequestBody LibroRequest request) {
        return libroService.guardar(request);
    }

    @PutMapping("/{id}")
    public LibroResponse actualizar(@PathVariable Long id, @RequestBody LibroRequest request) {
        return libroService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        libroService.eliminar(id);
    }

    @PutMapping("/{id}/descontar-stock")
    public void descontarStock(@PathVariable Long id) {
        libroService.descontarStock(id); // <-- endpoint interno, lo llama ms-prestamos vía Feign
    }
}