package com.microserviceitem.servicesImpl;

import com.microserviceitem.entities.Items;
import com.microserviceitem.entities.Products;
import com.microserviceitem.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("serviceRestTemplate")
public class ItemServicesImpl implements ItemService {

    @Autowired
    RestTemplate clientRestTemplate;

    @Override
    public List<Items> getAllItems() {
//        List<Products> allItems = Arrays.asList(clientRestTemplate.getForObject("http://localhost:8000/product/list", Products[].class));
        List<Products> allItems = Arrays.asList(clientRestTemplate.getForObject("http://micro-products/product/list", Products[].class));
        //En el caso de que se use Loadbalace mediante rest template no se hace necesario anotar el puerto , sino que simplemente
        //se procederia a sustituir deicho valor del local host por el nombre del microservicio al cual queremos acceder , para
        //ello se va a la clase Source (de donde se extrae la informacion) y se toma el nombre de la aplicacion(micro-products)
        //Desacoplando completamente cualquier puerto o conexion de manera explicita
        List<Items> items = allItems.stream().map(products -> new Items(products, 1)).collect(Collectors.toList());
        return items;
    }

    @Override
    public Items getItemById(Long productId, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("productId", productId.toString());
        //Products product = clientRestTemplate.getForObject("http://localhost:8000/product/detail/{productId}", Products.class, pathVariables);

        Products product = clientRestTemplate.getForObject("http://micro-products/product/detail/{productId}", Products.class, pathVariables);
        //En el caso de que se use Loadbalace mediante rest template no se hace necesario anotar el puerto , sino que simplemente
        //se procederia a sustituir deicho valor del local host por el nombre del microservicio al cual queremos acceder , para
        //ello se va a la clase Source (de donde se extrae la informacion) y se toma el nombre de la aplicacion(micro-products)
        //Desacoplando completamente cualquier puerto o conexion de manera explicita

        return new Items(product, quantity);
    }
}
