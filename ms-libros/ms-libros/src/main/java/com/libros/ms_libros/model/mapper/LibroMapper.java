package com.libros.ms_libros.model.mapper;
import com.libros.ms_libros.model.Libro;
import com.libros.ms_libros.model.dto.LibroRequest;
import com.libros.ms_libros.model.dto.LibroResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibroMapper {
    Libro toEntity(LibroRequest request);
    LibroResponse toResponse(Libro libro);
}