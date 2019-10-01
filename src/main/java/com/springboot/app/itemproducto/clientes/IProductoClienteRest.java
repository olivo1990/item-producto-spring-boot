package com.springboot.app.itemproducto.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.app.itemproducto.models.Producto;

@FeignClient(name="servicio-productos")
public interface IProductoClienteRest {
	
	@GetMapping("/listar")
	public List<Producto> listar();
	
	@PostMapping("/buscar")
	public Producto buscar(@RequestParam("id") Long id);
	
}
