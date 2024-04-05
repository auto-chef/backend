package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.enums.OrderStatus;
import br.com.autochef.AutoChef.model.OrderModel;

public record UpdateOrderDTO(OrderStatus status, String feedbackDescription, Integer feedbackRate) {
    public UpdateOrderDTO(OrderModel order) {
        this(order.getStatus(), order.getFeedbackDescription(), order.getFeedbackRate());
    }
}
