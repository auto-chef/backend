package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.model.OrderModel;

public record RegisterOrderDTO(Long id) {
    public RegisterOrderDTO(OrderModel order) {
        this(order.getId());
    }
}
