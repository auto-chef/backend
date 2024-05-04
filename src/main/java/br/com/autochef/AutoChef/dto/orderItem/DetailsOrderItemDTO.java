package br.com.autochef.AutoChef.dto.orderItem;

import br.com.autochef.AutoChef.model.OrderItemModel;

public record DetailsOrderItemDTO(
        Long id,
        String changes,
        int amount,
        Long productId,
        Long orderId
) {
    public DetailsOrderItemDTO(OrderItemModel orderItem){

        this(
                orderItem.getId(),
                orderItem.getOrderChange(),
                orderItem.getAmount(),
                orderItem.getProduct().getId(),
                orderItem.getOrder().getId()
        );
    }
}
