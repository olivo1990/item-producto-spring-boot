package com.springboot.app.itemproducto.models.services;

import java.util.List;

import com.springboot.app.itemproducto.models.ItemPoducto;

public interface IItemService {
	public List<ItemPoducto> findAll();
	public ItemPoducto findById(Long id, Integer cantidad);
}
