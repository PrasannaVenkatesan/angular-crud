package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Items;
import com.example.repository.ItemRepository;

@RestController
@RequestMapping("/api/Items")
public class ItemController {
	
	@Autowired
	  private ItemRepository repo;
	  
	  @RequestMapping(method = RequestMethod.GET)
	  public List<Items> findItems() {
	    return repo.findAll();
	  }
	  
	  @RequestMapping(method = RequestMethod.POST)
	  public Items addItems(@RequestBody Items Items) {
	    Items.setId(null);
	    return repo.saveAndFlush(Items);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public Items updateItems(@RequestBody Items updatedItems, @PathVariable Integer id) {
	    updatedItems.setId(id);
	    return repo.saveAndFlush(updatedItems);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteItems(@PathVariable Integer id) {
	    repo.delete(id);
	  }
}
