package br.com.autochef.AutoChef.controller;

import br.com.autochef.AutoChef.dto.order.DetailsOrderDTO;
import br.com.autochef.AutoChef.dto.order.RegisterOrderDTO;
import br.com.autochef.AutoChef.dto.order.UpdateOrderDTO;
import br.com.autochef.AutoChef.model.OrderItemModel;
import br.com.autochef.AutoChef.model.OrderModel;
import br.com.autochef.AutoChef.repository.OrderRepository;

import br.com.autochef.AutoChef.repository.ProductRepository;
import br.com.autochef.AutoChef.repository.RestaurantRepository;
import br.com.autochef.AutoChef.repository.UserRepository;
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
@RequestMapping("orders") // http://localhost:8080/orders
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetailsOrderDTO> createOrder(UriComponentsBuilder uriBuilder, @RequestBody RegisterOrderDTO registerOrderDTO) {
        var restaurant = restaurantRepository.getReferenceById(registerOrderDTO.restaurantId());
        var user = userRepository.getReferenceById(registerOrderDTO.userId());

        var order = new OrderModel(user, restaurant);
        order.setOrderItems(registerOrderDTO.items().stream().map(item -> new OrderItemModel(item, productRepository.getReferenceById(item.productId()), order)).toList());
        orderRepository.save(order);

        var uri = uriBuilder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DetailsOrderDTO(order));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetailsOrderDTO> updateOrder(@PathVariable("id")Long id, @RequestBody UpdateOrderDTO updateOrderDTO){
        var order = orderRepository.getReferenceById(id);
        order.updateData(updateOrderDTO);

        return ResponseEntity.ok(new DetailsOrderDTO(order));
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
