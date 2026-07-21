package com.biblioteca.msprestamos.repository;

import com.biblioteca.msprestamos.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}