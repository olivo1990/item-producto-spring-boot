package com.springboot.app.itemproducto.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.itemproducto.clientes.IProductoClienteRest;
import com.springboot.app.itemproducto.models.ItemPoducto;

@Service("itemServiceFeign")
public class ItemServiceFeign implements IItemService {
	
	@Autowired
	private IProductoClienteRest clienteFeign;

	@Override
	public List<ItemPoducto> findAll() {
		
		return clienteFeign.listar().stream().map(p -> new ItemPoducto(p, 1)).collect(Collectors.toList());
	}

	@Override
	public ItemPoducto findById(Long id, Integer cantidad) {
		return new ItemPoducto(clienteFeign.buscar(id), cantidad);
	}

}
