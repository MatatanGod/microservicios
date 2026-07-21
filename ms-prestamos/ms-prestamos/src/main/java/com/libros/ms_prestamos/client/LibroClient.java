package com.libros.ms_prestamos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "ms-libros") // <-- debe coincidir con spring.application.name de ms-libros
public interface LibroClient {

    @PutMapping("/libros/{id}/descontar-stock")
    void descontarStock(@PathVariable("id") Long id);
}