package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.order.DetailsOrderDTO;
import br.com.autochef.AutoChef.dto.order.RegisterOrderDTO;
import br.com.autochef.AutoChef.dto.order.UpdateOrderDTO;
import br.com.autochef.AutoChef.model.OrderModel;
import br.com.autochef.AutoChef.repository.OrderRepository;

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
@RequestMapping("orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<RegisterOrderDTO> createOrder(UriComponentsBuilder uriBuilder){
        var order = new OrderModel();
        orderRepository.save(order);

        var uri = uriBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();
        return  ResponseEntity.created(uri).body(new RegisterOrderDTO(order));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<UpdateOrderDTO> updateOrder(@PathVariable("id")Long id, @RequestBody UpdateOrderDTO updateOrderDTO){
        var order = orderRepository.getReferenceById(id);
        order.updateData(updateOrderDTO);

        return ResponseEntity.ok(new UpdateOrderDTO(order));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id){
        orderRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetailsOrderDTO> getOrderById(@PathVariable("id") Long id){
        var order = orderRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetailsOrderDTO(order));
    }

    @GetMapping
    public ResponseEntity<List<DetailsOrderDTO>> getOrderList(Pageable pageable){
        Pageable pg = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").ascending());

        var orderList = orderRepository.findAll(pg).stream().map(DetailsOrderDTO::new).toList();
        return ResponseEntity.ok(orderList);
    }
}
