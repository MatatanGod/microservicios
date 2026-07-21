package com.libros.ms_prestamos.repository;
import com.libros.ms_prestamos.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}