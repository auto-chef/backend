package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.enums.OrderStatus;
import br.com.autochef.AutoChef.model.OrderModel;

public record DetailsOrderDTO(Long id, OrderStatus status, String feedbackDescription, Integer feedbackRate) {
    public DetailsOrderDTO(OrderModel order) {
        this(order.getId(), order.getStatus(), order.getFeedbackDescription(), order.getFeedbackRate());
    }
}
