package com.biblioteca.ms_prestamos.model.dto;

import lombok.Data;

@Data
public class PrestamoRequest {
    private Long libroId;
    private String usuario;
}