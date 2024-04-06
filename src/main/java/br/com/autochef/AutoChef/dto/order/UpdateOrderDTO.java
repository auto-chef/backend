package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.enums.OrderStatus;

public record UpdateOrderDTO(OrderStatus status, String feedbackDescription, Integer feedbackRate) {
}
