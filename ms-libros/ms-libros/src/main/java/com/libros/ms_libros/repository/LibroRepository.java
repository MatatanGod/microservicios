package com.libros.ms_libros.repository;
import com.libros.ms_libros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}