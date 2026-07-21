package com.biblioteca.mslibros.model.dto;

import lombok.Data;

@Data
public class LibroRequest {
    private String titulo;
    private String autor;
    private Integer stock;
}