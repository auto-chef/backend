package br.com.autochef.AutoChef.dto.orderItem;

import br.com.autochef.AutoChef.model.OrderItemModel;

public record DetailsOrderItemDTO(Long id, String changes, int amount) {

    public DetailsOrderItemDTO(OrderItemModel orderItem){

        this(orderItem.getId(), orderItem.getOrderChange(), orderItem.getAmount());
    }
}
