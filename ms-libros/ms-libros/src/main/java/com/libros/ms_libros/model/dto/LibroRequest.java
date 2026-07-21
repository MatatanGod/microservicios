package com.libros.ms_libros.model.dto;
import lombok.Data;

@Data
public class LibroRequest {
    private String titulo;
    private String autor;
    private Integer stock;
}