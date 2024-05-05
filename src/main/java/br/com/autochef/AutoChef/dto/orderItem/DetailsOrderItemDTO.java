package br.com.autochef.AutoChef.dto.orderItem;

import br.com.autochef.AutoChef.dto.product.DetailsProductDTO;
import br.com.autochef.AutoChef.model.OrderItemModel;
import br.com.autochef.AutoChef.model.ProductModel;

public record DetailsOrderItemDTO(Long id, String changes, int amount, DetailsProductDTO product) {
    public DetailsOrderItemDTO(OrderItemModel orderItem){

        this(
                orderItem.getId(),
                orderItem.getOrderChange(),
                orderItem.getAmount(),
                new DetailsProductDTO(orderItem.getProduct())
        );
    }
}
