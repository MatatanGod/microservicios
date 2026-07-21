package com.biblioteca.mslibros.model.dto;

import lombok.Data;

@Data
public class LibroResponse {
    private Long id;
    private String titulo;
    private String autor;
    private Integer stock;
}