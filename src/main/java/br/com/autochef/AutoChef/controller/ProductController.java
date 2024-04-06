package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.product.DetailsProductDTO;
import br.com.autochef.AutoChef.dto.product.RegisterProductDTO;
import br.com.autochef.AutoChef.dto.product.UpdateProductDTO;
import br.com.autochef.AutoChef.model.ProductModel;
import br.com.autochef.AutoChef.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("products") // http://localhost:8080/products
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<RegisterProductDTO> createProduct(@RequestBody RegisterProductDTO registerProduct, UriComponentsBuilder uriBuilder){
        var product = new ProductModel(registerProduct);
        productRepository.save(product);

        var uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
        return  ResponseEntity.created(uri).body(new RegisterProductDTO(product));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<UpdateProductDTO> updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductDTO updateProductDTO){
        var productUpdate = productRepository.getReferenceById(id);
        productUpdate.update(updateProductDTO);

        return ResponseEntity.ok(new UpdateProductDTO(productUpdate));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<DetailsProductDTO> deleteProduct(@PathVariable("id") Long id){
        productRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsProductDTO> getProductById(@PathVariable("id") Long id){
        var product = productRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetailsProductDTO(product));
    }

    @GetMapping
    public ResponseEntity<List<DetailsProductDTO>> getProductList(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").ascending());
        var listProduct = productRepository.findAll(pg).stream().map(DetailsProductDTO::new).toList();

        return ResponseEntity.ok(listProduct);
    }
}
