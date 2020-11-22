package com.microserviceitem.clientsFeign;

import com.microserviceitem.entities.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "micro-products"
//        , url = "localhost:8000" ya no es necesario pues por balanceo de ribbons esto se pasa al application
        //properties con las demas instancias
)
public interface ProductClientRest {

    @GetMapping(value = "/product/list")
    public List<Products> getAllProducts();

    @GetMapping(value = "/product/detail/{productId}")
    public Products getAProduct(@PathVariable("productId") Long productId);
}
