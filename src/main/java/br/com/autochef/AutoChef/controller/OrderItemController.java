package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.orderItem.DetailsOrderItemDTO;
import br.com.autochef.AutoChef.dto.orderItem.RegisterOrderItemDTO;
import br.com.autochef.AutoChef.dto.product.DetailsProductDTO;
import br.com.autochef.AutoChef.dto.product.RegisterProductDTO;
import br.com.autochef.AutoChef.model.OrderItemModel;
import br.com.autochef.AutoChef.model.ProductModel;
import br.com.autochef.AutoChef.repository.OrderitemRepository;
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
@RequestMapping("orderItens")//localhost:8080/orderItens
public class OrderItemController {

    @Autowired
    private OrderitemRepository orderitemRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<RegisterOrderItemDTO> post(@RequestBody RegisterOrderItemDTO registerOrderItemDTO,
                                                     UriComponentsBuilder uriBuilder){
        var orderItem = new OrderItemModel(registerOrderItemDTO);
        orderitemRepository.save(orderItem);
        var uri = uriBuilder.path("/orderItens/{id}").buildAndExpand(orderItem.getId()).toUri();
        return  ResponseEntity.created(uri).body(new RegisterOrderItemDTO(orderItem));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<DetailsOrderItemDTO> delete(@PathVariable("id") Long id){
        orderitemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<DetailsOrderItemDTO>> getAll(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by("id").ascending());
        var listOrderItem = orderitemRepository.findAll(pg).stream().
                map(DetailsOrderItemDTO::new).toList();
        return ResponseEntity.ok(listOrderItem);
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsOrderItemDTO> getby(@PathVariable("id") Long id){
        var orderItem = orderitemRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailsOrderItemDTO(orderItem));
    }
}
