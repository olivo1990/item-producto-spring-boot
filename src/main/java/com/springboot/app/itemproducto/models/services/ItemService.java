package com.springboot.app.itemproducto.models.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.springboot.app.itemproducto.models.ItemPoducto;
import com.springboot.app.itemproducto.models.Producto;

@Service("itemServiceRestTemplate")
public class ItemService implements IItemService {
	
	@Autowired
	private RestTemplate clienteRest;
	private String urlServicioProducto = "http://localhost:8001/servicio/producto";

	@Override
	public List<ItemPoducto> findAll() {
		List<Producto> productos = Arrays.asList(clienteRest.getForObject(this.urlServicioProducto + "/listar", Producto[].class));
		
		return productos.stream().map(p -> new ItemPoducto(p, 1)).collect(Collectors.toList());
	}

	@Override
	public ItemPoducto findById(Long id, Integer cantidad) {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/x-www-form-urlencoded");
		
		MultiValueMap<String, String> pathVariables = new LinkedMultiValueMap<>();
		pathVariables.add("id", id.toString());
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(pathVariables, headers);
			
		Producto producto = clienteRest.postForObject(this.urlServicioProducto + "/buscar", request, Producto.class);
		return new ItemPoducto(producto, cantidad);
	}
	
	
}
