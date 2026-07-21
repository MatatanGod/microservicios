package com.libros.ms_libros.model.dto;
import lombok.Data;

@Data
public class LibroResponse {
    private Long id;
    private String titulo;
    private String autor;
    private Integer stock;
}