package com.spring.shopsmart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopsmart.model.Items;
import com.spring.shopsmart.repository.ItemRepository;


@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Items> fetchAllItems() {
		 
		return itemRepository.fetchAllItems();
	}
	
	public void softDelete(String iid) {
		itemRepository.softDelete(Integer.parseInt(iid));
		
	}

}

