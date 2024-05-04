package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.dto.orderItem.DetailsOrderItemDTO;
import br.com.autochef.AutoChef.enums.OrderStatus;
import br.com.autochef.AutoChef.model.OrderModel;

import java.util.List;

public record DetailsOrderDTO(
        Long id,
        OrderStatus status,
        String feedbackDescription,
        Integer feedbackRate,
        List<DetailsOrderItemDTO> items,
        Long restaurantId,
        Long userId
) {
    public DetailsOrderDTO(OrderModel order) {
        this(
                order.getId(),
                order.getStatus(),
                order.getFeedbackDescription(),
                order.getFeedbackRate(),
                order.getOrderItems().stream().map(DetailsOrderItemDTO::new).toList(),
                order.getRestaurant().getId(),
                order.getUser().getId()
        );
    }
}
