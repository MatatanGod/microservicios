package com.libros.ms_descubridor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsDescubridorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDescubridorApplication.class, args);
	}

}
