package com.microserviceitem.services;

import com.microserviceitem.entities.Items;

import java.util.List;

public interface ItemService {

    public List<Items> getAllItems();

    public Items getItemById(Long productId,Integer quantity);
}
