package com.libros.ms_prestamos.model.mapper;
import com.libros.ms_prestamos.model.Prestamo;
import com.libros.ms_prestamos.model.dto.PrestamoRequest;
import com.libros.ms_prestamos.model.dto.PrestamoResponse;
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