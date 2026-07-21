package com.libros.ms_prestamos.model.dto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrestamoResponse {
    private Long id;
    private Long libroId;
    private String usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private String estado;
}