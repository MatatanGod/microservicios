package com.libros.ms_prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients // <-- activa el LibroClient
public class MsPrestamosApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsPrestamosApplication.class, args);
	}
}