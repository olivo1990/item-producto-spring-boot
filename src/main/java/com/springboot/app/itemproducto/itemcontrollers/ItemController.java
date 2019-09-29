package com.springboot.app.itemproducto.itemcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.itemproducto.models.ItemPoducto;
import com.springboot.app.itemproducto.models.services.IItemService;

@RestController
@RequestMapping("/servicio/itemproducto")
public class ItemController {
	
	@Autowired
	//@Qualifier("itemServiceFeign")
	@Qualifier("itemServiceRestTemplate")
	private IItemService itemService;
	
	@GetMapping("/listar")
	public List<ItemPoducto> listar(){
		return itemService.findAll();
	}
	
	@PostMapping("/buscar")
	public ItemPoducto buscar(@RequestParam("id") Long id, @RequestParam("cantidad") Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
	
}
