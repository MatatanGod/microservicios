package com.libros.ms_libros.service;

import com.libros.ms_libros.model.Libro;
import com.libros.ms_libros.model.dto.LibroRequest;
import com.libros.ms_libros.model.dto.LibroResponse;
import com.libros.ms_libros.model.mapper.LibroMapper;
import com.libros.ms_libros.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;
    private final LibroMapper libroMapper;


    public List<LibroResponse> listarTodos() {
        return libroRepository.findAll()
                .stream()
                .map(libroMapper::toResponse)
                .toList();
    }


    public LibroResponse buscarPorId(Long id) {
        Libro libro = obtenerEntidad(id);
        return libroMapper.toResponse(libro);
    }


    public LibroResponse guardar(LibroRequest request) {
        Libro libro = libroMapper.toEntity(request);

        return libroMapper.toResponse(
                libroRepository.save(libro)
        );
    }


    public LibroResponse actualizar(Long id, LibroRequest request) {

        Libro libro = obtenerEntidad(id);

        libro.setTitulo(request.getTitulo());
        libro.setAutor(request.getAutor());
        libro.setStock(request.getStock());

        return libroMapper.toResponse(
                libroRepository.save(libro)
        );
    }


    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }


    public void descontarStock(Long id) {

        Libro libro = obtenerEntidad(id);

        if (libro.getStock() <= 0) {
            throw new RuntimeException(
                    "No hay stock disponible del libro: "
                            + libro.getTitulo()
            );
        }

        libro.setStock(libro.getStock() - 1);

        libroRepository.save(libro);
    }


    private Libro obtenerEntidad(Long id) {

        return libroRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Libro no encontrado con id: " + id
                        )
                );
    }
}