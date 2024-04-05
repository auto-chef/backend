package br.com.autochef.AutoChef.dto.orderItem;

import br.com.autochef.AutoChef.model.OrderItemModel;

public record DetailsOrderItemDTO(String orderChange, int amount) {

    public DetailsOrderItemDTO(OrderItemModel orderItemModel){

        this(orderItemModel.getOrderChange(), orderItemModel.getAmount());
    }
}
