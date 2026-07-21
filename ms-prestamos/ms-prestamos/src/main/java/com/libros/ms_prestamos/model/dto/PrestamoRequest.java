package com.libros.ms_prestamos.model;
import lombok.Data;

@Data
public class PrestamoRequest {
    private Long libroId;
    private String usuario;
}