package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.product.RegisterProduct;
import br.com.autochef.AutoChef.dto.restaurant.RegisterRestaurantDto;
import br.com.autochef.AutoChef.model.ProductModel;
import br.com.autochef.AutoChef.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("products")//localhost:8080/products
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<RegisterProduct> post(@RequestBody RegisterProduct registerProduct,
                                                     UriComponentsBuilder uriBuilder){
        var product = new ProductModel(registerProduct);
        productRepository.save(product);
        var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return  ResponseEntity.created(uri).body(new RegisterProduct(product));
    }

}
