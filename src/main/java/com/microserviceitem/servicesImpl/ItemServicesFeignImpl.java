package com.microserviceitem.servicesImpl;

import com.microserviceitem.clientsFeign.ProductClientRest;
import com.microserviceitem.entities.Items;
import com.microserviceitem.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceFeign")
public class ItemServicesFeignImpl implements ItemService {
    @Autowired
    private ProductClientRest productClientRest;

    @Override
    public List<Items> getAllItems() {
        List<Items>items=productClientRest.getAllProducts().stream().map(products -> new Items(products,1)).collect(Collectors.toList());
        return items;
    }

    @Override
    public Items getItemById(Long productId, Integer quantity) {
        Items item=new Items(productClientRest.getAProduct(productId),quantity);
        return item;
    }
}
