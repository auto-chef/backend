package br.com.autochef.AutoChef.dto.order;

import br.com.autochef.AutoChef.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateOrderDTO(
        OrderStatus status,
        @NotBlank @Size(max=355)
        String feedbackDescription,
        @Size(min=0, max=5)
        Integer feedbackRate) {
}
