package com.springboot.app.itemproducto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringBootServicioItemproductoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServicioItemproductoApplication.class, args);
	}

}
