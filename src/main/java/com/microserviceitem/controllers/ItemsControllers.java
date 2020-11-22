package com.microserviceitem.controllers;

import com.microserviceitem.entities.Items;
import com.microserviceitem.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemsControllers {

    @Autowired
    @Qualifier("serviceRestTemplate")//para rest template con balanceador de carga
//    @Qualifier("serviceFeign")//para feign con balanceador de carga
    ItemService itemService;//se especifica qyue el controller seria implementado desde la implementaciondel
    //service pero con feign segun el nombre que el decorador tiene  en dicho implementacion
    //en su anotacion de service

    @GetMapping(value = "/list/items")
    public List<Items> getItems() {
        return itemService.getAllItems();
    }

    @GetMapping(value = "/item/product/{productId}/quantity/{quantity}")
    public Items getAItem(@PathVariable("productId") Long productId, @PathVariable("quantity") Integer quantity) {
        return itemService.getItemById(productId, quantity);
    }
}
