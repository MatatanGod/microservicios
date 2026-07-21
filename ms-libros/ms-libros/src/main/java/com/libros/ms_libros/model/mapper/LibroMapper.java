package com.biblioteca.mslibros.model.mapper;

import com.biblioteca.mslibros.model.Libro;
import com.biblioteca.mslibros.model.dto.LibroRequest;
import com.biblioteca.mslibros.model.dto.LibroResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") // <-- MapStruct genera la implementación en tiempo de compilación
public interface LibroMapper {
    Libro toEntity(LibroRequest request);
    LibroResponse toResponse(Libro libro);
}