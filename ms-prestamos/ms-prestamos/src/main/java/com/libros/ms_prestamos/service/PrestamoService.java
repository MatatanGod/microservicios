package com.libros.ms_prestamos.service;

import com.libros.ms_prestamos.client.LibroClient;
import com.libros.ms_prestamos.model.Prestamo;
import com.libros.ms_prestamos.model.dto.PrestamoRequest;
import com.libros.ms_prestamos.model.dto.PrestamoResponse;
import com.libros.ms_prestamos.model.mapper.PrestamoMapper;
import com.libros.ms_prestamos.repository.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor // <-- Lombok crea el constructor con los campos final de abajo (inyección de dependencias)
public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final PrestamoMapper prestamoMapper;
    private final LibroClient libroClient; // <-- cliente Feign para hablar con ms-libros

    public List<PrestamoResponse> listarTodos() {
        return prestamoRepository.findAll().stream().map(prestamoMapper::toResponse).toList();
    }

    public PrestamoResponse crear(PrestamoRequest request) {
        libroClient.descontarStock(request.getLibroId()); // <-- llamada real al otro microservicio
        Prestamo prestamo = prestamoMapper.toEntity(request);
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.setEstado("PRESTADO");
        return prestamoMapper.toResponse(prestamoRepository.save(prestamo));
    }

    public PrestamoResponse devolver(Long id) {
        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
        prestamo.setFechaDevolucion(LocalDate.now());
        prestamo.setEstado("DEVUELTO");
        return prestamoMapper.toResponse(prestamoRepository.save(prestamo));
    }
}