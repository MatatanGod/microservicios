package com.biblioteca.ms_prestamos.model.mapper;

import com.biblioteca.msprestamos.model.Prestamo;
import com.biblioteca.msprestamos.model.dto.PrestamoRequest;
import com.biblioteca.msprestamos.model.dto.PrestamoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PrestamoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaPrestamo", ignore = true)
    @Mapping(target = "fechaDevolucion", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Prestamo toEntity(PrestamoRequest request);

    PrestamoResponse toResponse(Prestamo prestamo);
}